package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISpecDAO;
import cn.bjtc.model.Parameters;
import cn.bjtc.model.Spec;
import cn.bjtc.model.Spec;
import cn.bjtc.service.ISpecService;
import cn.bjtc.view.ParametersView;
import cn.bjtc.view.SpecView;
import cn.bjtc.view.SpecView;

@Service("specService")
public class SpecServiceImpl implements ISpecService {


	public int saveSpec(SpecView view) {
		return specDAO.saveSpec(view);
	}

	public int updateSpec(SpecView view) {
		return  specDAO.updateSpec(view);
	}

	public List<SpecView> findAllSpecs(SpecView view) {
		List<Spec> Specs = specDAO.findAllSpecs(view);
		if(Specs == null || Specs.size() <= 0){
			return new ArrayList<SpecView>(0);
		}
		List<SpecView> views = new ArrayList<SpecView>(Specs.size());
		for(Spec Spec : Specs){
			SpecView SpecView = new SpecView();
			BeanUtils.copyProperties(Spec, SpecView);
			views.add(SpecView);
		}
		return views;
	}

	public Integer countAllSpecs(SpecView view) {
		return specDAO.countAllSpecs(view);
	}
 



	public List<SpecView> findAllSpecByCatId(Object catid) {
		SpecView view = new SpecView();
		view.setPageSize(100);
		List<Spec> allSpecs =specDAO.findAllSpecs(view);
		List<Spec> specs = specDAO.findAllSpecByCatId(catid);
		Map<String,Spec> specMap = new HashMap<String, Spec>();
		for(Spec spec : specs){
			specMap.put( spec.getSpecname(), spec);
		}
		List<SpecView> views = new ArrayList<SpecView>(allSpecs.size());
		for(Spec spec : allSpecs){
			SpecView specview = new SpecView();
			if(specMap.containsKey(spec.getSpecname())){
				specview.setChecked(true);
			}
			BeanUtils.copyProperties(spec, specview);
			views.add(specview);
		}
		return views;
	}
	

	@Autowired
	private ISpecDAO specDAO;
}