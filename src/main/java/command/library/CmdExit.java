package command.library;

import command.framework.Command;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdExit extends Command {

	protected CmdExit(String name, IDrive drive) {
		super(name, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		// exit does nothing; delegates action to the Console class.
	}
}
