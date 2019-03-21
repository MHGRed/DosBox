/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import helpers.TestHelper;
import filesystem.FileSystemItem;

public class CmdDelFileTest extends CmdTest {

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();
		
		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here.
		this.commandInvoker.addCommand(new CmdDel("del", this.drive));
	}

    @Test
    public void cmdDelFileTest()
    {
        // given
        final String fileName = "FileInRoot1";

        // when
        executeCommand("del " + fileName);

        // then
        assertEquals(numbersOfFilesBeforeTest - 1, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertOutputIsEmpty(testOutput);
        FileSystemItem fileSystemItem = drive.getItemFromPath(drive.getCurrentDirectory().getPath() + "\\" + fileName);
        assertNull(fileSystemItem);
    }
    
    @Test
    public void cmdDelNoFileTest()
    {
        // given
        final String fileName = "nofile";

        // when
        executeCommand("del " + fileName);

        // then
        assertEquals(numbersOfFilesBeforeTest, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertContains("File/Dir not Exist", testOutput);
    }
    
    @Test
    public void cmdDelDirwithFilesTest()
    {
        // given
        final String dirName = "subDir1";

        // when
        executeCommand("del " + dirName);

        // then
        assertEquals(numbersOfFilesBeforeTest, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertOutputIsEmpty(testOutput);
        FileSystemItem fileSystemItem = drive.getItemFromPath(drive.getCurrentDirectory().getPath() + "\\" + dirName);
        assertNull(fileSystemItem);
    }
    
    @Test
    public void cmdDelDirwithoutFilesTest()
    {
        // given
        final String dirName = "subDir2";

        // when
        executeCommand("del " + dirName);

        // then
        assertEquals(numbersOfFilesBeforeTest, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertOutputIsEmpty(testOutput);
        FileSystemItem fileSystemItem = drive.getItemFromPath(drive.getCurrentDirectory().getPath() + "\\" + dirName);
        assertNull(fileSystemItem);
    }
}
