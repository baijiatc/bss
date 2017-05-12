package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IProdDAO;
import cn.bjtc.model.Product;
import cn.bjtc.service.IProdService;
import cn.bjtc.view.ProductView;

@Service("prodService")
public class ProdServiceImpl implements  IProdService{

	public int saveProd(ProductView view) {
		return prodDao.saveProd(view);
	}

	public int updateProd(ProductView view) {
		return prodDao.updateProd(view);
	}

	public List<Product> findAllProds(ProductView view) {
		return prodDao.findAllProds(view);
	}

	public Integer countAllProds(ProductView view) {
		return prodDao.countAllProds(view);
	}

	public List<ProductView> findAllproBySkuId(Object skuid) {
		ProductView view = new ProductView();
		view.setPageSize(100);
		List<Product> allProducts = prodDao.findAllProds(view);
		List<Product> skuProducts = prodDao.findAllproBySkuId(skuid);
		Map<String,Product> skuProductMap = new HashMap<String, Product>();
		for(Product Product : skuProducts){
			skuProductMap.put(Product.getProdname(), Product);
		}
		List<ProductView> views = new ArrayList<ProductView>(allProducts.size());
		for(Product Product : allProducts){
			ProductView ProductView = new ProductView();
			if(skuProductMap.containsKey(Product.getProdname())){
				ProductView.setChecked(true);
			}
			BeanUtils.copyProperties(Product, ProductView);
			views.add(ProductView);
		}
		return views;
	}
		@Autowired
		private IProdDAO prodDao;
}
