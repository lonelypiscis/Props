package lonelypiscis.props.struct;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class StructProp {
	@Setting(value="prop_id") 		public String id;
	@Setting(value="prop_name") 	public String name;
	@Setting(value="prop_type")		public PropType type;
	
	
	public enum PropType {
		BLOCK, ITEM;
	}
}
