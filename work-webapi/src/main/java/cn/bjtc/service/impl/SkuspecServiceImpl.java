package cn.bjtc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISkuspecDAO;
import cn.bjtc.model.Skuspec;
import cn.bjtc.service.ISkuspecService;

@Service("skuspecService")
public class SkuspecServiceImpl implements ISkuspecService {

	public int createSkuspec(Object skuid,Object specids) {
		String spids = specids.toString();
		if(spids != "" && spids != null){
			String speids[] = spids.split(",");
			for(int i = 0 ;i<speids.length;i++){
				Skuspec skuspec = new Skuspec();
				skuspec.setSpecid(Integer.parseInt(speids[i].toString()));
				skuspec.setSkuid(Integer.parseInt(skuid.toString()));
				skuspecDAO.createSkuspec(skuspec);
			}	
		}
		return 0;
	}


	public int deleteById(Object skuid) {
		return skuspecDAO.deleteById(skuid);
	}
	
	@Autowired
	private ISkuspecDAO skuspecDAO;

}
