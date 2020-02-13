package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.SInvestigateDao;
import com.entity.S_Investigate;

public class SInvestigateDaoImpl extends BaseDao implements SInvestigateDao {
	@Override // 添加
	public int addSInvestigate(S_Investigate obj) {
		// 1 SQL语句
		String sql = "INSERT INTO `s_investigate` (`chk_option`, `chk_name`, `chk_date`, `violat_flag`, `violate_cesc`, `chk_remark`, `app_no`, `prio_code`, `keycons_file`) VALUES (?,?,?,?,?,?,?,?,?)";
		// 2 赋值
		Object[] param = { obj.getChk_option(), obj.getChk_name(), obj.getChk_date(), obj.getViolat_flag(),
				obj.getViolate_cesc(), obj.getChk_remark(), obj.getApp_no(), obj.getPrio_code(),
				obj.getKeycons_file() };
		// 3 执行sql
		int count = this.exceuteUpdate(sql, param);
		// 4 返回结果
		return count;
	}

	@Override
	public List<S_Investigate> findSInv(String chk_option) {
		// 声明提取数据对象
		ResultSet rs = null;
		// 创建集合对象
		List<S_Investigate> list = new ArrayList<S_Investigate>();
		String sql = "select * from s_investigate where 1=1";
		if (chk_option != null && !"".equals(chk_option)) {
			sql = sql + " and chk_option like CONCAT('%',?,'%')";
			Object[] param = { chk_option };
			rs = this.executeQuery(sql, param);
		} else {
			rs = this.executeQuery(sql, null);
		}
		try {
			if (rs != null) {
				while (rs.next()) {
					S_Investigate s = new S_Investigate();
					s.setChk_id(rs.getInt("chk_id"));
					s.setChk_option(rs.getString("chk_option"));
					s.setChk_name(rs.getString("chk_name"));
					s.setChk_date(rs.getString("chk_date"));
					s.setViolat_flag(rs.getString("violat_flag"));
					s.setViolate_cesc(rs.getString("violate_cesc"));
					s.setChk_remark(rs.getString("chk_remark"));
					s.setApp_no(rs.getString("app_no"));
					s.setPrio_code(rs.getString("prio_code"));
					s.setKeycons_file(rs.getString("keycons_file"));
					list.add(s);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 关闭
			this.closeAll(conn, null, rs);
		}
		return list;
	}

	@Override
	public int delSInvestigateId(int id) {
		// 1 SQL语句
		String sql = "delete from s_investigate where chk_id=?";
		// 2 赋值
		Object[] param = { id };
		// 3 执行sql
		int count = this.exceuteUpdate(sql, param);
		// 4 返回结果
		return count;
	}

	@Override
	public S_Investigate findSInvById(int id) {
		ResultSet rsa = null;
		S_Investigate s = new S_Investigate();
		String sql = "select * from s_investigate where chk_id=?";
		Object[] param = { id };
		rsa = this.executeQuery(sql, param);
		try {
			if (rsa != null) {
				while (rsa.next()) {
					s.setChk_id(rs.getInt("chk_id"));
					s.setChk_option(rs.getString("chk_option"));
					s.setChk_name(rs.getString("chk_name"));
					s.setChk_date(rs.getString("chk_date"));
					s.setViolat_flag(rs.getString("violat_flag"));
					s.setViolate_cesc(rs.getString("violate_cesc"));
					s.setChk_remark(rs.getString("chk_remark"));
					s.setApp_no(rs.getString("app_no"));
					s.setPrio_code(rs.getString("prio_code"));
					s.setKeycons_file(rs.getString("keycons_file"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, null, rsa);
		}
		return s;
	}

	@Override
	public int updSInvestigate(S_Investigate obj) {
		// 1 SQL语句
		String sql = "update `s_investigate` set `chk_option`=?,`chk_name`=?, `chk_date`=?, `violat_flag`=?, `violate_cesc`=?, `chk_remark`=?, `app_no`=?, `prio_code`=?, `keycons_file`=? where chk_id=?";
		// 2 赋值
		Object[] param = { obj.getChk_option(), obj.getChk_name(), obj.getChk_date(), obj.getViolat_flag(),
				obj.getViolate_cesc(), obj.getChk_remark(), obj.getApp_no(), obj.getPrio_code(), obj.getKeycons_file(),
				obj.getChk_id() };
		// 3 执行sql
		int count = this.exceuteUpdate(sql, param);
		// 4 返回结果
		return count;
	}

}
