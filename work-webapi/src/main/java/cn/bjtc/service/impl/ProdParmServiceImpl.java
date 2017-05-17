package cn.bjtc.service.impl;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 



import cn.bjtc.dao.IProdParmDAO;
import cn.bjtc.model.ProdParm;
import cn.bjtc.service.IProdParmService;
 

@Service("ProdParmService")
public class ProdParmServiceImpl implements  IProdParmService{
 

	public int saveProdParms(Object productid, Object paramids,Object  paramvalues ) {
		String params = paramids.toString();
		String pvalues = paramvalues.toString();
		if(params != "" && params != null){
			String pamids[] = params.split(",");
			for(int i = 0 ;i<pamids.length;i++){
				ProdParm prodparm=new ProdParm();
				prodparm.setParamid(Integer.parseInt(pamids[i].toString()));
				prodparm.setProductid(Integer.parseInt(productid.toString()));
				if(pvalues != "" && pvalues != null){
					String pvalue[] = pvalues.split(",");
					prodparm.setParamvalue(pvalue[i].toString());
				}
				ppDao.saveProdParms(prodparm);
			}	
		}
		return 0;
	}


	public int delectProdParmById(Object productid) {
		return ppDao.delectPPById(productid);
	}
 
	 
		@Autowired
		private IProdParmDAO ppDao;

 
 
}
