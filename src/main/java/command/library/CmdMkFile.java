/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import interfaces.IDrive;
import interfaces.IOutputter;
import command.framework.Command;
import filesystem.File;

class CmdMkFile extends Command {

	public CmdMkFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		String fileContent = this.getParameterAt(1);
		File newFile = new File(fileName, fileContent);
		if(this.getDrive().getItemFromPath(this.getDrive().getCurrentDirectory().getPath() + "\\" + fileName)==null){
		this.getDrive().getCurrentDirectory().add(newFile);
		}else{
			outputter.printLine("Duplicate File/Dir exist");
		}
	}

	@Override
    protected boolean checkNumberOfParameters(int numberOfParametersEntered) {
    	return numberOfParametersEntered == 2 || numberOfParametersEntered == 1;
    }
}
