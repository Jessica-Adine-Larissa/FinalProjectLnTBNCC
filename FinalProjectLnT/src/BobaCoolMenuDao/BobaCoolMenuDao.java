package BobaCoolMenuDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import db.DBConnect;
public class BobaCoolMenuDao {
	
	Connection connection;
	
	public BobaCoolMenuDao() {
		try {
			initDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void initDB() throws SQLException {
		connection = DBConnect.connect();
		if(connection == null) {
			throw new SQLException("connection");
		}
	}
	public ArrayList<ArrayList<String>> getData() {
		ArrayList<ArrayList<String>> data = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from bobamenu";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			ArrayList<String> row = new ArrayList<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	public void insertData(String kode, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO BOBACOOLMENU VALUES ('"+ kode +"', '"+ nama +"', '"+ harga +"', '"+ stok +"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void UpdateMenu(String code, String price, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "UPDATE MENU SET PRICE='" + price + "', stock='" + stock + "' where menuCode='" + code + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteMenu(String code) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "DELETE FROM MENU WHERE CODE='" + code + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}