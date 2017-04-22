package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISkuDAO;
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

	public List<Sku> findAllSkus(SkuView view) {
		return skuDAO.findAllSkus(view);
	}

	public Integer countAllSkus(SkuView view) {
		return skuDAO.countAllSkus(view);
	}
 

	@Autowired
	private ISkuDAO skuDAO;

}
