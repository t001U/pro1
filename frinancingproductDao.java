package com.Word_Test.Service;
import com.Word_Test.dao.entity.Frinancingproduct;
import java.util.List;
/**
 * ��Ʋ�Ʒ��Ϣ��ҵ���߼���ӿ�
 * @author Administrator
 *
 */
public interface frinancingproductDao {

	/**
	 * ��ѯ������Ʋ�Ʒ��Ϣ
	 * @return
	 */
	public List<Frinancingproduct> selectAllInfo(String value_1,String value_2);
	
	/**
	 * ��ѯ������ֵ
	 * @return ������������
	 */
	public List<String> SelectOption();
	
	/**
	 * ������Ʋ�Ʒ��Ϣ
	 * @return
	 */
	public int addInfo(Frinancingproduct Frinancingproduct);
	
	/**
	 * ͨ��id��ѯ��Ʋ�Ʒ��Ϣ
	 * @param id ��Ʒid
	 * @return ��ѯ�������
	 */
	public Frinancingproduct selectInfoById(String id);
	
	/**
	 * �޸���Ʋ�Ʒ��Ϣ
	 * @param Frinancingproduct ��Ʋ�Ʒ����
	 * @return �޸Ľ��
	 */
	public int UpdateInfo(Frinancingproduct Frinancingproduct);
}
