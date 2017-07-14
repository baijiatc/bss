package cn.bjtc.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMotevtgetDAO;
import cn.bjtc.model.Motevtget;
import cn.bjtc.model.Motevtget;
import cn.bjtc.service.IMotevtgetService;
import cn.bjtc.view.MotevtgetView;
import cn.bjtc.view.MotevtgetView;

@Service("MotevtgetService")
public class MotevtgetServiceImpl  implements  IMotevtgetService{

	public int saveMotevtget(MotevtgetView view) {
		 return motevtgetDao.saveMotevtget(view);
	}

	public int deleteMotevtget(Integer id) {
		return motevtgetDao.deleteMotevtget(id);
	}

	public List<MotevtgetView> findAllMotevtget(MotevtgetView view) {
		List<Motevtget> Motevtgets =motevtgetDao.findAllMotevtget(view);
		if(Motevtgets == null || Motevtgets.size() <= 0){
			return new ArrayList<MotevtgetView>(0);
		}
		MotevtgetView motevtgetView = new MotevtgetView();
		motevtgetView.setPageSize(100);
		Map<String, String> schMap = new HashMap<String, String>(Motevtgets==null?0:Motevtgets.size());
		List<Motevtget> ltbname = motevtgetDao.findAllltblname(motevtgetView);
		List<Motevtget> rtbname = motevtgetDao.findAllrtblname(motevtgetView);
		for(Motevtget lname : ltbname){
			schMap.put("l"+lname.getLtblid(), lname.getLtblname());
		}
		for(Motevtget rname : rtbname){
			schMap.put("r"+rname.getRtblid(), rname.getRtblname());
		}
		List<MotevtgetView> views = new ArrayList<MotevtgetView>(Motevtgets.size());
		for(Motevtget motevtget : Motevtgets){
			MotevtgetView MotevtgetView = new MotevtgetView();
			BeanUtils.copyProperties(motevtget, MotevtgetView);
			MotevtgetView.setLtblname((schMap.get("l"+motevtget.getLtblid())));
			MotevtgetView.setRtblname((schMap.get("r"+motevtget.getRtblid())));
			views.add(MotevtgetView);
		}
		return views;
	}
	public Integer countAllMotevtget(MotevtgetView view) {
		return motevtgetDao.countAllMotevtget(view);
	}

	@Autowired
	private IMotevtgetDAO motevtgetDao;

}
