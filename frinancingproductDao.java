package com.Word_Test.Service;
import com.Word_Test.dao.entity.Frinancingproduct;
import java.util.List;
/**
 * 理财产品信息表业务逻辑类接口
 * @author Administrator
 *
 */
public interface frinancingproductDao {

	/**
	 * 查询所有理财产品信息
	 * @return
	 */
	public List<Frinancingproduct> selectAllInfo(String value_1,String value_2);
	
	/**
	 * 查询下拉框值
	 * @return 下拉框结果集合
	 */
	public List<String> SelectOption();
	
	/**
	 * 新增理财产品信息
	 * @return
	 */
	public int addInfo(Frinancingproduct Frinancingproduct);
	
	/**
	 * 通过id查询理财产品信息
	 * @param id 产品id
	 * @return 查询结果对象
	 */
	public Frinancingproduct selectInfoById(String id);
	
	/**
	 * 修改理财产品信息
	 * @param Frinancingproduct 理财产品对象
	 * @return 修改结果
	 */
	public int UpdateInfo(Frinancingproduct Frinancingproduct);
}
