package cn.bjtc.dao.impl;
 

import org.springframework.stereotype.Component;

import cn.bjtc.dao.ICateSpecDAO;
import cn.bjtc.dao.IProdParmDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Categoryspec;
import cn.bjtc.model.ProdParm;
 

@Component("CateSpecDAO)")
public  class CateSpecDAOImpl extends MyBatisDAO<Categoryspec, Integer> 
              implements  ICateSpecDAO{

	public int saveCatespecs(Categoryspec categoryspec) {
		return super.save("saveCatespecs", categoryspec);
	}

	public int delectByCatId(Object catid) {
		return super.delete("delectByCatId",catid);
	}

	 

}
