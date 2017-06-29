package cn.bjtc.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMoteventschemeDAO;
import cn.bjtc.model.Moteventscheme;
import cn.bjtc.service.IMoteventschemeService;
import cn.bjtc.view.MoteventschemeView;

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
		List<MoteventschemeView> views = new ArrayList<MoteventschemeView>(Moteventschemes.size());
		for(Moteventscheme Moteventscheme : Moteventschemes){
			MoteventschemeView MoteventschemeView = new MoteventschemeView();
			BeanUtils.copyProperties(Moteventscheme, MoteventschemeView);
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
