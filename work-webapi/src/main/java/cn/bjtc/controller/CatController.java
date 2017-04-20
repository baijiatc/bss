package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.ICatService;
import cn.bjtc.view.CatView;

@RestController
@RequestMapping("cat")
public class CatController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showCats(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		CatView view=(CatView) ParamUtil.convertToView(param, CatView.class);
		int count=catService.countAllCats(view);
		List<?> cats=catService.findAllCats(view);
		apiReturn.setCount(count);
		apiReturn.setData(cats);
		return apiReturn;		
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddCat(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		CatView view=(CatView) ParamUtil.convertToView(param, CatView.class);
		catService.saveCat(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateCat(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		CatView view=(CatView) ParamUtil.convertToView(param, CatView.class);
		catService.updateCat(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditActparam(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		CatView view=(CatView) ParamUtil.convertToView(param, CatView.class);
		List<?> cats=catService.findAllCats(view);
		apiReturn.setData(cats);
		return apiReturn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Autowired
	private ICatService catService;
}
