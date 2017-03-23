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

public class ViewPokemonCard extends JFrame {

	private PokedeckController controller;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewPokemonCard (PokedeckController ctrl, String pkmName, String pkmType, int pkmHp, String pkmStage, String pkmEvolution, String pkmDesc) {
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
		
		JLabel pkmNameField = new JLabel("");
		pkmNameField.setText(pkmName);
		pkmNameField.setBounds(117, 79, 227, 25);
		detailPanel.add(pkmNameField);
		
		//------------ TYPE FIELD ---------------
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(48, 118, 46, 14);
		detailPanel.add(lblType);
		
		JLabel pkmTypeField = new JLabel("");
		pkmTypeField.setText(pkmType);
		pkmTypeField.setBounds(117, 112, 227, 25);
		detailPanel.add(pkmTypeField);
		
		//------------ STAGE FIELD ---------------
		JLabel lblStage = new JLabel("Stage");
		lblStage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStage.setBounds(48, 156, 46, 14);
		detailPanel.add(lblStage);
		
		JLabel pkmStageField = new JLabel("");
		pkmStageField.setText(pkmStage);
		pkmStageField.setBounds(117, 148, 227, 25);
		detailPanel.add(pkmStageField);
		
		//------------ EVOL FIELD ---------------
		JLabel lblEvolutionOf = new JLabel("Evolution of");
		lblEvolutionOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEvolutionOf.setBounds(48, 195, 69, 14);
		detailPanel.add(lblEvolutionOf);
		
		JLabel pkmEvolutionField = new JLabel("");
		pkmEvolutionField.setText(pkmEvolution);
		pkmEvolutionField.setBounds(127, 190, 217, 25);
		detailPanel.add(pkmEvolutionField);
		
		//------------ DESC FIELD ---------------
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescription.setBounds(48, 239, 69, 14);
		detailPanel.add(lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(48, 262, 296, 126);
		detailPanel.add(scrollPane);
		
		JTextPane pkmDescField = new JTextPane();
		pkmDescField.setEditable(false);
		scrollPane.setViewportView(pkmDescField);
		pkmDescField.setText(pkmDesc);
	}
}
