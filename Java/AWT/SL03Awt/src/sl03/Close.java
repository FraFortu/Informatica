
package sl03;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Close extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); 
	}
}
