package lonelypiscis.props.discovery;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import org.spongepowered.api.config.ConfigDir;

import com.google.inject.Inject;

import lonelypiscis.props.utils.PNS;

public final class Discovery extends PNS {
	
	@Inject
	@ConfigDir(sharedRoot = false)
	public Path path_configDir;
	
	public Path path_modelSources;
	
	public void gatherSourceFiles(Path sourceDirIn, ArrayList<File> sourceFilesOut) {
		
	}
	
}
