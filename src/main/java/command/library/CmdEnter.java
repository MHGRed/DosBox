package command.library;

import command.framework.Command;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdEnter extends Command {

	protected CmdEnter(String name, IDrive drive) {
		super(name, drive);
	}
	
	@Override
	public void execute(IOutputter outputter) {
		// TODO Auto-generated method stub

	}

}
