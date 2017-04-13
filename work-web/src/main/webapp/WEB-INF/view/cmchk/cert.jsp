<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div id="div_cstmchk_cert_pnl" style="width:auto,height:300px;">
	<div id="div_cstmchk_cert_container" style="width:auto;">
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
						<select class="easyui-combobox" type="text" name="result">
							<option value="2" selected>通过</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>审核意见：</td>
					<td><input class="easyui-textbox" data-options="multiline:true"></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="div_cstmchk_cert_pnlheader">
	<a id="lnk_viewcert" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:80px">确认资质</a>
	<a id="lnk_viewcertback" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="width:80px">上一步</a>
</div>
<script>
var certPnl =new BSS.Panel('#div_cstmchk_cert_pnl');
certPnl.init({header:'#div_cstmchk_cert_pnlheader'});
var certLayout = new BSS.Layout('#div_cstmchk_cert_container');
certLayout.layout();
$('#lnk_viewcert').click(function(){
	BSS.showView('cstmchk/cnfrm/${cid}.html',function(html){
		MAINTAB.updateSelectedTab(html);
	});
});
$('#lnk_viewcertback').click(function(){
	BSS.showView('cstmchk/show.html',function(html){
		MAINTAB.updateSelectedTab(html);
	});
});
</script>