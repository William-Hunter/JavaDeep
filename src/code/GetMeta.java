package code;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetMeta {
	static Logger logger = LoggerFactory.getLogger(GetMeta.class);
	static String sql;
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	static ResultSetMetaData rsmd;

	public static void main(String[] args) {
		try {
			GetMeta ge = new GetMeta();
			if (ge.isContect()) {
				logger.debug("数据库已经连接上");
				ge.select("*");
//				ge.insert(34,"jame");
				
			} else {
				logger.debug("数据库连接失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	GetMeta() {
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
	ResultSet query(String sql, Object[] param) {
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i + 1, param[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	int update(String sql, Object[] param) {
		int rows = 0;
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i + 1, param[i]);
			}
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	void show(ResultSet rs) { // 全无硬编码
		try {
			rsmd = rs.getMetaData();
			List list = new ArrayList();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
				list.add(rsmd.getColumnName(i));
			}
			System.out.println();
			rs.first();
			while (!rs.isAfterLast()&&rs!=null) {
				for (Object e : list) {
					System.out.print(rs.getObject((String) e) + "\t");
				}
				System.out.println();
				rs.next();
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			logger.debug("没有结果集");
			return;
		}
	}
	void show(int rows){
		System.out.println("有"+rows+"行被改变");
	}

	void select(Object param1) {
		sql = "SELECT * FROM one WHERE id=?";
		Object[] param = { param1 };
		show(query(sql, param));
	}
	void insert(Object param1,Object param2){
		sql = "INSERT INTO one(id,name) VALUES(?,?)";
		Object[] param = { param1,param2 };
		show(update(sql, param));
	}
	
}
