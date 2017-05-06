package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IProdDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Product;
import cn.bjtc.model.Spec;
import cn.bjtc.view.ProductView;

@Component("prodDao")
public class ProdDAOImpl extends MyBatisDAO<Product, Integer>
			implements IProdDAO{

	public int saveProd(ProductView view) {
		Product prod=new Product();
		BeanUtils.copyProperties(view, prod);
		return super.save("saveProd",prod);
	}

	public int updateProd(ProductView view) {
		return super.update("updateProd", view);
	}

	public List<Product> findAllProds(ProductView view) {
		return super.findByParam("findAllProds", view);
	}

	public Integer countAllProds(ProductView view) {
		return super.countByParam("countAllProds", view);
	}
	public List<Product> findAllproBySkuId(Object skuid) {
		return super.findByParam("findAllproBySkuId", skuid);
	}
}
