package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.ISkuDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Sku;
import cn.bjtc.view.SkuView;

@Component("skuDao")
public class SkuDaoImpl extends MyBatisDAO<Sku, Integer> implements
			ISkuDAO{

	public int saveSku(SkuView view) {
		Sku sku=new Sku();
		BeanUtils.copyProperties(view,sku);;
		return super.save("saveSku", sku);
	}

	public int updateSku(SkuView view) {
		 return super.update("updateSku", view);
	}

	public List<Sku> findAllSkus(SkuView view) {
		 return super.findByParam("findAllSku", view);
	}

	public Integer countAllSkus(SkuView view) {
		return super.countByParam("countAllSku", view);
	}
    
	
}
