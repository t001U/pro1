package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.financingproduct;

public interface FinancingproductDao {

	public List<financingproduct> getFinancingproductAllInfo();
	
	public int addingInfo(String id,int risk,String income,String saleStarting,String saleEnd,String end);

	public int deletInfo(String id);
	
	public int updateInfo(int risk,String income,String saleStarting,String saleEnd,String end,String id);

	public financingproduct quertUpdateInfo(String id);
}
