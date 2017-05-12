package cn.bjtc.service.impl;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 




import cn.bjtc.dao.ICateSpecDAO;
import cn.bjtc.dao.IProdParmDAO;
import cn.bjtc.model.Categoryspec;
import cn.bjtc.model.ProdParm;
import cn.bjtc.service.ICateSpecService;
import cn.bjtc.service.IProdParmService;
 

@Service("CateSpecService")
public class CateSpecServiceImpl implements  ICateSpecService{
 

	public int saveCateSpecs(Object catid, Object specid ) {
		String specs = specid.toString();
		if(specs != "" && specs != null){
			String specids[] = specs.split(",");
			for(int i = 0 ;i<specids.length;i++){
				Categoryspec catespec=new Categoryspec();
				catespec.setCatid(Integer.parseInt(catid.toString()));
				catespec.setSpecid(Integer.parseInt(specids[i].toString()));
				catespecDao.saveCatespecs(catespec);
			}	
		}
		return 0;
	}


	public int delectCatesById(Object catid) {
		return catespecDao.delectByCatId(catid);
	}
 
	 
		@Autowired
		private ICateSpecDAO catespecDao;


	 
 
 
}
