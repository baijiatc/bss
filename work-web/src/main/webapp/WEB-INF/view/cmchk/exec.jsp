<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div id="div_cstm_exec_pnl">
<h1>审核通过</h1>
</div>
<div id="div_cstmchk_exec_pnlheader">
	<a id="lnk_return" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:80px">继续审核</a>
</div>
<script>
var execPnl =new BSS.Panel('#div_cstm_exec_pnl');
execPnl.init({header:'#div_cstmchk_exec_pnlheader'});
$('#lnk_return').click(function(){
	BSS.showView('cstmchk/show.html',function(html){
		MAINTAB.updateSelectedTab(html);
	});
});
</script>