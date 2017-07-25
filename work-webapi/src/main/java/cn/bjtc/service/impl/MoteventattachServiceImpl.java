package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMoteventattachDAO;
import cn.bjtc.model.Moteventattach;
import cn.bjtc.service.IMoteventattachService;
import cn.bjtc.view.MoteventattachView;

@Service("moteventattachService")
public class MoteventattachServiceImpl  implements  IMoteventattachService{

	public int saveMoteventattach(MoteventattachView view) {
		 return moteventattachDao.saveMoteventattach(view);
	}

	public int updateMoteventattach(MoteventattachView view) {
		return moteventattachDao.updateMoteventattach(view);
	}

	public List<MoteventattachView> findAllMoteventattach(MoteventattachView view) {
		List<Moteventattach> Moteventattachs =moteventattachDao.findAllMoteventattach(view);
		if(Moteventattachs == null || Moteventattachs.size() <= 0){
			return new ArrayList<MoteventattachView>(0);
		}
		List<MoteventattachView> views = new ArrayList<MoteventattachView>(Moteventattachs.size());
		for(Moteventattach Moteventattach : Moteventattachs){
			MoteventattachView MoteventattachView = new MoteventattachView();
			BeanUtils.copyProperties(Moteventattach, MoteventattachView);
			views.add(MoteventattachView);
		}
		return views;
	}
	public Integer countAllMoteventattach(MoteventattachView view) {
		return moteventattachDao.countAllMoteventattach(view);
	}

	@Autowired
	private IMoteventattachDAO moteventattachDao;
}
