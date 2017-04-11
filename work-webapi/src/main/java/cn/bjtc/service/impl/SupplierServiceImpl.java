package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISupplierDAO;
import cn.bjtc.model.Supplier;
import cn.bjtc.service.ISupplierService;
import cn.bjtc.view.SupplierView;

@Service("supplierService")
public class SupplierServiceImpl implements ISupplierService {

	public int saveSupplier(SupplierView view) {
		return supplierDAO.saveSupplier(view);
	}

	public int updateSupplier(SupplierView view) {
		return supplierDAO.updateSupplier(view);
	}

	public List<Supplier> findAllSupplier(SupplierView view) {
		return supplierDAO.findAllSupplier(view);
	}

	public Integer countAllSupplier(SupplierView view) {
		return supplierDAO.countAllSupplier(view);
	}
	
	@Autowired
	private ISupplierDAO supplierDAO;
}
