package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Supplier;
import cn.bjtc.view.SupplierView;

public interface ISupplierService {

	public int saveSupplier(SupplierView view);
	public int updateSupplier(SupplierView view);
	public List<Supplier> findAllSupplier(SupplierView view);
	public Integer countAllSupplier(SupplierView view);
}
