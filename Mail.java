

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class Mail
{

	public static void main(String[] args) throws Exception
	{
		Robot robot = new Robot();
		StringSelection stringSelection = null;
		Clipboard clipboard = null;
		String path = "C:/Program Files (x86)/gControl/gControl.exe";
		String credential[] = {"hrishikesh.gaikwad@naaptol.com","dada1234#"};
		File file = new File(path);
		
		if (! file.exists()) {
		   throw new IllegalArgumentException("The file " + path + " does not exist");
		}
		
		new ProcessBuilder(file.getAbsolutePath()).start();
		Thread.sleep(8000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		for(int i=0; i< credential.length; i++)
		{
			stringSelection = new StringSelection(credential[i]);
			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			if(i < (credential.length -1))
			{
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			Thread.sleep(2000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}

}
