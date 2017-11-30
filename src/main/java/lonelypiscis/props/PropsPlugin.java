package lonelypiscis.props;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

import lonelypiscis.props.discovery.Discovery;

@Plugin(id = "props", name = "Props Plugin", version = "0.1")
public class PropsPlugin {
	@Inject public Discovery discovery;
	
	@Listener
	public void onServerStart(GameStartedServerEvent evt) {
		System.out.println(discovery.path_configDir);

	}
}
