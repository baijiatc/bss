package cn.bjtc.service.impl;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import cn.bjtc.dao.IProdParmDAO;
 
import cn.bjtc.model.ProdParm;
import cn.bjtc.service.IProdParmService;
 

@Service("prodparmService")
public class ProdParmServiceImpl implements  IProdParmService{
 

	public int saveProdParms(Object productid, Object paramid ) {
		String params = paramid.toString();
		if(params != "" && params != null){
			String paramids[] = params.split(",");
			for(int i = 0 ;i<paramids.length;i++){
				ProdParm prodparm=new ProdParm();
				prodparm.setParamid(Integer.parseInt(paramids[i].toString()));
				prodparm.setProductid(Integer.parseInt(productid.toString()));
				ppDao.saveProdParms(prodparm);
			}	
		}
		return 0;
	}


	public int delectById(Object productid) {
		return ppDao.delectById(productid);
	}
 
	 
		@Autowired
		private IProdParmDAO ppDao;

 
 
}
