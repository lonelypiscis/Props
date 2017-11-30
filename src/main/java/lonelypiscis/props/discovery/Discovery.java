package lonelypiscis.props.discovery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.spongepowered.api.config.ConfigDir;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;

import lonelypiscis.props.struct.StructProp;
import lonelypiscis.props.utils.PNS;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

public final class Discovery extends PNS {

	@Inject
	@ConfigDir(sharedRoot = false)
	public Path path_configDir;

	public Path path_modelSources;
	
	/**
	 * Reads all .conf files and stores an according StructProp object in the output array.
	 * 
	 * @param sourceDirIn
	 * @param propStructsOut
	 */

	public void readSourceFiles(Path sourceDirIn, ArrayList<StructProp> propStructsOut) {
		if (sourceDirIn.toFile().isFile()) throw new IllegalArgumentException("sourceDirIn must be a directory.");
		if (!sourceDirIn.toFile().exists()) throw new IllegalArgumentException("The directory specified by sourceDirIn does not exist.");
		
		for (File sourceFile : sourceDirIn.toFile().listFiles()) {
			if (sourceFile.isFile() && sourceFile.getName().contains("conf")) {
				ConfigurationLoader<CommentedConfigurationNode> loader = HoconConfigurationLoader.builder()
						.setFile(sourceFile).build();

				try {
					ConfigurationNode root = loader.load();

					StructProp structPropOut = root.getValue(TypeToken.of(StructProp.class));
					
					propStructsOut.add(structPropOut);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ObjectMappingException e) {
					e.printStackTrace();
				}
			}
		}
	}

}