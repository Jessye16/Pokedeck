package pokedeckGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.PokedeckController;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class ViewEnergyCard extends JFrame {

	private PokedeckController controller;
	private JPanel contentPane;
	private JLabel imageLabel;
	
	/**
	 * Create the frame.
	 */
	public ViewEnergyCard (PokedeckController ctrl, String energyType) {
		controller = ctrl;
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Card details");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeckListWindow.class.getResource("/pictures/pokeball.png")));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1000, 100, 480, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/*
		 * Header decoration
		 */
		contentPane.setLayout(null);
		JLabel headerImg = new JLabel("");
		headerImg.setBounds(-4, -14, 485, 170);
		headerImg.setIcon(new ImageIcon(DeckListWindow.class.getResource("/pictures/pkmn_header.png")));
		contentPane.add(headerImg);
		
		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(Color.WHITE);
		detailPanel.setBounds(45, 199, 386, 483);
		contentPane.add(detailPanel);
		detailPanel.setLayout(null);
		
		JLabel lblCardDetails = new JLabel("DETAILS");
		lblCardDetails.setAlignmentY(Component.CENTER_ALIGNMENT);
		lblCardDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCardDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCardDetails.setBounds(148, 22, 172, 25);
		detailPanel.add(lblCardDetails);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(48, 84, 46, 14);
		detailPanel.add(lblType);
		
		JLabel energyTypeField = new JLabel("");
		energyTypeField.setText(energyType);
		energyTypeField.setBounds(117, 78, 227, 25);
		detailPanel.add(energyTypeField);
		
		imageLabel = new JLabel(energyType);
		imageLabel.setIcon(new ImageIcon(ViewEnergyCard.class.getResource("/pictures/"+energyType+".png")));
		imageLabel.setBounds(76, 126, 239, 330);
		detailPanel.add(imageLabel);
	}
}
