import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame {
	GamePanel gPanel = new GamePanel();
	public GameFrame() throws HeadlessException {
		this.setTitle("21µã");
		this.setBounds(0, 0, 800, 600);
		Container c = this.getContentPane();
		c.add(gPanel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GameFrame();
	}

}
