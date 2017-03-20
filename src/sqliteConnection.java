import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn = null;
	
	public static Connection dbConnect(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src\\database\\pokedeckDb.sqlite");
			JOptionPane.showMessageDialog(null, "Welcome to your Pokedeck !", "Successfully connected", JOptionPane.PLAIN_MESSAGE);
			return conn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
