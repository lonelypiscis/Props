package lonelypiscis.props.struct;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import org.spongepowered.api.item.ItemType;

import lonelypiscis.props.utils.Check;

public class StructCompilationData {
	public boolean hasBeenChecked;
	public boolean canCompile;

	@Check public Path path_respackRootOut; 		// Output respack's root directory (which contains the pack.mcmeta file)
	@Check public Path path_headerDirectoryIn;		// Input header directory (by default at /config/props/source/headers/)
	@Check public Path path_modelDirectoryIn;		// Input header directory (by default at /config/props/source/models/)
	
	@Check public ArrayList<ItemType> items_overrideSockets; 	// ItemTypes whose model data will be overridden

	public Path path_respackModelsOut;				// Respack's models dirctory (/assets/minecraft/models/)
	
	public int num_maxSlots_total;					// Max number of slots possible according to registered override sockets
	public int num_slots_total;						// Number of currently processed prop structures
	
	public int index_currentSocket;					// Index of socket which is currently processed
	public int num_maxSlots_currentSocket;			// Current socket's max number of slots
	public int index_freeSlot_currentSocket;		// Index of current socket's slot which is currently processed
	
	public HashMap<String, Double> damageRelForModel;	// A model path stored with its associated relative damage value


	public StructCompilationData() {
		damageRelForModel = new HashMap<>();
	}
}
