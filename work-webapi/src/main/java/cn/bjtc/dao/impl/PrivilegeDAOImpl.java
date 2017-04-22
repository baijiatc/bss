package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IPrivilegeDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Privilege;
import cn.bjtc.view.PrivilegeView;

@Component("privilegeDAO")
public class PrivilegeDAOImpl extends MyBatisDAO<Privilege, Integer> implements
		IPrivilegeDAO {

	public int savePriv(PrivilegeView view) {
		Privilege priv = new Privilege();
		BeanUtils.copyProperties(view, priv);
		return super.save("savePriv", priv);
	}

	public int updatePriv(PrivilegeView view) {
		return super.update("updatePriv", view);
	}

	public List<Privilege> findAllPrivs(PrivilegeView view) {
		return super.findByParam("findAllPrivs", view);
	}

	public Integer countAllPrivs(PrivilegeView view) {
		return super.countByParam("countAllPrivs", view);
	}

	public List<Privilege> findCurrentUserPrivs(Object uid) {
		return super.findByParam("findCurrentUserPrivs", uid);
	}

}
