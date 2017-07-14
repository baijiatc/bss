package cn.bjtc.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMoteventschemeDAO;
import cn.bjtc.model.Moteventscheme;
import cn.bjtc.model.Motidx;
import cn.bjtc.service.IMoteventschemeService;
import cn.bjtc.view.MoteventschemeView;
import cn.bjtc.view.MotidxView;

@Service("MoteventschemeService")
public class MoteventschemeServiceImpl  implements  IMoteventschemeService{

	public int saveMoteventscheme(MoteventschemeView view) {
		 return MoteventschemeDao.saveMoteventscheme(view);
	}

	public int deleteMoteventscheme(Integer id) {
		return MoteventschemeDao.deleteMoteventscheme(id);
	}

	public List<MoteventschemeView> findAllMoteventscheme(MoteventschemeView view) {
		List<Moteventscheme> Moteventschemes =MoteventschemeDao.findAllMoteventscheme(view);
		if(Moteventschemes == null || Moteventschemes.size() <= 0){
			return new ArrayList<MoteventschemeView>(0);
		}
		MoteventschemeView moteventschemeView = new MoteventschemeView();
		moteventschemeView.setPageSize(100);
		Map<String, String> schMap = new HashMap<String, String>(Moteventschemes==null?0:Moteventschemes.size());
		List<Moteventscheme> schename = MoteventschemeDao.findAllschename(moteventschemeView);
		List<Moteventscheme> schedesc = MoteventschemeDao.findAllschedesc(moteventschemeView);
		for(Moteventscheme name : schename){
			schMap.put("n"+name.getSchmid(), name.getSchmname());
		}
		for(Moteventscheme desc : schedesc){
			schMap.put("d"+desc.getSchmid(), desc.getSchmdesc());
		}
		List<MoteventschemeView> views = new ArrayList<MoteventschemeView>(Moteventschemes.size());
		for(Moteventscheme moteventscheme : Moteventschemes){
			MoteventschemeView MoteventschemeView = new MoteventschemeView();
			BeanUtils.copyProperties(moteventscheme, MoteventschemeView);
			MoteventschemeView.setSchmname((schMap.get("n"+moteventscheme.getSchmid())));
			MoteventschemeView.setSchmdesc((schMap.get("d"+moteventscheme.getSchmid())));
			views.add(MoteventschemeView);
		}
		return views;
	}
	public Integer countAllMoteventscheme(MoteventschemeView view) {
		return MoteventschemeDao.countAllMoteventscheme(view);
	}

	@Autowired
	private IMoteventschemeDAO MoteventschemeDao;

}
