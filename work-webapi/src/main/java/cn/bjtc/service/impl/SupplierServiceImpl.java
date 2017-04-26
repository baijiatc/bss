package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

	public List<SupplierView> findAllSupplier(SupplierView view) {
		List<Supplier> Suppliers = supplierDAO.findAllSupplier(view);
		if(Suppliers == null || Suppliers.size() <= 0){
			return new ArrayList<SupplierView>(0);
		}
		List<SupplierView> views = new ArrayList<SupplierView>(Suppliers.size());
		for(Supplier Supplier : Suppliers){
			SupplierView SupplierView = new SupplierView();
			BeanUtils.copyProperties(Supplier, SupplierView);
			views.add(SupplierView);
		}
		return views;
	}

	public Integer countAllSupplier(SupplierView view) {
		return supplierDAO.countAllSupplier(view);
	}
	
	@Autowired
	private ISupplierDAO supplierDAO;
}
