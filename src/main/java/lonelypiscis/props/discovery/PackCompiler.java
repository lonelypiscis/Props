package lonelypiscis.props.discovery;

import java.nio.file.Path;

import lonelypiscis.props.struct.StructProp;
import lonelypiscis.props.utils.Check;
import lonelypiscis.props.utils.Debug;
import lonelypiscis.props.utils.PNS;

public class PackCompiler extends PNS {

	@Check
	public Path path_respackRootOut; 		// Output respack's root directory (which contains the pack.mcmeta file)
	@Check
	public Path path_headerDirectoryIn;		// Input header directory (by default at /config/props/source/headers/)
	@Check
	public Path path_modelDirectoryIn;		// Input header directory (by default at /config/props/source/models/)

	/**
	 * Checks if the compiler data ist set completely so that the compilation
	 * process can work properly. Only runs in debug mode, otherwise returns
	 * true.
	 * 
	 * @return the check's result
	 */

	public boolean isSetUpProperly() {
		if (!Debug.enabled)
			return true;

		return Debug.areCheckableFieldsSet(this);
	}

	/**
	 * Compiles a prop data structure and outputs it into the specified output
	 * respack root.
	 * 
	 * Checks if all compiler data is set.
	 * 
	 * @TODO Add functionality for creating the replaced item's model files that
	 *       can be saved into the resource pack aswell.
	 * 
	 * @param structPropIn
	 * @param path_outputLocation
	 * 
	 * @throws IllegalStateException
	 *             When compiler is not set up properly.
	 */

	public void compileStruct(StructProp structPropIn) {
		if (!isSetUpProperly())
			throw new IllegalStateException(
					"All path variables must be set before any compilation states become legal.");

	}
}
