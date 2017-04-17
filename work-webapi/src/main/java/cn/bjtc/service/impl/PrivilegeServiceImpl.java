package cn.bjtc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IElemPrivDAO;
import cn.bjtc.dao.IMenuPrivDAO;
import cn.bjtc.dao.IPrivilegeDAO;
import cn.bjtc.dao.IRolePrivDAO;
import cn.bjtc.dao.IStaffPrivDAO;
import cn.bjtc.model.ElemPriv;
import cn.bjtc.model.MenuPriv;
import cn.bjtc.model.Privilege;
import cn.bjtc.model.RolePriv;
import cn.bjtc.model.StaffPriv;
import cn.bjtc.service.IPrivilegeService;
import cn.bjtc.tools.ApplicationDataManager;
import cn.bjtc.tools.CopyUtils;
import cn.bjtc.view.ElementView;
import cn.bjtc.view.MenuView;
import cn.bjtc.view.PrivilegeView;

@Service("privilegeService")
public class PrivilegeServiceImpl implements IPrivilegeService {

	public int savePriv(PrivilegeView view) {
		return privilegeDAO.savePriv(view);
	}

	public int updatePriv(PrivilegeView view) {
		return privilegeDAO.updatePriv(view);
	}

	public List<Privilege> findAllPrivs(PrivilegeView view) {
		return privilegeDAO.findAllPrivs(view);
	}

	public Integer countAllPrivs(PrivilegeView view) {
		return privilegeDAO.countAllPrivs(view);
	}
	
	public int deleteRoleAllPriv(Object roleid) {
		return rolePrivDAO.deleteRoleAllPriv(roleid);
	}

	public int saveRolePriv(Object roleid, Object menuids, Object elemids) {
		List<Object> mids = (List<Object>) menuids;
		for(Object mid : mids){
			Object privid = ApplicationDataManager.SYSMENUPRIVS.get(ApplicationDataManager.DEFAULT_KEY+mid);
			RolePriv rolePriv = new RolePriv();
			rolePriv.setRoleid(Integer.parseInt(roleid.toString()));
			rolePriv.setPrivid(Integer.parseInt(privid.toString()));
			rolePrivDAO.saveRolePriv(rolePriv);
		}
		List<Object> eids = (List<Object>) elemids;
		for(Object eid : eids){
			Object privid = ApplicationDataManager.SYSELEMPRIVS.get(ApplicationDataManager.DEFAULT_KEY+eid);
			RolePriv rolePriv = new RolePriv();
			rolePriv.setRoleid(Integer.parseInt(roleid.toString()));
			rolePriv.setPrivid(Integer.parseInt(privid.toString()));
			rolePrivDAO.saveRolePriv(rolePriv);
		}
		return 0;
	}

	public int deleteStaffAllPriv(Object staffid) {
		return staffPrivDAO.deleteStaffAllPriv(staffid);
	}

	public int saveStaffPriv(Object staffid, Object menuids, Object elemids) {
		List<Object> mids = (List<Object>) menuids;
		for(Object mid : mids){
			Object privid = ApplicationDataManager.SYSMENUPRIVS.get(ApplicationDataManager.DEFAULT_KEY+mid);
			StaffPriv staffPriv = new StaffPriv();
			staffPriv.setStaffid(Integer.parseInt(staffid.toString()));
			staffPriv.setPrivid(Integer.parseInt(privid.toString()));
			staffPrivDAO.saveStaffPriv(staffPriv);
		}
		List<Object> eids = (List<Object>) elemids;
		for(Object eid : eids){
			Object privid = ApplicationDataManager.SYSELEMPRIVS.get(ApplicationDataManager.DEFAULT_KEY+eid);
			StaffPriv staffPriv = new StaffPriv();
			staffPriv.setStaffid(Integer.parseInt(staffid.toString()));
			staffPriv.setPrivid(Integer.parseInt(privid.toString()));
			staffPrivDAO.saveStaffPriv(staffPriv);
		}
		return 0;
	}

	public List<MenuPriv> findAllMenuPrivs() {
		return menuPrivDAO.findAllMenuPrivs();
	}
	
	public List<ElemPriv> findAllElemPrivs() {
		return elemPrivDAO.findAllElemPrivs();
	}

	public List<Object> loadObjectPriv(Object objid, Object isRole) {
		boolean _isRole = Boolean.valueOf(isRole.toString());
		Map<String,Object> hasElemMap = new HashMap<String, Object>();
		Map<String,Object> staffRoleElemMap = new HashMap<String, Object>();
		Map<String,Object> hasMenuMap = new HashMap<String, Object>();
		Map<String,Object> staffRoleMenuMap = new HashMap<String, Object>();
		if(_isRole){
			List<MenuPriv> mpLst = menuPrivDAO.findMenuPrivByRole(objid);//获取角色已分配的权限
			for(MenuPriv ep : mpLst){
				hasMenuMap.put(ApplicationDataManager.DEFAULT_KEY+ep.getMenuid(), ep.getPrivid());//记录角色已分配的权限
			}
			List<ElemPriv> epLst = elemPrivDAO.findElemPrivByRole(objid);//获取角色已分配的权限
			for(ElemPriv ep : epLst){
				hasElemMap.put(ApplicationDataManager.DEFAULT_KEY+ep.getElemid(), ep.getPrivid());//记录角色已分配的权限
			}
		}else{
			List<MenuPriv> staffRoleMenuPrivLst = menuPrivDAO.findStaffRoleMenuPriv(objid);//获取员工所属角色的权限
			for(MenuPriv ep : staffRoleMenuPrivLst){
				staffRoleMenuMap.put(ApplicationDataManager.DEFAULT_KEY+ep.getMenuid(), ep.getPrivid());//记录员工所属角色的权限
			}
			List<MenuPriv> mpLst = menuPrivDAO.findMenuPrivByStaff(objid);//获取员工单独分配的权限
			for(MenuPriv ep : mpLst){
				hasMenuMap.put(ApplicationDataManager.DEFAULT_KEY+ep.getMenuid(), ep.getPrivid());//记录员工单独分配的权限
			}
			List<ElemPriv> staffRoleElemPrivLst = elemPrivDAO.findStaffRoleElemPriv(objid);//获取员工所属角色的权限
			for(ElemPriv ep : staffRoleElemPrivLst){
				staffRoleElemMap.put(ApplicationDataManager.DEFAULT_KEY+ep.getElemid(), ep.getPrivid());//记录员工所属角色的权限
			}
			List<ElemPriv> epLst = elemPrivDAO.findElemPrivByStaff(objid);//获取员工单独分配的权限
			for(ElemPriv ep : epLst){
				hasElemMap.put(ApplicationDataManager.DEFAULT_KEY+ep.getElemid(), ep.getPrivid());//记录员工单独分配的权限
			}
		}
		int size = ApplicationDataManager.SYSMENUS.size();
		List<Object> treeNodeLst = CopyUtils.deepCopyList(ApplicationDataManager.SYSMENUS);//构建新的权限树副本
		for(int i = 0; i < size; i++){//展开权限树数据集合
			Object[] p2childArr = (Object[]) treeNodeLst.get(i);
			int len = p2childArr.length;
			if(p2childArr == null || p2childArr.length == 0 || p2childArr.length < 2){
				continue;
			}
			List m2elemLst = (List) p2childArr[1];
			for(Object m2e : m2elemLst){
				Object[] m2eArr = (Object[]) m2e;
				if(m2eArr == null || m2eArr.length == 0 || m2eArr.length < 2){
					continue;
				}
				MenuView menu = (MenuView) m2eArr[0];
				if(staffRoleMenuMap.containsKey(ApplicationDataManager.DEFAULT_KEY+menu.getMenuid())){
					menu.setChecked(true);//选中员工所属角色的权限
					menu.setDisabled(true);//将员工所属角色权限设置为禁用状态
				}
				if(hasMenuMap.containsKey(ApplicationDataManager.DEFAULT_KEY+menu.getMenuid())){
					menu.setChecked(true);//如果已经包含该权限，设置为选中
				}
				List elems = (List) m2eArr[1];
				for(Object elemObj : elems){//解析叶节点，及元素权限部分。
					ElementView elem = (ElementView) elemObj;
					if(staffRoleElemMap.containsKey(ApplicationDataManager.DEFAULT_KEY+elem.getElemid())){
						elem.setChecked(true);//选中员工所属角色的权限
						elem.setDisabled(true);//将员工所属角色权限设置为禁用状态
					}
					if(hasElemMap.containsKey(ApplicationDataManager.DEFAULT_KEY+elem.getElemid())){
						elem.setChecked(true);//如果已经包含该权限，设置为选中
					}
				}
			}
		}
		return treeNodeLst;
	}

	@Autowired
	private IPrivilegeDAO privilegeDAO;
	@Autowired
	private IRolePrivDAO rolePrivDAO;
	@Autowired
	private IStaffPrivDAO staffPrivDAO;
	@Autowired
	private IMenuPrivDAO menuPrivDAO;
	@Autowired
	private IElemPrivDAO elemPrivDAO;

}
