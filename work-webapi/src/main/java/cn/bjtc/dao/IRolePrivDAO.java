package cn.bjtc.dao;

import cn.bjtc.model.RolePriv;

public interface IRolePrivDAO {
	
	public int saveRolePriv(RolePriv rolePriv);
	public int deleteRoleAllPriv(Object roleid);
}
