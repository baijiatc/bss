<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="div_cstmchk_cnfrm_pnl" style="width:auto,height:300px;">
	<div id="div_cstmchk_cnfrm_container" style="width:auto;">
		<div id="div_cstmchk_left" data-options="region:'west'" style="width:350px;" align="center">
			<!-- left -->
			<img width="300" height="402" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492407981&di=6278ce4896924be38597f04de185900b&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.omgqc.com%2FUpFile%2F201603%2F2016030851356933.jpg">
		</div>
		<div id="div_cstmchk_center" data-options="region:'center'" style="width:auto">
			<!-- center -->
			<table>
				<tr>
					<td>审核结果：</td>
					<td>
						<input id="cbx_cstmchkst" class="easyui-combobox" type="text" name="result" disabled></input>
					</td>
				</tr>
				<tr>
					<td>审核意见：</td>
					<td><input id="sel_chkrslt" class="easyui-textbox" data-options="multiline:true" readonly value="${crslt }"></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="div_cstmchk_cnfrm_pnlheader">
	<a id="lnk_certcnfrm" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="width:80px">执行审核</a>
	<a id="lnk_viewcnfrmback" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="width:80px">上一步</a>
</div>
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script>
var cstmChkCombox = new BSS.Combox('#cbx_cstmchkst');
cstmChkCombox.fromDict('DICT_CSTMCHK',function(){
	$('#cbx_cstmchkst').combobox('select','${cst}');
});
var cnfrmPnl =new BSS.Panel('#div_cstmchk_cnfrm_pnl');
cnfrmPnl.init({header:'#div_cstmchk_cnfrm_pnlheader'});
var cnfrmLayout = new BSS.Layout('#div_cstmchk_cnfrm_container');
cnfrmLayout.layout();
$('#lnk_certcnfrm').click(function(){
	var chkst = cstmChkCombox.getValue();
	var chkrslt = $('#sel_chkrslt').textbox('getValue');
	BSS.showView('cstmchk/exec.html?cst='+chkst+'&crslt='+chkrslt,function(html){
		MAINTAB.updateSelectedTab(html);
	});
});
$('#lnk_viewcnfrmback').click(function(){
	var chkst = cstmChkCombox.getValue();
	var chkrslt = $('#sel_chkrslt').textbox('getValue');
	BSS.showView('cstmchk/cert/${cid}.html?cst='+chkst+'&crslt='+chkrslt,function(html){
		MAINTAB.updateSelectedTab(html);
	});
});
</script>