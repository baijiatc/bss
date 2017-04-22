package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Product;
import cn.bjtc.view.ProductView;

public interface IProdDAO {

	public int saveProd(ProductView view);
	public int updateProd(ProductView view);
	public List<Product> findAllProds(ProductView view);
	public Integer countAllProds(ProductView view);
}
