<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div id="div_cstmchk_cnfrm_pnl" style="width:auto,height:300px;">
	<img width="300" height="400" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492407981&di=6278ce4896924be38597f04de185900b&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.omgqc.com%2FUpFile%2F201603%2F2016030851356933.jpg">
</div>
<div id="div_cstmchk_cnfrm_pnlheader">
	<a id="lnk_certcnfrm" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width:80px">执行审核</a>
	<a id="lnk_viewcnfrmback" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="width:80px">上一步</a>
</div>
<script>
var cnfrmPnl =new BSS.Panel('#div_cstmchk_cnfrm_pnl');
cnfrmPnl.init({header:'#div_cstmchk_cnfrm_pnlheader'});
$('#lnk_certcnfrm').click(function(){
	BSS.showView('${flowExecutionUrl}&_eventId=exec',function(html){
		MAINTAB.updateSelectedTab(html);
	});
});
$('#lnk_viewcnfrmback').click(function(){
	BSS.showView('cmchk.html',function(html){
		MAINTAB.updateSelectedTab(html);
	});
});
</script>