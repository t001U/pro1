package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	private static String driver;// ���ݿ������ַ���
	private static String url;// ����URL�ַ���
	private static String user; // ���ݿ��û���
	private static String password; // �û�����
	protected Connection conn = null;
	protected ResultSet rs = null;

	static {// ��̬�����,������ص�ʱ��ִ��
		init();
	}

	/**
	 * ��ʼ�����Ӳ���,�������ļ�����
	 */
	public static void init() {
		Properties params = new Properties();
		String configFile = "database.properties";// �����ļ�·��
		// ���������ļ�����������
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(
				configFile);
		try {
			// ���������ж�ȡ�����б�
			params.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ����ָ���Ļ�ȡ��Ӧ��ֵ
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
	}

	// ��ȡ���ݿ����Ӷ���
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
	 * �ر����ݿ�����
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param stmt
	 *            Statement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// �����������Ϊ��,��ر�
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ��Statement����Ϊ��,��ر�
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �����ݿ����Ӷ���Ϊ��,��ر�
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����ɾ���ĵĲ���
	 * 
	 * @param sql
	 *            Ԥ����� SQL ���
	 * @param param
	 *            �������ַ�������
	 * @return Ӱ�������
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// ΪԤ����sql���ò���
					pstmt.setObject(i + 1, param[i]);
				}
			}
			System.out.println("SQL��䣺" + pstmt.toString());// �˴���ӡ�˶����
															// ����������sql���
			num = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return num;
	}

	/**
	 * ��ѯ�ķ�װ
	 * 
	 * @param sql
	 *            sql���
	 * @param param
	 *            ����
	 * @return ���ؽ����
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
			System.out.println("SQL��䣺" + pstmt.toString());// �˴���ӡ�˶����
															// ����������sql���
			rs = pstmt.executeQuery(); // ResultSet rs=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}