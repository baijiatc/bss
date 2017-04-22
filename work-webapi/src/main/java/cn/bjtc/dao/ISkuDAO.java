package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Sku;
import cn.bjtc.view.SkuView;

public interface ISkuDAO {

	public int saveSku(SkuView view);
	public int updateSku(SkuView view);
    public List<Sku> findAllSkus(SkuView view);
	public Integer countAllSkus(SkuView view);
}
