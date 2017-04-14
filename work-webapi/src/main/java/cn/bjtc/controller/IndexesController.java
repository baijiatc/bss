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
import cn.bjtc.service.IIndexesService;
import cn.bjtc.view.IndexesView;

@RestController
@RequestMapping("idx")
public class IndexesController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showIndexes(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
		int count = indexesService.countAllIndexes(view);
		List<?> indexess = indexesService.findAllIndexes(view);
		apiReturn.setCount(count);
		apiReturn.setData(indexess);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddIndexes(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
		indexesService.saveIndexes(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateIndexes(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
		indexesService.updateIndexes(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditIndexes(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IndexesView view = (IndexesView) ParamUtil.convertToView(param, IndexesView.class);
		List<?> indexess = indexesService.findAllIndexes(view);
		apiReturn.setData(indexess);
		return apiReturn;
	}
	
	@Autowired
	private IIndexesService indexesService;
}
