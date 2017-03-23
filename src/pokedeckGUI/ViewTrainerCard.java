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

public class ViewTrainerCard extends JFrame {

	private PokedeckController controller;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewTrainerCard (PokedeckController ctrl, String trainerName, String trainerType, String trainerDesc, String trainerRule) {
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
		detailPanel.setBounds(45, 199, 386, 486);
		contentPane.add(detailPanel);
		detailPanel.setLayout(null);
		
		JLabel lblCardDetails = new JLabel("DETAILS");
		lblCardDetails.setAlignmentY(Component.CENTER_ALIGNMENT);
		lblCardDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCardDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCardDetails.setBounds(148, 22, 172, 25);
		detailPanel.add(lblCardDetails);
		
		//------------ NAME FIELD ---------------
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblName.setBounds(48, 85, 46, 14);
		detailPanel.add(lblName);
		
		JLabel trainerNameField = new JLabel("");
		trainerNameField.setText(trainerName);
		trainerNameField.setBounds(117, 79, 227, 25);
		detailPanel.add(trainerNameField);
		
		//------------ TYPE FIELD ---------------
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(48, 118, 46, 14);
		detailPanel.add(lblType);
		
		JLabel trainerTypeField = new JLabel("");
		trainerTypeField.setText(trainerType);
		trainerTypeField.setBounds(117, 112, 227, 25);
		detailPanel.add(trainerTypeField);
		
		//------------ DESCRIPTION FIELD ---------------
		JLabel lblDesc = new JLabel("Description");
		lblDesc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesc.setBounds(48, 158, 69, 14);
		detailPanel.add(lblDesc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(48, 181, 296, 126);
		detailPanel.add(scrollPane);
		
		JTextPane trainerDescField = new JTextPane();
		trainerDescField.setEditable(false);
		scrollPane.setViewportView(trainerDescField);
		trainerDescField.setText(trainerDesc);
		
		//------------ RULE FIELD ---------------
		JLabel lblRule = new JLabel("Rule");
		lblRule.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRule.setBounds(48, 328, 69, 14);
		detailPanel.add(lblRule);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 350, 296, 63);
		detailPanel.add(scrollPane_1);
		
		JTextPane trainerRuleField = new JTextPane();
		scrollPane_1.setViewportView(trainerRuleField);
		trainerRuleField.setText(trainerRule);
		trainerRuleField.setEditable(false);
	}
}
