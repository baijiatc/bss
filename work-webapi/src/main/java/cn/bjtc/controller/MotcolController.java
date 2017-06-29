package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IMotcolService;
import cn.bjtc.view.MotcolView;

@RestController
@RequestMapping("motcol")
public class MotcolController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showMottbl(){
		try {
			ApiParam param=findApiParam();
			MotcolView view=(MotcolView) ParamUtil.convertToView(param, MotcolView.class);
			List<?> Motcol=motcolService.findAllMotcol(view);
			apiReturn.setData(Motcol);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IMotcolService motcolService;
}
