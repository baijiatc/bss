package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IBrandDAO;
import cn.bjtc.dao.ICatDAO;
import cn.bjtc.dao.IProdDAO;
import cn.bjtc.model.Activity;
import cn.bjtc.model.Brand;
import cn.bjtc.model.Category;
import cn.bjtc.model.Menu;
import cn.bjtc.model.Product;
import cn.bjtc.service.IProdService;
import cn.bjtc.view.ActivityView;
import cn.bjtc.view.BrandView;
import cn.bjtc.view.CatView;
import cn.bjtc.view.MenuView;
import cn.bjtc.view.ProductView;

@Service("ProdService")
public class ProdServiceImpl implements  IProdService{

	public int saveProd(ProductView view) {
		return prodDao.saveProd(view);
	}

	public int updateProd(ProductView view) {
		return prodDao.updateProd(view);
	}

	public List<ProductView> findAllProds(ProductView view) {
		List<Product> prods = prodDao.findAllProds(view);
		if(prods == null ||prods.size() <= 0){
			return new ArrayList<ProductView>(0);
		}
		ProductView productView = new ProductView();
		productView.setPageSize(100);
		List<Product> pro = prodDao.findAllnames(productView);
		Map<String, String> parentMap = new HashMap<String, String>(pro==null?0:pro.size());
		for(Product product : pro){
			parentMap.put("b"+product.getBrandid(), product.getBrandname());
			parentMap.put("c"+product.getCatid(), product.getCatname());
		}
//		List<Category> catLst = catDao.findAllCats(catview);
//		
//		Map<String, String> catMap = new HashMap<String, String>(catLst==null?0:catLst.size());
//		for(Category cat : catLst){
//			catMap.put("c"+cat.getId(),cat.getCatname());
//		}
//		
//		BrandView brandview = new BrandView();
//		brandview.setPageSize(100);
//		List<Brand> brandLst = brandDao.findAllBrands(brandview);
//		
//		Map<String, String> brandMap = new HashMap<String, String>(brandLst==null?0:brandLst.size());
//		for(Brand brand : brandLst){
//			brandMap.put("b"+brand.getId(),brand.getBrandname());
//			
//		}
		
		List<ProductView> views = new ArrayList<ProductView>(prods.size());
		for(Product prod : prods){
			ProductView prodView = new ProductView();
			BeanUtils.copyProperties(prod, prodView);
			prodView.setCatname(parentMap.get("c"+prod.getCatid()));
			prodView.setBrandname(parentMap.get("b"+prod.getBrandid()));
			views.add(prodView);
		}
		return views;
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
		
		@Autowired
		private ICatDAO catDao;
		
		@Autowired
		private IBrandDAO brandDao;
}
