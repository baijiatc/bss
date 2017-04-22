package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import cn.bjtc.dao.IProdDAO;
import cn.bjtc.model.Product;
import cn.bjtc.service.IProdService;
import cn.bjtc.view.ProductView;

@Service("prodService")
public class ProdServiceImpl implements  IProdService{

	public int saveProd(ProductView view) {
		return prodDao.saveProd(view);
	}

	public int updateProd(ProductView view) {
		return prodDao.updateProd(view);
	}

	public List<Product> findAllProds(ProductView view) {
		return prodDao.findAllProds(view);
	}

	public Integer countAllProds(ProductView view) {
		return prodDao.countAllProds(view);
	}

	@Autowired
	private IProdDAO prodDao;
}
