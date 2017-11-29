package lonelypiscis.props;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "props", name = "Props Plugin", version = "0.1")
public class PropsPlugin {
	@Listener
	public void onServerStart(GameStartedServerEvent evt) {
		System.out.println("Starting!");
	}
}
