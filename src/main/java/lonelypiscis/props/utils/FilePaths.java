package lonelypiscis.props.utils;

import java.nio.file.Path;

import org.spongepowered.api.config.ConfigDir;

import com.google.inject.Inject;

public class FilePaths extends PNS {
	@Inject
	@ConfigDir(sharedRoot = false)
	public Path path_configDir;
	
	public Path path_modelSources;
	
	public Path path_respackTemplate_root;
	
	public void init() {
		path_modelSources = path_configDir.resolve("source/headers");
		path_respackTemplate_root = FileUtils.getAssetAsPath("template/respack_template");
	}
	
	
	
}
