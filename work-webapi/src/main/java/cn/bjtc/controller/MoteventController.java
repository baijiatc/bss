package cn.bjtc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IMoteventService;
import cn.bjtc.view.MoteventView;
@RestController
@RequestMapping("motevt")
public class MoteventController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询事件",type=AspectType.CONTROLLER)
	public ApiReturn showMotevent(){
		try {
			ApiParam param=findApiParam();
			MoteventView view=(MoteventView) ParamUtil.convertToView(param, MoteventView.class);
			int count=moteventService.countAllMotevent(view);
			List<?> Motevent=moteventService.findAllMotevent(view);
			apiReturn.setCount(count);
			apiReturn.setData(Motevent);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增事件",type=AspectType.CONTROLLER)
	public ApiReturn execAddMotevent(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MoteventView view=(MoteventView) ParamUtil.convertToView(param, MoteventView.class);
			moteventService.saveMotevent(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新事件",type=AspectType.CONTROLLER)
    public ApiReturn execUpdateMotevent(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MoteventView view=(MoteventView) ParamUtil.convertToView(param, MoteventView.class);
			moteventService.updateMotevent(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	} 
    
	@RequestMapping(value="get", method=RequestMethod.POST)
    public ApiReturn execeditMotevent(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MoteventView view=(MoteventView) ParamUtil.convertToView(param, MoteventView.class);
			List<?> Motevent=moteventService.findAllMotevent(view);
			apiReturn.setData(Motevent);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
	@RequestMapping(value="query", method=RequestMethod.POST)
	public ApiReturn queryMotevent(){
		try {
			MoteventView view = new MoteventView();
			List<?> data = moteventService.findAllMotevent(view);
			apiReturn.setData(data);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
    
	@Autowired
	private IMoteventService moteventService;
}
