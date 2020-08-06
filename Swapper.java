package ps2.iniswapper;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Swapper {

	public static JFrame frame;
	public static JButton air;
	public static JButton tank;
	public static JButton infantry;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new File("C:\\Users\\Public\\Daybreak Game Company\\Installed Games\\PlanetSide 2\\inis").mkdir();
		StartGui();
	}

	public static void BuildGui() {

		frame = new JFrame("INI SWAPPER by Daddy010");
		frame.setSize(350, 100);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);

		air = new JButton("Use Air ini");
		air.setFocusable(false);
		air.addActionListener(e -> {
			try {
				Files.copy(new File(
						"C:\\Users\\Public\\Daybreak Game Company\\Installed Games\\PlanetSide 2\\inis\\air.ini")
								.toPath(),
						new File(
								"C:\\Users\\Public\\Daybreak Game Company\\Installed Games\\PlanetSide 2\\UserOptions.ini")
										.toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		tank = new JButton("Use Tank ini");
		tank.setFocusable(false);
		tank.addActionListener(e -> {
			try {
				Files.copy(new File(
						"C:\\Users\\Public\\Daybreak Game Company\\Installed Games\\PlanetSide 2\\inis\\tank.ini")
								.toPath(),
						new File(
								"C:\\Users\\Public\\Daybreak Game Company\\Installed Games\\PlanetSide 2\\UserOptions.ini")
										.toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		infantry = new JButton("Use Infantry ini");
		infantry.setFocusable(false);
		infantry.addActionListener(e -> {
			try {
				Files.copy(new File(
						"C:\\Users\\Public\\Daybreak Game Company\\Installed Games\\PlanetSide 2\\inis\\infantry.ini")
								.toPath(),
						new File(
								"C:\\Users\\Public\\Daybreak Game Company\\Installed Games\\PlanetSide 2\\UserOptions.ini")
										.toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		frame.add(air);
		frame.add(tank);
		frame.add(infantry);
	}

	public static void StartGui() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				BuildGui();
			}

		});
	}
}
