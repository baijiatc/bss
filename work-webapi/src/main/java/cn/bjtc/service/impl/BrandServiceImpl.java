package cn.bjtc.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IBrandDAO;
import cn.bjtc.model.Brand;
import cn.bjtc.model.Role;
import cn.bjtc.service.IBrandService;
import cn.bjtc.view.BrandView;
import cn.bjtc.view.RoleView;

@Service("brandService")
public class BrandServiceImpl  implements  IBrandService{

	public int saveBrand(BrandView view) {
		 return brandDao.saveBrand(view);
	}

	public int updateBrand(BrandView view) {
		return brandDao.updateBrand(view);
	}

	public List<BrandView> findAllBrands(BrandView view) {
		List<Brand> brands =brandDao.findAllBrands(view);
		if(brands == null || brands.size() <= 0){
			return new ArrayList<BrandView>(0);
		}
		List<BrandView> views = new ArrayList<BrandView>(brands.size());
		for(Brand brand : brands){
			BrandView brandView = new BrandView();
			BeanUtils.copyProperties(brand, brandView);
			views.add(brandView);
		}
		return views;
	}
	public Integer countAllBrands(BrandView view) {
		return brandDao.countAllBrands(view);
	}

	@Autowired
	private IBrandDAO brandDao;
}
