package lonelypiscis.props.command;

import java.nio.file.Path;
import java.util.ArrayList;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

import lonelypiscis.props.struct.StructProp;
import lonelypiscis.props.utils.FileUtils;
import lonelypiscis.props.utils.PNS;

public class CommandTest extends PNS implements CommandExecutor  {

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		ArrayList<StructProp> structsOut = new ArrayList<>();
		Path path_sourceDir = getFilePaths().path_configDir.resolve("source/");
		
		getDiscovery().readSourceFiles(path_sourceDir, structsOut);
		
		System.out.println(structsOut.size());
		
		System.out.println(getPackCompiler().isSetUpProperly());
		
		return CommandResult.success();
	}

}
