import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import cards.PokemonType;
import javax.swing.JRadioButton;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import cards.TrainerType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddCardWindow extends JFrame {

	private JPanel contentPane;
	private JTextField pkmnNameField;
	private JTextField pkmnHpField;
	private JTextField pkmnEvolutionField;
	private JTextField trainerNameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCardWindow frame2 = new AddCardWindow();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public AddCardWindow() {
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
		
		/*
		 * Header decoration
		 */
		JLabel headerImg = new JLabel("");
		headerImg.setBounds(-8, -11, 480, 170);
		headerImg.setIcon(new ImageIcon(AddCardWindow.class.getResource("/pictures/pkmn_header.png")));
		contentPane.add(headerImg);
		
		/*
		 * Creation of a tabbedPane for multiple forms
		 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(41, 180, 380, 511);
		contentPane.add(tabbedPane);
		
		/*
		 * Creation of a container (panel) for each tab
		 * ## "new pokemon card" tab
		 */
		JPanel pkmnPanel = new JPanel();
		pkmnPanel.setForeground(new Color(0, 0, 0));
		pkmnPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New Pokemon card", null, pkmnPanel, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		pkmnPanel.setLayout(null);
		
		/*
		 * Name label + input
		 */
		JLabel lblPkmnName = new JLabel("Name");
		lblPkmnName.setBounds(41, 11, 46, 14);
		pkmnPanel.add(lblPkmnName);
		
		pkmnNameField = new JTextField();
		pkmnNameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent getVal) {
				try{
					String pkmnNameValue = pkmnNameField.getText();
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		pkmnNameField.setBounds(41, 30, 290, 20);
		pkmnPanel.add(pkmnNameField);
		pkmnNameField.setColumns(10);
		
		/*
		 * Type label + input
		 */
		JLabel lblPkmnType = new JLabel("Type");
		lblPkmnType.setBounds(41, 61, 46, 14);
		pkmnPanel.add(lblPkmnType);
		
		JComboBox pkmnComboBox = new JComboBox();
		pkmnComboBox.setBackground(new Color(255, 255, 255));
		pkmnComboBox.setModel(new DefaultComboBoxModel(PokemonType.values()));
		pkmnComboBox.setBounds(41, 81, 290, 20);
		pkmnPanel.add(pkmnComboBox);
		
		/*
		 * HP label + input
		 */
		JLabel lblHp = new JLabel("HP");
		lblHp.setBounds(41, 112, 46, 14);
		pkmnPanel.add(lblHp);
		
		pkmnHpField = new JTextField();
		pkmnHpField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent getVal) {
				try{
					String pkmnHpValue = pkmnHpField.getText();
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		pkmnHpField.setColumns(10);
		pkmnHpField.setBounds(41, 131, 290, 20);
		pkmnPanel.add(pkmnHpField);
		
		/*
		 * Stage label + radio buttons
		 */
		JLabel lblStage = new JLabel("Stage");
		lblStage.setBounds(41, 162, 46, 14);
		pkmnPanel.add(lblStage);
		
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
		
		 //Group radio buttons
	    ButtonGroup stageBtnGroup = new ButtonGroup();
	    stageBtnGroup.add(rdbtnBase);
	    stageBtnGroup.add(rdBtn1);
	    stageBtnGroup.add(rdBtn2);
		
		/*
		 * Evolution of label + input
		 */
		JLabel lblEvolution = new JLabel("Evolution of (only if stage 1 or 2)");
		lblEvolution.setBounds(41, 204, 241, 14);
		pkmnPanel.add(lblEvolution);
		
		pkmnEvolutionField = new JTextField();
		pkmnEvolutionField.setColumns(10);
		pkmnEvolutionField.setBounds(41, 223, 290, 20);
		pkmnPanel.add(pkmnEvolutionField);
		
		/*
		 * Description label + textArea
		 */
		JLabel lblPkmnDesc = new JLabel("Description");
		lblPkmnDesc.setBounds(41, 254, 130, 14);
		pkmnPanel.add(lblPkmnDesc);
		
		TextArea pkmnTextArea = new TextArea();
		pkmnTextArea.setBounds(41, 274, 290, 52);
		pkmnPanel.add(pkmnTextArea);
		
		JLabel lblTest = new JLabel("New label");
		lblTest.setBounds(41, 362, 46, 14);
		pkmnPanel.add(lblTest);
		
		
		/*
		 * Add button to save the form
		 */
		//----BUTTON DESIGN----
		JButton pkmnAddBtn = new JButton("ADD");
		pkmnAddBtn.setForeground(new Color(255, 255, 255));
		pkmnAddBtn.setBackground(new Color(220, 20, 60));
		pkmnAddBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		pkmnAddBtn.setBounds(101, 434, 180, 30);
		
		//----BUTTON INTERACTION----
		pkmnAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pkmnHpValue = pkmnHpField.getText();
				lblTest.setText(pkmnHpValue);
			}
		});
		pkmnPanel.add(pkmnAddBtn);
		
		
		
		/*
		 * ## NEW trainer card panel
		 */
		JPanel trainerPanel = new JPanel();
		trainerPanel.setLayout(null);
		trainerPanel.setForeground(Color.BLACK);
		trainerPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("New Trainer card", null, trainerPanel, null);
		
		JLabel lblTrainerName = new JLabel("Name");
		lblTrainerName.setBounds(41, 11, 46, 14);
		trainerPanel.add(lblTrainerName);
		
		trainerNameField = new JTextField();
		trainerNameField.setColumns(10);
		trainerNameField.setBounds(41, 30, 290, 20);
		trainerPanel.add(trainerNameField);
		
		JLabel lblTrainerType = new JLabel("Type");
		lblTrainerType.setBounds(41, 61, 46, 14);
		trainerPanel.add(lblTrainerType);
		
		JComboBox trainerComboBox = new JComboBox();
		trainerComboBox.setModel(new DefaultComboBoxModel(TrainerType.values()));
		trainerComboBox.setBackground(Color.WHITE);
		trainerComboBox.setBounds(41, 81, 290, 20);
		trainerPanel.add(trainerComboBox);
		
		JLabel lblTrainerDesc = new JLabel("Description");
		lblTrainerDesc.setBounds(41, 112, 130, 14);
		trainerPanel.add(lblTrainerDesc);
		
		TextArea trainerTextArea = new TextArea();
		trainerTextArea.setBounds(41, 132, 290, 144);
		trainerPanel.add(trainerTextArea);
		
		JLabel lblTrainerRule = new JLabel("Rule");
		lblTrainerRule.setBounds(41, 289, 46, 14);
		trainerPanel.add(lblTrainerRule);
		
		TextArea ruletextArea = new TextArea();
		ruletextArea.setBounds(42, 311, 290, 85);
		trainerPanel.add(ruletextArea);
		
		JButton trainerAddBtn = new JButton("ADD");
		trainerAddBtn.setForeground(Color.WHITE);
		trainerAddBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		trainerAddBtn.setBackground(new Color(220, 20, 60));
		trainerAddBtn.setBounds(97, 421, 180, 30);
		trainerPanel.add(trainerAddBtn);
		
		/*
		 *  ##NEW Energy card panel
		 */
		JPanel energyPanel = new JPanel();
		energyPanel.setLayout(null);
		energyPanel.setForeground(Color.BLACK);
		energyPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("New Energy card", null, energyPanel, null);
		
		JLabel lblEnergyType = new JLabel("Type");
		lblEnergyType.setBounds(40, 27, 46, 14);
		energyPanel.add(lblEnergyType);
		
		JComboBox energyComboBox = new JComboBox();
		energyComboBox.setModel(new DefaultComboBoxModel(PokemonType.values()));
		energyComboBox.setBackground(Color.WHITE);
		energyComboBox.setBounds(40, 47, 290, 20);
		energyPanel.add(energyComboBox);
		
		JButton energyAddBtn = new JButton("ADD");
		energyAddBtn.setForeground(Color.WHITE);
		energyAddBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		energyAddBtn.setBackground(new Color(220, 20, 60));
		energyAddBtn.setBounds(97, 95, 180, 30);
		energyPanel.add(energyAddBtn);
		
	}
}
