package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Motcol;
import cn.bjtc.model.Motidx;
import cn.bjtc.view.MotcolView;


public interface IMotcolDAO {
	public List<Motcol> findAllMotcol(MotcolView view);
} 
