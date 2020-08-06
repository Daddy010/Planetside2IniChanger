package ps2.iniswapper;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Swapper {

	public static JFrame frame;
	public static JButton air;
	public static JButton tank;
	public static JButton infantry;
	public static String content;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Settings Directory
		new File("C:\\PS2SwapperSettings").mkdir();
		new File("C:\\PS2SwapperSettings\\inis").mkdir();

		//Check if path.txt file exists, if not opens Prompt to set Directory
		String file_name = "C:\\PS2SwapperSettings\\path.txt";
		File f = new File(file_name);
		if (f.exists() && !f.isDirectory()) {
			StartGui();
		} else {
			pathfile();
		}

	}

	public static void BuildGui() {

		String filename = "C:\\PS2SwapperSettings\\path.txt";
		
		//Read Path from path.txt
		try {
			content = new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		frame = new JFrame("INI SWAPPER by Daddy010");
		frame.setSize(350, 100);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		air = new JButton("Use Air ini");
		air.setFocusable(false);
		air.addActionListener(e -> {
			try {
				Files.copy(new File("C:\\PS2SwapperSettings\\inis\\air.ini").toPath(),
						new File(content + "\\UserOptions.ini").toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		tank = new JButton("Use Tank ini");
		tank.setFocusable(false);
		tank.addActionListener(e -> {
			try {
				Files.copy(new File("C:\\PS2SwapperSettings\\inis\\tank.ini").toPath(),
						new File(content + "\\UserOptions.ini").toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		infantry = new JButton("Use Infantry ini");
		infantry.setFocusable(false);
		infantry.addActionListener(e -> {
			try {
				Files.copy(new File("C:\\PS2SwapperSettings\\inis\\infantry.ini").toPath(),
						new File(content + "\\UserOptions.ini").toPath(), StandardCopyOption.REPLACE_EXISTING);
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

	public static void pathfile() {

		String input = JOptionPane.showInputDialog("Please insert the path to your Planetside 2 Directory");
		File writefile = new File("C:\\PS2SwapperSettings\\path.txt");

		try {
			FileWriter writer = new FileWriter(writefile);
			writer.write(input.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
