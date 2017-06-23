package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMotSchemeDao;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.MotScheme;
import cn.bjtc.view.MotSchemeView;

@Component("motSchemeDao")
public class MotSchemeDaoImpl extends MyBatisDAO<MotScheme, Integer>
           implements IMotSchemeDao{

	public int saveMotScheme(MotSchemeView view) {
		MotScheme motSc=new MotScheme();
		BeanUtils.copyProperties(view, motSc);
		return super.save("saveMotScheme", motSc);
	}

	public int updateMotScheme(MotSchemeView view) {
		return super.update("updateMotScheme", view);
	}

	public List<MotScheme> findAllMotScheme(MotSchemeView view) {
		return super.findByParam("findAllMotScheme", view);
	}

	public Integer countAllMotScheme(MotSchemeView view) {
		return super.countByParam("countAllMotScheme", view);
	}

//	public List<MotScheme> fAllMScByName(MotSchemeView view) {
//		return super.findByParam("fAllMScByName", view);
//	}
	

}
