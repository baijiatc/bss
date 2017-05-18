package cn.bjtc.service;

 

public interface IProdParmService {

	public int saveProdParms(Object productid,Object paramids,Object  paramvalue );
    public int delectProdParmById(Object productid);
}
