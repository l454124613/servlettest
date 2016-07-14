package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataBase {
	static Connection conn = null;
	static PreparedStatement pst = null;
	

	public DataBase() throws Exception {
		try {
			Properties.pro_name="data/config.properties";
			Class.forName(Properties.readOne("sqlname"));// 指定连接类型

			conn = DriverManager.getConnection(Properties.readOne("sqlurl"),
					Properties.readOne("sqlusername"), Properties.readOne("sqluserpassword"));// 获取连接
		
		} catch (Exception e) {
			throw new Exception("配置不正确");
		}
	}

	static void  init() throws Exception {
		try {
			Properties.pro_name="data/config.properties";
			Class.forName(Properties.readOne("sqlname"));// 指定连接类型

			conn = DriverManager.getConnection(Properties.readOne("sqlurl"),
					Properties.readOne("sqlusername"), Properties.readOne("sqluserpassword"));// 获取连接

		} catch (Exception e) {
			throw new Exception("配置不正确");
		}
	}
	static void  init(int i) throws Exception {
		try {
			Properties.pro_name="data/config.properties";
			Class.forName(Properties.readOne("sqlname"+String.valueOf(i)));// 指定连接类型
			//System.out.println("sqlname"+String.valueOf(i));
			conn = DriverManager.getConnection(Properties.readOne("sqlurl"+String.valueOf(i)),
					Properties.readOne("sqlusername"+String.valueOf(i)), Properties.readOne("sqluserpassword"+String.valueOf(i)));// 获取连接

		} catch (Exception e) {
			throw new Exception("配置不正确");
		}
	}

	static void close() {
		try {
			conn.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static  int update(String sql) {
		int res = 0;
		try {
			pst = conn.prepareStatement(sql);// 准备执行语句
			res = pst.executeUpdate();// 执行语句，得到结果集

			close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public  static List<Map<String, Object>> select(String sql,int ...a) throws Exception {
		if(a.length==1){
		//	System.out.println(a[0]);
			init(a[0]);
		}else {
		//	System.out.println("??");
		init();}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
		//	System.out.println(sql);
			pst = conn.prepareStatement(sql);// 准备执行语句
			 ResultSet ret = pst.executeQuery();// 执行语句，得到结果集
			java.sql.ResultSetMetaData md = ret.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
			int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
			// Map rowData = new HashMap();

			while (ret.next()) {
				Map<String,Object> rowData = new HashMap<String,Object> (columnCount);
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), ret.getObject(i));
					// System.out.println(md.getColumnName(i) + ":"
					// + ret.getObject(i));
				}
				list.add(rowData);
			}// 显示数据
			ret.close();
			close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
