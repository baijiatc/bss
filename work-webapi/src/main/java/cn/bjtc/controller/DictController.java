package cn.bjtc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.common.ApplicationDataManager;
import cn.bjtc.service.IDictService;
import cn.bjtc.view.DictionaryView;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("dict")
public class DictController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询字典信息",type=AspectType.CONTROLLER)
	public  ApiReturn showDictionary(){
		try {
			ApiParam param=findApiParam();
			DictionaryView  view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
			int count=dictService.countAllDicts(view);
			List<?> dicts=dictService.findAllDicts(view);
			apiReturn.setCount(count);
			apiReturn.setData(dicts);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	@SysLogger(content="新增字典信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddDict(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			DictionaryView  view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
			dictService.saveDict(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@SysLogger(content="更新字典信息",type=AspectType.CONTROLLER)
	public ApiReturn  execUpdateDict(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			DictionaryView  view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
			dictService.updateDict(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
		
	}
	
	@RequestMapping(value="get",method=RequestMethod.POST)
	public ApiReturn execeditDict(){
	      try {
			ApiParam param=findApiParam();
			  DictionaryView view=(DictionaryView) ParamUtil.convertToView(param, DictionaryView.class);
			  List<?> dicts=dictService.findAllDicts(view);
			  apiReturn.setData(dicts);
		} catch (Exception e) {
			showServerError();
		}
	      return apiReturn;
	 
	}
	
	@RequestMapping(value="type",method=RequestMethod.POST)
	public ApiReturn loadDictData(){
		try {
			ApiParam param=findApiParam();
			List<Map<String, Object>> dataMapLst = param.getData();
			ifParamDataIsEmpty(param);
			Map<String, Object> dataMap = dataMapLst.get(0);
			Object type = dataMap.get("type");
			Map<String,String> valueMap = ApplicationDataManager.SYSDICTS.get(type);
			List<JSONObject> jsonLst = new ArrayList<JSONObject>();
			for(String key : valueMap.keySet()){
				JSONObject json = new JSONObject();
				json.put("value", key);
				json.put("label", valueMap.get(key));
				jsonLst.add(json);
			}
			apiReturn.setData(jsonLst);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IDictService  dictService;
	
}
