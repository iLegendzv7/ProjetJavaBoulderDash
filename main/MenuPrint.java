
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrint extends JFrame {
	public MenuPrint() {

		setSize(new Dimension(700, 500));

		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("F:/Projet/3- Projet Java/Images/background2.jpg"));
		add(background);
		background.setLayout(new FlowLayout());

		JPanel boutonPane = new JPanel();

		JButton bouton2 = new JButton("Choose Level");
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String[] level = { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5" };
				JOptionPane jop = new JOptionPane();
				String name = (String) jop.showInputDialog(null, "Choose your level!", "Levels !",
						JOptionPane.QUESTION_MESSAGE, null, level, level[2]);

				System.out.println(name);
				
				if (name == "Level 1"){
					System.out.println("cbhfsjd");
				}

			}
		});

		boutonPane.add(bouton2);

		this.getContentPane().add(boutonPane, BorderLayout.NORTH);
		this.setVisible(true);

	}

}