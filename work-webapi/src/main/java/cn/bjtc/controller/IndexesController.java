package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IIndexesService;
import cn.bjtc.view.IndexesView;

@RestController
@RequestMapping("idx")
public class IndexesController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showIndexes(){
		try {
			ApiParam param = findApiParam();
			IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
			int count = indexesService.countAllIndexes(view);
			List<?> indexess = indexesService.findAllIndexes(view);
			apiReturn.setCount(count);
			apiReturn.setData(indexess);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddIndexes(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
			indexesService.saveIndexes(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateIndexes(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
			indexesService.updateIndexes(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditIndexes(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
			List<?> indexess = indexesService.findAllIndexes(view);
			apiReturn.setData(indexess);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IIndexesService indexesService;
}
