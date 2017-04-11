package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Privilege;
import cn.bjtc.model.Staff;
import cn.bjtc.model.Supplier;
import cn.bjtc.view.PrivilegeView;
import cn.bjtc.view.StaffView;
import cn.bjtc.view.SupplierView;

public interface ISupplierDAO {
	public int saveSupplier(SupplierView view);
	public int updateSupplier(SupplierView view);
	public List<Supplier> findAllSupplier(SupplierView view);
	public Integer countAllSupplier(SupplierView view);
}
