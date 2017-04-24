package cn.bjtc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.common.ApplicationDataManager;
import cn.bjtc.view.RegionView;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("region")
public class RegionController extends BaseController{
	
	@RequestMapping(value="part", method=RequestMethod.POST)
	public ApiReturn showActawards(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> parentMap = param.getData().get(0);
			Object parentid = parentMap.get("pid");
			List<Object> objLst = ApplicationDataManager.getRegionsByParent(parentid);
			List<JSONObject> jsonLst = new ArrayList<JSONObject>(objLst.size());
			for(Object obj : objLst){
				RegionView view = (RegionView) obj;
				JSONObject json = new JSONObject();
				json.put("value", view.getRegionid());
				json.put("label", view.getValue());
				jsonLst.add(json);
			}
			apiReturn.setData(jsonLst);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
}
