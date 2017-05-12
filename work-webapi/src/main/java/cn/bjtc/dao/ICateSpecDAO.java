package cn.bjtc.dao;
 
import cn.bjtc.model.Categoryspec;

 


public interface ICateSpecDAO {

	public int saveCatespecs(Categoryspec categoryspec);
    public int delectByCatId(Object  catid);	 
	

} 
