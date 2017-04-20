package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Brand;
import cn.bjtc.view.BrandView;

public interface IBrandService {


	public int saveBrand(BrandView view);
	public int updateBrand(BrandView view);
	public List<Brand> findAllBrands(BrandView view);
	public Integer countAllBrands(BrandView view);
}
