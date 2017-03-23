package pokedeckGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.PokedeckController;
import javax.swing.ListSelectionModel;


public class DeckListWindow extends JFrame {

	private PokedeckController controller;
	private JPanel contentPane;
	
	/*
	 * Create table
	 */
	private JTable table;
	

	/**
	 * Create the frame.
	 */
	public DeckListWindow(PokedeckController ctrl) {	
		controller = ctrl;
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Pokemon Trading Card Game");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeckListWindow.class.getResource("/pictures/pokeball.png")));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 480, 760);
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
		
		/*
		 * Add card button
		 */
		JButton btnAddCard = new JButton("ADD CARD");
		btnAddCard.setBounds(23, 175, 201, 43);
		btnAddCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openAddCardView();
			}
		});
		btnAddCard.setRequestFocusEnabled(false);
		btnAddCard.setForeground(new Color(255, 255, 255));
		btnAddCard.setBackground(new Color(65, 105, 225));
		btnAddCard.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddCard.setIcon(new ImageIcon(DeckListWindow.class.getResource("/pictures/poke-add5.png")));
		contentPane.add(btnAddCard);
		
		/*
		 * Delete selected card details button
		 */
		JButton btnDeleteSelectedCard = new JButton("DELETE SELECTED CARD");
		btnDeleteSelectedCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Trouver la carte que l'on veut supprimer dans la JTable
				int cardIndex = table.getSelectedRow();
				
				if(cardIndex > -1){
					//Supprimer la ligne du JTable
					((DefaultTableModel)table.getModel()).removeRow(cardIndex);
					//Supprimer la carte du deck
					removeRowInTable(cardIndex);
				}
			}
		});
		btnDeleteSelectedCard.setBounds(116, 229, 234, 43);
		btnDeleteSelectedCard.setForeground(new Color(255, 255, 255));
		btnDeleteSelectedCard.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteSelectedCard.setBackground(new Color(220, 20, 60));
		btnDeleteSelectedCard.setIcon(new ImageIcon(DeckListWindow.class.getResource("/pictures/delete3.png")));
		contentPane.add(btnDeleteSelectedCard);
		
		/*
		 * See selected card button
		 */
		JButton btnSeeSelectedCard = new JButton("SEE SELECTED CARD");
		btnSeeSelectedCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Trouver la carte que l'on veut voir dans la JTable
				int cardIndex = table.getSelectedRow();
				
				if(cardIndex > -1){
					controller.openCardView(cardIndex);
				}
			}
		});
		btnSeeSelectedCard.setBounds(234, 175, 217, 43);
		btnSeeSelectedCard.setBackground(new Color(255, 204, 0));
		btnSeeSelectedCard.setForeground(new Color(255, 255, 255));
		btnSeeSelectedCard.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSeeSelectedCard.setIcon(new ImageIcon(DeckListWindow.class.getResource("/pictures/see.png")));
		contentPane.add(btnSeeSelectedCard);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 322, 428, 382);
		contentPane.add(scrollPane);
		
		/*
		 * Pokemon Table
		 */
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Type"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		scrollPane.setViewportView(table);
	}
	
	public void addRowInTable(String name,String type){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{name, type});
	}
	
	public void removeRowInTable(int id){
		controller.removeCard(id);
	}
	
}
