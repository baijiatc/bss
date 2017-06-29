package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMoteventschemeDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Motevent;
import cn.bjtc.model.Moteventscheme;
import cn.bjtc.view.MoteventschemeView;

@Component("moteventschemeDao")
public class MoteventschemeDaoImpl extends MyBatisDAO<Moteventscheme, Integer> implements
			IMoteventschemeDAO{

	public int saveMoteventscheme(MoteventschemeView view) {
		Moteventscheme Moteventscheme=new Moteventscheme();
		BeanUtils.copyProperties(view, Moteventscheme);;
		return super.save("saveMoteventscheme", Moteventscheme);
	}

	public List<Moteventscheme> findAllMoteventscheme(MoteventschemeView view) {
		 return super.findByParam("findAllMoteventscheme", view);
	}

	public Integer countAllMoteventscheme(MoteventschemeView view) {
		return super.countByParam("countAllMoteventscheme", view);
	}

	public int deleteMoteventscheme(Integer id) {
		return super.delete("deleteMoteventscheme", id);
	}
}
