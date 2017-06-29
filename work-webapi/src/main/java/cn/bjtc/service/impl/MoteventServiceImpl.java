package cn.bjtc.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMoteventDAO;
import cn.bjtc.model.Motevent;
import cn.bjtc.service.IMoteventService;
import cn.bjtc.view.MoteventView;

@Service("moteventService")
public class MoteventServiceImpl  implements  IMoteventService{

	public int saveMotevent(MoteventView view) {
		 return moteventDao.saveMotevent(view);
	}

	public int updateMotevent(MoteventView view) {
		return moteventDao.updateMotevent(view);
	}

	public List<MoteventView> findAllMotevent(MoteventView view) {
		List<Motevent> Motevents =moteventDao.findAllMotevent(view);
		if(Motevents == null || Motevents.size() <= 0){
			return new ArrayList<MoteventView>(0);
		}
		List<MoteventView> views = new ArrayList<MoteventView>(Motevents.size());
		for(Motevent Motevent : Motevents){
			MoteventView MoteventView = new MoteventView();
			BeanUtils.copyProperties(Motevent, MoteventView);
			views.add(MoteventView);
		}
		return views;
	}
	public Integer countAllMotevent(MoteventView view) {
		return moteventDao.countAllMotevent(view);
	}

	@Autowired
	private IMoteventDAO moteventDao;
}
