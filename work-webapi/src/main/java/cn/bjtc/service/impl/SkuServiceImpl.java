package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISkuDAO;
import cn.bjtc.model.Sku;
import cn.bjtc.model.Sku;
import cn.bjtc.service.ISkuService;
import cn.bjtc.view.SkuView;

@Service("SkuService")
public class SkuServiceImpl implements ISkuService {


	public int saveSku(SkuView view) {
		return skuDAO.saveSku(view);
	}

	public int updateSku(SkuView view) {
		return  skuDAO.updateSku(view);
	}

	public List<SkuView> findAllSkus(SkuView view) {
		List<Sku> Skus = skuDAO.findAllSkus(view);
		if(Skus == null || Skus.size() <= 0){
			return new ArrayList<SkuView>(0);
		}
		List<SkuView> views = new ArrayList<SkuView>(Skus.size());
		for(Sku Sku : Skus){
			SkuView SkuView = new SkuView();
			BeanUtils.copyProperties(Sku, SkuView);
			views.add(SkuView);
		}
		return views;
	}

	public Integer countAllSkus(SkuView view) {
		return skuDAO.countAllSkus(view);
	}
 

	@Autowired
	private ISkuDAO skuDAO;

}
