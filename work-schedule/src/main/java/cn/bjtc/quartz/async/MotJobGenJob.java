package cn.bjtc.quartz.async;

public class MotJobGenJob implements IJob {

	public void execute() {
		//IMotEventService eventService = (IMotEventService)SpringUtil.getBean("eventService");
		//MotEventView view = new MotEventView();
		//view.setEvtStats(2);//启用状态事件
		//view.setPageSize(1000);
		//List<MotEventView> evtLst = IMotEventService.findAllEvents(view);
		//IMotJobService jobService = (IMotJobService)SpringUtil.getBean("jobService");
		//for(MotEventView evtView : evtLst){
		//	Integer evtid = evtView.getId();
		//	Map<String,Object> countMap = jobService.adjustMotJob(evtid);
		//	Integer tcount = Integer.parseInt(countMap.get("tcount").toString());
		//	if(tcount <= 0){
		//		continue;
		//	}
		//	//build and save mot job
		//}
	}

}
