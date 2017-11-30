package lonelypiscis.props.utils;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.plugin.PluginManager;

import lonelypiscis.props.PropsPlugin;

/**
 * PNS stands for PropsNamespace. When extending this class a child can access certain singletons easily.
 *
 */

public class PNS {
	public PropsPlugin getPluginInstance() {
		return (PropsPlugin) Sponge.getPluginManager().getPlugin("props").get().getInstance().get();
	}
}
