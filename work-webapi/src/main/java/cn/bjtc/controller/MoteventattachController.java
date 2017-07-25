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
import cn.bjtc.service.IMoteventattachService;
import cn.bjtc.view.MoteventattachView;
@RestController
@RequestMapping("motevtattach")
public class MoteventattachController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询事件条件",type=AspectType.CONTROLLER)
	public ApiReturn showMoteventattach(){
		try {
			ApiParam param=findApiParam();
			MoteventattachView view=(MoteventattachView) ParamUtil.convertToView(param, MoteventattachView.class);
			int count=moteventattachService.countAllMoteventattach(view);
			List<?> Moteventattach=moteventattachService.findAllMoteventattach(view);
			apiReturn.setCount(count);
			apiReturn.setData(Moteventattach);
		} catch (Exception e) {
			e.printStackTrace();
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增事件条件",type=AspectType.CONTROLLER)
	public ApiReturn execAddMoteventattach(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MoteventattachView view=(MoteventattachView) ParamUtil.convertToView(param, MoteventattachView.class);
			moteventattachService.saveMoteventattach(view);
		} catch (Exception e) {
			e.printStackTrace();
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新事件条件",type=AspectType.CONTROLLER)
    public ApiReturn execUpdateMoteventattach(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MoteventattachView view=(MoteventattachView) ParamUtil.convertToView(param, MoteventattachView.class);
			moteventattachService.updateMoteventattach(view);
		} catch (Exception e) {
			e.printStackTrace();
			showServerError();
		}
		return apiReturn;
	} 
    
	@RequestMapping(value="get", method=RequestMethod.POST)
    public ApiReturn execeditMoteventattach(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MoteventattachView view=(MoteventattachView) ParamUtil.convertToView(param, MoteventattachView.class);
			List<?> Moteventattach=moteventattachService.findAllMoteventattach(view);
			apiReturn.setData(Moteventattach);
		} catch (Exception e) {
			e.printStackTrace();
			showServerError();
		}
		return apiReturn;	
	}
	
	@RequestMapping(value="query", method=RequestMethod.POST)
	public ApiReturn queryMoteventattach(){
		try {
			MoteventattachView view = new MoteventattachView();
			List<?> data = moteventattachService.findAllMoteventattach(view);
			apiReturn.setData(data);
		} catch (Exception e) {
			e.printStackTrace();
			showServerError();
		}
		return apiReturn;
	}
    
	@Autowired
	private IMoteventattachService moteventattachService;
}
