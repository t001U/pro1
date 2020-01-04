package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	private static String driver;// 数据库驱动字符串
	private static String url;// 连接URL字符串
	private static String user; // 数据库用户名
	private static String password; // 用户密码
	protected Connection conn = null;
	protected ResultSet rs = null;

	static {// 静态代码块,在类加载的时候执行
		init();
	}

	/**
	 * 初始化连接参数,从配置文件里获得
	 */
	public static void init() {
		Properties params = new Properties();
		String configFile = "database.properties";// 配置文件路径
		// 加载配置文件到输入流中
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(
				configFile);
		try {
			// 从输入流中读取属性列表
			params.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据指定的获取对应的值
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
	}

	// 获取数据库连接对象
	public Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 *            数据库连接
	 * @param stmt
	 *            Statement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// 若结果集对象不为空,则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空,则关闭
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空,则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 增、删、改的操作
	 * 
	 * @param sql
	 *            预编译的 SQL 语句
	 * @param param
	 *            参数的字符串数组
	 * @return 影响的行数
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// 为预编译sql设置参数
					pstmt.setObject(i + 1, param[i]);
				}
			}
			System.out.println("SQL语句：" + pstmt.toString());// 此处打印了对象和
															// 带入参数后的sql语句
			num = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return num;
	}

	/**
	 * 查询的封装
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return 返回结果集
	 */
	public ResultSet executeQuery(String sql, Object[] param) {
		PreparedStatement pstmt = null;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (param != null && !param.equals("")) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			System.out.println("SQL语句：" + pstmt.toString());// 此处打印了对象和
															// 带入参数后的sql语句
			rs = pstmt.executeQuery(); // ResultSet rs=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}