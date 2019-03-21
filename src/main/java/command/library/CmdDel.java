/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import interfaces.IDrive;
import interfaces.IOutputter;
import command.framework.Command;
import filesystem.FileSystemItem;

class CmdDel extends Command {

	public CmdDel(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		FileSystemItem fileSystemItem = this.getDrive().getItemFromPath(this.getDrive().getCurrentDirectory().getPath() + "\\" + fileName);
		if(fileSystemItem==null){
			outputter.printLine("File/Dir not Exist");
		}
		this.getDrive().getCurrentDirectory().remove(fileSystemItem);
	}

	@Override
    protected boolean checkNumberOfParameters(int numberOfParametersEntered) {
    	return numberOfParametersEntered == 1;
    }
}
