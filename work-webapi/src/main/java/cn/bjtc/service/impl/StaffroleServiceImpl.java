package cn.bjtc.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IStaffroleDAO;
import cn.bjtc.model.Staffrole;
import cn.bjtc.service.IStaffroleService;

@Service("staffroleService")
public class StaffroleServiceImpl implements IStaffroleService {

	public int createStaffrole(Object staffid,Object roleids) {
		String rids = roleids.toString();
		if(rids != "" && rids != null){
			String roids[] = rids.split(",");
			for(int i = 0 ;i<roids.length;i++){
				Staffrole staffrole = new Staffrole();
				staffrole.setRoleid(Integer.parseInt(roids[i].toString()));
				staffrole.setStaffid(Integer.parseInt(staffid.toString()));
				staffroleDAO.createStaffrole(staffrole);
			}	
		}
		return 0;
	}


	public int deleteById(Object staffid) {
		return staffroleDAO.deleteById(staffid);
	}
	
	@Autowired
	private IStaffroleDAO staffroleDAO;

}
