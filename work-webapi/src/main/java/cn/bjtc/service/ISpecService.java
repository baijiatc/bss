package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Spec;
import cn.bjtc.view.SpecView;

public interface ISpecService {

	public int saveSpec(SpecView view);
	public int updateSpec(SpecView view);
    public List<Spec> findAllSpecs(SpecView view);
	public Integer countAllSpecs(SpecView view);
}
