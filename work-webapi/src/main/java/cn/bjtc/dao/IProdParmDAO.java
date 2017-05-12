package cn.bjtc.dao;
 
import cn.bjtc.model.ProdParm;
 


public interface IProdParmDAO {

	public int saveProdParms(ProdParm prodParm);
    public int delectPPById(Object  productid);	 
	

} 
