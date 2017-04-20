package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
 

import cn.bjtc.dao.IBrandDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Brand;
import cn.bjtc.view.BrandView;

@Component("brandDao")
public class BrandDAOImpl extends MyBatisDAO<Brand, Integer>
			implements  IBrandDAO{

	public int saveBrand(BrandView view) {
		Brand brand=new Brand();
		BeanUtils.copyProperties(view, brand);
		return super.save("saveBrand", brand);
	}

	public int updateBrand(BrandView view) {
		return super.update("updateBrand", view);
	}

	public List<Brand> findAllBrands(BrandView view) {
		return super.findByParam("findAllBrands", view);
	}

	public Integer countAllBrands(BrandView view) {
		return super.countByParam("countAllBrands", view);
	}

	
}
