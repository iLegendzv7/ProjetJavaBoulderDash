package model.dao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 * <h1>The Menu Class.</h1>
 *
 */
public class Menu extends JFrame {

	public Menu(){
		 setSize(new Dimension(700, 500));

	        setLayout(new BorderLayout());
	        JLabel background = new JLabel(new ImageIcon("D:/Users/Utilisateur/Documents/Ecole/Projet/Java/Image/background2.jpg"));
	        add(background);
	        background.setLayout(new FlowLayout());
	        this.setVisible(true);
	        this.setLocationRelativeTo(null);
	       
	        

	        
	}
        @SuppressWarnings("static-access")
        public String menuPseudo(){
        JOptionPane jop = new JOptionPane();
        String name = jop.showInputDialog(null, "Please enter your name !", "BoulderDash", JOptionPane.QUESTION_MESSAGE);

            return name;

        }

        @SuppressWarnings("static-access")
        public String menuLevel(){
            String[] mapName = {"map1", "map2", "map3", "map4", "map5"};
            JOptionPane jop2 = new JOptionPane();
            String map = (String)jop2.showInputDialog(null, 
              "Please select a map !",
              "Boulderdash",
              JOptionPane.QUESTION_MESSAGE,
              null,
              mapName,
              mapName[0]);

                return map;
                
            }

    }