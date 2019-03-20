package command.library;

import org.junit.Before;
import org.junit.Test;

import console.Console;
import helpers.TestHelper;

/**
 * Exit is not really a command, but it is recognized by {@link Console}
 */
public class CmdExitTest extends CmdTest {

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();
		
		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here.
		this.commandInvoker.addCommand(new CmdExit("exit", this.drive));
	}
	
	@Test
	public void whenExitIsTypedNoErrorGiven() {

        // when
        executeCommand("exit");
        
        // then
        TestHelper.assertOutputIsEmpty(testOutput);
	}
}
