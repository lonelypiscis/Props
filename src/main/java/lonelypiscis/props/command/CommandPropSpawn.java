package lonelypiscis.props.command;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.blockray.BlockRay;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Predicates;

import lonelypiscis.props.prop.Prop;
import lonelypiscis.props.prop.PropEntity;
import lonelypiscis.props.struct.StructProp;
import lonelypiscis.props.utils.PNS;

public class CommandPropSpawn implements CommandExecutor {

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		if (src instanceof Player) {
			Player player = (Player) src;

			Location<World> propLoc = parseLocation(src, args);

			String propId = (String) args.getOne(Text.of("prop_id")).get();
			String variant = (String) args.getOne(Text.of("variant")).orElse("base");

			StructProp prop = PNS.getRegistry().getProp(propId);

			PropEntity.spawnSolidProp(prop.variants.get(variant), propLoc, Cause.source(src).build());

		}

		return CommandResult.success();
	}

	public Location<World> parseLocation(CommandSource src, CommandContext args) {
		if (src instanceof Player) {
			String kind = (String) args.getOne(Text.of("location behaviour")).orElse("position");

			Player player = (Player) src;
			World world = player.getWorld();

			Vector3i playerBlockPos = null;
			Location<World> propLoc = null;

			if (kind.equalsIgnoreCase("position")) {
				playerBlockPos = player.getLocation().getBlockPosition();
				propLoc = new Location<World>(world, playerBlockPos);
			} else if (kind.equalsIgnoreCase("target_replace")) {
				BlockRay<World> blockRay = BlockRay.from(player)
						.skipFilter(BlockRay.continueAfterFilter(BlockRay.onlyAirFilter(), 1)).build();

				playerBlockPos = blockRay.end().get().getBlockPosition();
				propLoc = new Location<World>(world, playerBlockPos);
			} else if (kind.equalsIgnoreCase("target_side")) {
				BlockRay<World> blockRay = BlockRay.from(player).distanceLimit(5).stopFilter(BlockRay.onlyAirFilter())
						.build();

				playerBlockPos = blockRay.end().get().getBlockPosition();
				propLoc = new Location<World>(world, playerBlockPos);
			}

			return propLoc;
		}

		return null;
	}

	public static CommandSpec commandSpec() {
		return CommandSpec.builder().permission("props.prop.spawn").description(Text.of("Spawn a prop."))
				.executor(new CommandPropSpawn())
				.arguments(GenericArguments.string(Text.of("prop_id")),
						GenericArguments.optional(GenericArguments.string(Text.of("variant"))),
						GenericArguments.optional(GenericArguments.string(Text.of("location behaviour"))))
				.build();
	}

}
