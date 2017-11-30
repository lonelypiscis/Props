package lonelypiscis.props.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.spongepowered.api.asset.Asset;

public class FileUtils extends PNS {
	
	/**
	 * Checks if the specified asset file exists and creates it when needed.
	 * Returns the asset file's path.
	 * 
	 * @param str_assetPath
	 * @return
	 */
	
	public static Path getAssetAsPath(String str_assetPath) {
		Optional<Asset> optAsset = getPlugin().getAsset(str_assetPath);

		if (optAsset.isPresent()) {

			try {
				return Paths.get(URLDecoder.decode(optAsset.get().getUrl().getFile(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();

			}

			return null;

		} else {
			File assetFile = Defaults.path_assetsRoot.resolve(str_assetPath).toFile();

			if (assetFile.isDirectory()) {
				assetFile.mkdirs();
			} else {
				assetFile.getParentFile().mkdirs();
				try {
					assetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("No file has been found at location " + assetFile.toString());
			System.out.println("Creating file instead.");

			return assetFile.toPath();
		}
	}
}
