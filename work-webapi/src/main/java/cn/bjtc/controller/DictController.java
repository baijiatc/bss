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
import cn.bjtc.service.IDictService;
import cn.bjtc.view.DictionaryView;

@RestController
@RequestMapping("dict")
public class DictController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	public  ApiReturn showDictionary(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		DictionaryView  view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
		int count=dictService.countAllDicts(view);
		List<?> dicts=dictService.findAllDicts(view);
		apiReturn.setCount(count);
		apiReturn.setData(dicts);
		return apiReturn;
	}
	
	
	@RequestMapping(value="creat",method=RequestMethod.POST)
	public ApiReturn execAddDict(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		DictionaryView  view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
		dictService.saveDict(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ApiReturn  execUpdateDict(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		DictionaryView  view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
		dictService.updateDict(view);
		return apiReturn;
		
	}
	
	@RequestMapping(value="get",method=RequestMethod.POST)
	public ApiReturn  execeditDict(){
	      ApiParam param=ApiManager.getInstance().getParameters(request);
	      DictionaryView view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
	      List<?> dicts=dictService.findAllDicts(view);
	      apiReturn.setData(dicts);
	      return apiReturn;
	 
	}
	
	
	
	@Autowired
	private IDictService  dictService;
	
}
