package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dao.BaseDao;
import com.bank.dao.loginDao;
import com.bank.entity.Account;

public class loginDaoImpl extends BaseDao implements loginDao {

Connection conn = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rs = null;
	@Override
	public Account login(String cardno, String pwd) {
		Account ac = null;
		try {
			conn = this.getConnection();
			String sql = "SELECT * FROM `account`WHERE `cardno` = ? AND `password` = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardno);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ac = new Account();
				ac.setCardno(rs.getString("cardno"));
				ac.setPassword(rs.getString("password"));
				ac.setBalance(rs.getDouble("balance"));
				ac.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return ac;
	}

}
