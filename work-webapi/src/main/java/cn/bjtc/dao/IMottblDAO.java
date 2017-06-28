package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Mottbl;
import cn.bjtc.view.MottblView;


public interface IMottblDAO {
	public List<Mottbl> findAllMottbl(MottblView view);
} 
