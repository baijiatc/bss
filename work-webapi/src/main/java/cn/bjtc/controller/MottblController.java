package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IMottblService;
import cn.bjtc.view.MottblView;

@RestController
@RequestMapping("mottbl")
public class MottblController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showMottbl(){
		try {
			ApiParam param=findApiParam();
			MottblView view=(MottblView) ParamUtil.convertToView(param, MottblView.class);
			List<?> Mottbl=mottblService.findAllMottbl(view);
			apiReturn.setData(Mottbl);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IMottblService mottblService;
}
