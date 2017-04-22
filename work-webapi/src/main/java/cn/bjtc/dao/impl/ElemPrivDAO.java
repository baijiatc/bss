package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IElemPrivDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.ElemPriv;

@Component("elemPrivDAO")
public class ElemPrivDAO extends MyBatisDAO<ElemPriv, Integer> implements IElemPrivDAO {

	public List<ElemPriv> findAllElemPrivs() {
		return super.findByParam("findAllElemPrivs", null);
	}

	public List<ElemPriv> findElemPrivByRole(Object roleid) {
		return super.findByParam("findElemPrivByRole", roleid);
	}

	public List<ElemPriv> findElemPrivByStaff(Object staffid) {
		return super.findByParam("findElemPrivByStaff", staffid);
	}

	public List<ElemPriv> findStaffRoleElemPriv(Object staffid) {
		return super.findByParam("findStaffRoleElemPriv", staffid);
	}

}
