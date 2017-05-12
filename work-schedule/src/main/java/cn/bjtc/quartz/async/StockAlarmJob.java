package cn.bjtc.quartz.async;

import java.util.List;
import java.util.Map;

import cn.bjtc.common.ApplicationDataManager;
import cn.bjtc.common.MailManager;
import cn.bjtc.service.ITransService;
import cn.bjtc.tools.SpringUtil;

public class StockAlarmJob implements IJob {
	
	private final static String ENTER_CHAR = "\n";

	public void execute() {
		try {
			ITransService transService = (ITransService) SpringUtil.getBean("transService");
			List<?> dataLst = transService.monitorStock();
			if(dataLst == null || dataLst.size() == 0){
				return;
			}
			sendMail(dataLst);
		} catch (Exception e) {
			return;
		}
	}
	
	private void sendMail(List<?> dataLst){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<table cellspacing='10'>");
		buffer.append("<tr align='center'>")
			  .append("<td>").append("名称").append("</td>")
			  .append("<td>").append("库房").append("</td>")
			  .append("<td>").append("库区").append("</td>")
			  .append("<td>").append("摘要").append("</td>")
			  .append("<td>").append("阀值").append("</td>")
			  .append("<td>").append("单位").append("</td>")
			  .append("<td>").append("预警值").append("</td>");
		buffer.append("</tr>");
		for(Object obj : dataLst){
			Map<String,Object> rMap = (Map<String, Object>) obj;
			buffer.append("<tr align='center'>")
			  .append("<td>").append(rMap.get("skuname")).append("</td>")
			  .append("<td>").append(rMap.get("warehouse")).append("</td>")
			  .append("<td>").append(rMap.get("position")).append("</td>")
			  .append("<td>").append(rMap.get("factname")).append("</td>")
			  .append("<td>").append(rMap.get("baseline")).append("</td>")
			  .append("<td>").append(rMap.get("dictname")).append("</td>")
			  .append("<td>").append(rMap.get("realvalue")).append("</td>");
			buffer.append("</tr>");
		}
		buffer.append("</table>");
		MailManager mailManager = (MailManager) SpringUtil.getBean("mailManager");
		mailManager.setHost(ApplicationDataManager.getSysParamByCode("SMTP_HOST"));
		mailManager.setFromMail(ApplicationDataManager.getSysParamByCode("EMAIL_ADDR"));
		mailManager.setPassword(ApplicationDataManager.getSysParamByCode("EMAIL_PASSWD"));
		mailManager.sendHtml("库存预警提醒", buffer.toString(), ApplicationDataManager.getSysParamByCode("WH_EMAIL_ADDR"));
	}

}
