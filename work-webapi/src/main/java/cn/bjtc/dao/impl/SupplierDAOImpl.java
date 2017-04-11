package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStaffDAO;
import cn.bjtc.dao.ISupplierDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Staff;
import cn.bjtc.model.Supplier;
import cn.bjtc.view.StaffView;
import cn.bjtc.view.SupplierView;

@Component("supplierDAO")
public class SupplierDAOImpl extends MyBatisDAO<Supplier, Integer> implements
		ISupplierDAO {

	public int saveSupplier(SupplierView view) {
		Supplier supplier = new Supplier();
		BeanUtils.copyProperties(view, supplier);
		return super.save("saveSupplier", supplier);
	}

	public int updateSupplier(SupplierView view) {
		return super.update("updateSupplier", view);
	}

	public List<Supplier> findAllSupplier(SupplierView view) {
		return super.findByParam("findAllSupplier", view);
	}

	public Integer countAllSupplier(SupplierView view) {
		return super.countByParam("countAllSupplier", view);
	}

}
