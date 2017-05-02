package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Sku;
import cn.bjtc.view.SkuView;

public interface ISkuService {

	public int saveSku(SkuView view);
	public int updateSku(SkuView view);
    public List<SkuView> findAllSkus(SkuView view);
	public Integer countAllSkus(SkuView view);
}
