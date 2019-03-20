package command.library;

import org.junit.Before;
import org.junit.Test;

import console.Console;
import helpers.TestHelper;

/**
 * Exit is a command, but its functionality is handled by {@link Console}
 */
public class CmdEnterBlankTest extends CmdTest {

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();
		
		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here.
		this.commandInvoker.addCommand(new CmdEnter("", this.drive));
	}
	
	@Test
	public void whenNothingIsTypedNoErrorGiven() {

        // when
        executeCommand(" ");
        
        // then
        TestHelper.assertOutputIsEmpty(testOutput);
	}
}
