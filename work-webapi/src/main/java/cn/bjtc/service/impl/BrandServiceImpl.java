package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IBrandDAO;
import cn.bjtc.model.Brand;
import cn.bjtc.service.IBrandService;
import cn.bjtc.view.BrandView;

@Service("brandService")
public class BrandServiceImpl  implements  IBrandService{

	public int saveBrand(BrandView view) {
		 return brandDao.saveBrand(view);
	}

	public int updateBrand(BrandView view) {
		return brandDao.updateBrand(view);
	}

	public List<Brand> findAllBrands(BrandView view) {
		return brandDao.findAllBrands(view);
	}

	public Integer countAllBrands(BrandView view) {
		return brandDao.countAllBrands(view);
	}

	@Autowired
	private IBrandDAO brandDao;
}
