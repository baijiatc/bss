package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMottblDAO;
import cn.bjtc.model.Mottbl;
import cn.bjtc.service.IMottblService;
import cn.bjtc.view.MottblView;

@Service("mottblService")
public class MottblServiceImpl implements  IMottblService {
 
	public List<MottblView> findAllMottbl(MottblView view) {
		List<Mottbl> mottbl =mottblDao.findAllMottbl(view);
		if(mottbl == null || mottbl.size() <= 0){
			return new ArrayList<MottblView>(0);
		}
		List<MottblView> views = new ArrayList<MottblView>(mottbl.size());
		for(Mottbl motSch : mottbl){
			MottblView motSchView = new MottblView();
			BeanUtils.copyProperties(motSch, motSchView);
			views.add(motSchView);
		}
		return views;
	}
	@Autowired
	private IMottblDAO  mottblDao;
	
}
