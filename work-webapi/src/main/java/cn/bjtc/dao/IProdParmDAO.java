package cn.bjtc.dao;
 
import cn.bjtc.model.ProdParm;
 


public interface IProdParmDAO {

	public int saveProdParms(ProdParm prodParm);
    public int delectById(Object  productid);	 
	

} 
