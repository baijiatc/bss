package cn.bjtc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IDictService;
import cn.bjtc.tools.ApplicationDataManager;
import cn.bjtc.view.DictionaryView;

import com.alibaba.fastjson.JSONObject;

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
	
	
	@RequestMapping(value="create",method=RequestMethod.POST)
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
	public ApiReturn execeditDict(){
	      ApiParam param=ApiManager.getInstance().getParameters(request);
	      DictionaryView view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
	      List<?> dicts=dictService.findAllDicts(view);
	      apiReturn.setData(dicts);
	      return apiReturn;
	 
	}
	
	@RequestMapping(value="type",method=RequestMethod.POST)
	public ApiReturn loadDictData(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		List<Map<String, Object>> dataMapLst = param.getData();
		if(dataMapLst == null){
			apiReturn.setCode(1);
			apiReturn.setMessage("缺少必要参数");
			return apiReturn;
		}
		Map<String, Object> dataMap = dataMapLst.get(0);
		if(dataMap == null){
			apiReturn.setCode(1);
			apiReturn.setMessage("缺少必要参数");
			return apiReturn;
		}
		Object type = dataMap.get("type");
		if(type == null){
			apiReturn.setCode(1);
			apiReturn.setMessage("缺少必要参数");
			return apiReturn;
		}
		Map<String,String> valueMap = ApplicationDataManager.SYSDICTS.get(type);
		List<JSONObject> jsonLst = new ArrayList<JSONObject>();
		if(valueMap == null){
			apiReturn.setData(jsonLst);
			return apiReturn;
		}
		for(String key : valueMap.keySet()){
			JSONObject json = new JSONObject();
			json.put("value", key);
			json.put("label", valueMap.get(key));
			jsonLst.add(json);
		}
		apiReturn.setData(jsonLst);
		return apiReturn;
	}
	
	@Autowired
	private IDictService  dictService;
	
}
