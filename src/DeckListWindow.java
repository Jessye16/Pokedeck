import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeckListWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeckListWindow frame1 = new DeckListWindow();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * Initialize connection to DB
	 */
	Connection conn = null;	
	private JTable table;
	

	/**
	 * Create the frame.
	 */
	public DeckListWindow() {
		conn = sqliteConnection.dbConnect();
		
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
		JButton btnAddCard = new JButton("Add card");
		btnAddCard.setBounds(23, 175, 201, 43);
		btnAddCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCardWindow frame2 = new AddCardWindow();
				frame2.setVisible(true);
			}
		});
		btnAddCard.setRequestFocusEnabled(false);
		btnAddCard.setForeground(new Color(255, 255, 255));
		btnAddCard.setBackground(new Color(65, 105, 225));
		btnAddCard.setFont(new Font("PixelSix10", Font.PLAIN, 14));
		btnAddCard.setIcon(new ImageIcon(DeckListWindow.class.getResource("/pictures/poke-add5.png")));
		contentPane.add(btnAddCard);
		
		/*
		 * See selected card details button
		 */
		JButton btnDeleteSelectedCard = new JButton("Delete selected card");
		btnDeleteSelectedCard.setBounds(116, 229, 234, 43);
		btnDeleteSelectedCard.setForeground(new Color(255, 255, 255));
		btnDeleteSelectedCard.setFont(new Font("PixelSix10", Font.PLAIN, 14));
		btnDeleteSelectedCard.setBackground(new Color(220, 20, 60));
		btnDeleteSelectedCard.setIcon(new ImageIcon(DeckListWindow.class.getResource("/pictures/delete3.png")));
		contentPane.add(btnDeleteSelectedCard);
		
		/*
		 * Delete selected card button
		 */
		JButton btnSeeSelectedCard = new JButton("See selected card");
		btnSeeSelectedCard.setBounds(234, 175, 217, 43);
		btnSeeSelectedCard.setBackground(new Color(255, 204, 0));
		btnSeeSelectedCard.setForeground(new Color(255, 255, 255));
		btnSeeSelectedCard.setFont(new Font("PixelSix10", Font.PLAIN, 14));
		btnSeeSelectedCard.setIcon(new ImageIcon(DeckListWindow.class.getResource("/pictures/see.png")));
		contentPane.add(btnSeeSelectedCard);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 322, 428, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Type"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(337);
		table.getColumnModel().getColumn(1).setPreferredWidth(208);
		scrollPane.setViewportView(table);
	}
}
