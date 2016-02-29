package code;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessDatabase {
	static Logger logger = LoggerFactory.getLogger(AccessDatabase.class);
	static String sql;
	static ResultSet rs;
	static Connection con;
	static PreparedStatement ps;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// logger.debug(insert(3,"will")+" row be operator");
		// show(select(12));
		// logger.debug(delete(3)+" row be operator");
		// logger.debug(change(12,"william")+" row be operator");
		// show(selectAll());
		logger.debug("the program is end");
	}

	AccessDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean isContect() throws ClassNotFoundException {
		try {
			if (!con.isClosed()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void show(ResultSet resultSet) throws SQLException {
		System.out.println("The result is:\n-------------------------");
		resultSet.first();
		do {
			System.out.println("id:" + resultSet.getInt("id") + "\tname:" + resultSet.getString("name"));
		} while (resultSet.next());
		System.out.println();
	}

	public static ResultSet select(int key) throws ClassNotFoundException, SQLException {
		sql = "SELECT * FROM one WHERE id= ? "; // 表名不能作为参数
		ps = con.prepareStatement(sql);
		ps.setInt(1, key);
		return ps.executeQuery();
	}

	public static ResultSet selectAll() throws ClassNotFoundException, SQLException {
		sql = "SELECT * FROM one;";
		ps = con.prepareStatement(sql);
		return ps.executeQuery();
	}

	public static int insert(int id, String name) throws ClassNotFoundException, SQLException {
		sql = "INSERT INTO one VALUES( ? , ? )"; // 切记 执行时使用update
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		return ps.executeUpdate();
	}

	public static int delete(int id) throws ClassNotFoundException, SQLException {
		sql = "DELETE FROM one WHERE id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	public static int change(int id, String name) throws ClassNotFoundException, SQLException {
		sql = "UPDATE one SET name = ? WHERE id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, id);
		return ps.executeUpdate();
	}
}