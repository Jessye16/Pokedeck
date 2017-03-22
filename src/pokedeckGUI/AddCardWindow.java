package pokedeckGUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.PokemonType;
import model.TrainerType;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.PokedeckController;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class AddCardWindow extends JFrame {

	private PokedeckController controller;
	private JPanel contentPane;
	private JTextField pkmnNameField;
	private JTextField pkmnHpField;
	private JTextField pkmnEvolutionField;
	private JTextField trainerNameField;


	/**
	 * Create the frame.
	 */
	public AddCardWindow(PokedeckController ctrl) {
		controller = ctrl;
		setAlwaysOnTop(true);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setTitle("Add card");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddCardWindow.class.getResource("/pictures/pokeball.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 100, 480, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*--------------------
		 * Header decoration
		---------------------*/
		JLabel headerImg = new JLabel("");
		headerImg.setBounds(-8, -11, 480, 170);
		headerImg.setIcon(new ImageIcon(AddCardWindow.class.getResource("/pictures/pkmn_header.png")));
		contentPane.add(headerImg);
		
		/*---------------------------------------------
		 * Creation of a panel with tabs for multiple forms
		----------------------------------------------- */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(41, 180, 380, 511);
		contentPane.add(tabbedPane);
		
		/*--------------------------------------------------------------
		 *	NEW POKEMON CARD PANEL
		 ---------------------------------------------------------------*/
		JPanel pkmnPanel = new JPanel();
		pkmnPanel.setForeground(new Color(0, 0, 0));
		pkmnPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New Pokemon card", null, pkmnPanel, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		pkmnPanel.setLayout(null);
		
		//--------------- POKEMON NAME -------------------
		//Pokemon name label
		JLabel lblPkmnName = new JLabel("Name");
		lblPkmnName.setBounds(41, 11, 46, 14);
		pkmnPanel.add(lblPkmnName);
		
		//Pokemon name textField
		pkmnNameField = new JTextField();
		pkmnNameField.setBounds(41, 30, 290, 20);
		pkmnPanel.add(pkmnNameField);
		pkmnNameField.setColumns(10);
		
		//--------------- POKEMON TYPE -------------------
		//Pokemon name label
		JLabel lblPkmnType = new JLabel("Type");
		lblPkmnType.setBounds(41, 61, 46, 14);
		pkmnPanel.add(lblPkmnType);
		
		//Pokemon name comboBox
		JComboBox pkmnComboBox = new JComboBox();
		pkmnComboBox.setBackground(new Color(255, 255, 255));
		pkmnComboBox.setModel(new DefaultComboBoxModel(PokemonType.values()));
		pkmnComboBox.setBounds(41, 81, 290, 20);
		pkmnPanel.add(pkmnComboBox);
		
		//--------------- POKEMON HP -------------------
		//Pokemon HP label
		JLabel lblHp = new JLabel("HP");
		lblHp.setBounds(41, 112, 46, 14);
		pkmnPanel.add(lblHp);
		
		//Pokemon HP textField
		pkmnHpField = new JTextField();
		pkmnHpField.setColumns(10);
		pkmnHpField.setBounds(41, 131, 290, 20);
		pkmnPanel.add(pkmnHpField);
		
		//--------------- POKEMON STAGE -------------------
		//Pokemon stage label
		JLabel lblStage = new JLabel("Stage");
		lblStage.setBounds(41, 162, 46, 14);
		pkmnPanel.add(lblStage);
		
		//3 Radio buttons
		JRadioButton rdbtnBase = new JRadioButton("Base");
		rdbtnBase.setBackground(new Color(255, 255, 255));
		rdbtnBase.setBounds(41, 177, 54, 23);
		rdbtnBase.setSelected(true);
		pkmnPanel.add(rdbtnBase);
		
		JRadioButton rdBtn1 = new JRadioButton("1");
		rdBtn1.setBackground(Color.WHITE);
		rdBtn1.setBounds(95, 177, 36, 23);
		pkmnPanel.add(rdBtn1);
		
		JRadioButton rdBtn2 = new JRadioButton("2");
		rdBtn2.setBackground(Color.WHITE);
		rdBtn2.setBounds(135, 177, 36, 23);
		pkmnPanel.add(rdBtn2);
		
		//Group of radio buttons
	    ButtonGroup stageBtnGroup = new ButtonGroup();
	    stageBtnGroup.add(rdbtnBase);
	    stageBtnGroup.add(rdBtn1);
	    stageBtnGroup.add(rdBtn2);
		
	    //--------------- POKEMON EVOLUTION -------------------
	  	//Pokemon evolution label
		JLabel lblEvolution = new JLabel("Evolution of (only if stage 1 or 2)");
		lblEvolution.setBounds(41, 204, 241, 14);
		pkmnPanel.add(lblEvolution);
		
		//POkemon evolution textField
		pkmnEvolutionField = new JTextField();
		pkmnEvolutionField.setColumns(10);
		pkmnEvolutionField.setBounds(41, 223, 290, 20);
		pkmnPanel.add(pkmnEvolutionField);
		
		//--------------- POKEMON DESCRIPTION -------------------
		//Pokemon desc label
		JLabel lblPkmnDesc = new JLabel("Description");
		lblPkmnDesc.setBounds(41, 254, 130, 14);
		pkmnPanel.add(lblPkmnDesc);
		
		//Pokemon desc textArea
		JScrollPane pkmnScrollPane = new JScrollPane();
		pkmnScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pkmnScrollPane.setBounds(40, 273, 291, 143);
		pkmnPanel.add(pkmnScrollPane);
		
		JTextArea pkmnTextArea = new JTextArea();
		pkmnScrollPane.setViewportView(pkmnTextArea);
		pkmnTextArea.setWrapStyleWord(true);
		pkmnTextArea.setLineWrap(true);
		
		
		//--------------- POKEMON ADD BUTTON -------------------
		//Pokemon add button
		JButton pkmnAddBtn = new JButton("ADD");
		pkmnAddBtn.setForeground(new Color(255, 255, 255));
		pkmnAddBtn.setBackground(new Color(220, 20, 60));
		pkmnAddBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		pkmnAddBtn.setBounds(101, 434, 180, 30);
		// --- add button action ---
		pkmnAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		pkmnPanel.add(pkmnAddBtn);
		
		
		/*--------------------------------------------------------------
		 *	NEW TRAINER CARD PANEL
		 ---------------------------------------------------------------*/
		JPanel trainerPanel = new JPanel();
		trainerPanel.setLayout(null);
		trainerPanel.setForeground(Color.BLACK);
		trainerPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("New Trainer card", null, trainerPanel, null);
		
		//--------------- NAME -------------------
		//Trainer name label
		JLabel lblTrainerName = new JLabel("Name");
		lblTrainerName.setBounds(41, 11, 46, 14);
		trainerPanel.add(lblTrainerName);
		
		//Trainer name textField
		trainerNameField = new JTextField();
		trainerNameField.setColumns(10);
		trainerNameField.setBounds(41, 30, 290, 20);
		trainerPanel.add(trainerNameField);
		
		//--------------- TYPE -------------------
		//Trainer type label
		JLabel lblTrainerType = new JLabel("Type");
		lblTrainerType.setBounds(41, 61, 46, 14);
		trainerPanel.add(lblTrainerType);
		
		//Trainer type comboBox
		JComboBox trainerComboBox = new JComboBox();
		trainerComboBox.setModel(new DefaultComboBoxModel(TrainerType.values()));
		trainerComboBox.setBackground(Color.WHITE);
		trainerComboBox.setBounds(41, 81, 290, 20);
		trainerPanel.add(trainerComboBox);
		
		//--------------- DESCRIPTION -------------------
		//Trainer description label
		JLabel lblTrainerDesc = new JLabel("Description");
		lblTrainerDesc.setBounds(41, 112, 130, 14);
		trainerPanel.add(lblTrainerDesc);
		
		//Trainer description textArea
		JScrollPane DescScrollPane = new JScrollPane();
		DescScrollPane.setAutoscrolls(true);
		DescScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		DescScrollPane.setBounds(41, 132, 290, 146);
		trainerPanel.add(DescScrollPane);
		
		JTextArea trainerDescTextArea = new JTextArea();
		DescScrollPane.setViewportView(trainerDescTextArea);
		trainerDescTextArea.setLineWrap(true);
		trainerDescTextArea.setWrapStyleWord(true);

		
		//--------------- RULE -------------------
		//Trainer rule label
		JLabel lblTrainerRule = new JLabel("Rule");
		lblTrainerRule.setBounds(41, 289, 46, 14);
		trainerPanel.add(lblTrainerRule);
		
		//Trainer rule textField
		JScrollPane ruleScrollPane = new JScrollPane();
		ruleScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ruleScrollPane.setAutoscrolls(true);
		ruleScrollPane.setBounds(41, 308, 290, 88);
		trainerPanel.add(ruleScrollPane);
		
		JTextArea trainerRuleTextArea = new JTextArea();
		trainerRuleTextArea.setWrapStyleWord(true);
		trainerRuleTextArea.setLineWrap(true);
		trainerRuleTextArea.setDoubleBuffered(true);
		ruleScrollPane.setViewportView(trainerRuleTextArea);
		
		// ------------- ADD BUTTON ---------------
		JButton trainerAddBtn = new JButton("ADD");
		trainerAddBtn.setForeground(Color.WHITE);
		trainerAddBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		trainerAddBtn.setBackground(new Color(220, 20, 60));
		trainerAddBtn.setBounds(97, 421, 180, 30);
		//--- add button action ---
		trainerAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String trainerNameValue = trainerNameField.getText();
				TrainerType trainerTypeValue = (TrainerType)trainerComboBox.getSelectedItem();
				String trainerDescValue = trainerDescTextArea.getText();
				String trainerRuleValue = trainerRuleTextArea.getText();
				
				controller.addTrainerCard(trainerNameValue, trainerTypeValue, trainerDescValue, trainerRuleValue);
			}
		});
		trainerPanel.add(trainerAddBtn);
		
		
		/*--------------------------------------------------------------
		 *	NEW ENERGY CARD PANEL
		 ---------------------------------------------------------------*/
		JPanel energyPanel = new JPanel();
		energyPanel.setLayout(null);
		energyPanel.setForeground(Color.BLACK);
		energyPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("New Energy card", null, energyPanel, null);
		
		//--------------- TYPE -------------------
		//Energy type label
		JLabel lblEnergyType = new JLabel("Type");
		lblEnergyType.setBounds(40, 27, 46, 14);
		energyPanel.add(lblEnergyType);
		
		//Energy type comboBox
		JComboBox energyComboBox = new JComboBox();
		energyComboBox.setModel(new DefaultComboBoxModel(PokemonType.values()));
		energyComboBox.setBackground(Color.WHITE);
		energyComboBox.setBounds(40, 47, 290, 20);
		energyPanel.add(energyComboBox);
		
		//--------------- ADD BUTTON -------------------
		//Energy add button
		JButton energyAddBtn = new JButton("ADD");
		energyAddBtn.setForeground(Color.WHITE);
		energyAddBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		energyAddBtn.setBackground(new Color(220, 20, 60));
		energyAddBtn.setBounds(97, 95, 180, 30);
		energyPanel.add(energyAddBtn);
		
	}
}
