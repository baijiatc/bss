package cn.bjtc.dao.impl;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IRolePrivDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.RolePriv;

@Component("rolePrivDAO")
public class RolePrivDAO extends MyBatisDAO<RolePriv, Integer> implements IRolePrivDAO {

	public int saveRolePriv(RolePriv rolePriv) {
		return super.save("saveRolePriv", rolePriv);
	}

	public int deleteRoleAllPriv(Object roleid) {
		return super.delete("deleteRoleAllPriv", roleid);
	}

}
