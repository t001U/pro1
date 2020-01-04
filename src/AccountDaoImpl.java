package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dao.AccountDao;
import com.bank.dao.BaseDao;
import com.bank.entity.Account;

public class AccountDaoImpl extends BaseDao implements AccountDao {

	Connection conn = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rs = null;
	@Override
	public Account Balance(String cardno) {
		
		Account ac = new Account();
		try {
			conn = this.getConnection();
			String sql = "SELECT `balance` FROM `account` WHERE `cardno` = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ac.setBalance(rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return ac;
	}
	@Override
	public int Transffer(String transfferOutAccount, String transfferInAccount, double transfferOutMoney,
			double transfferInMoney, double balance, double balance1, String type) {
		
		int row = 0;
		conn = this.getConnection();
		try {
			conn.setAutoCommit(false); // 
			String sql = "UPDATE `account` SET `balance` = `balance` - ? WHERE `cardno` = ?";
			String sql1 = "UPDATE `account` SET `balance` = `balance` + ? WHERE `cardno` = ? ";
			String sql2 = "INSERT INTO `transaction_record`(`cardno`,`transaction_date`,`expense`,`balance`,`transaction_type`)VALUES(?,NOW(),?,?,?)";
			String sql3 = "INSERT INTO `transaction_record`(`cardno`,`transaction_date`,`income`,`balance`,`transaction_type`)VALUES(?,NOW(),?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, transfferOutMoney);
			pstmt.setString(2, transfferOutAccount);
			row = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setDouble(1, transfferInMoney);
			pstmt.setString(2, transfferInAccount);
			row = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, transfferOutAccount);
			pstmt.setDouble(2, transfferOutMoney);
			pstmt.setDouble(3, balance);
			pstmt.setString(4, type);
			row = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, transfferInAccount);
			pstmt.setDouble(2, transfferInMoney);
			pstmt.setDouble(3, balance1);
			pstmt.setString(4, type);
			row = pstmt.executeUpdate();
			conn.commit();//手动提交
		} catch (SQLException e) {
			try {
				conn.rollback(); //回滚事物
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return row;
	}

}
