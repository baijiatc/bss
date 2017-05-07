<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_apiedit" method="post">
	<table cellpadding="5">
		<tr>
			<td>业务编码：</td>
			<td>
				<input id="id_code" class="easyui-textbox" type="text" name="code" data-options="required:true"></input>
				<input id="id_apiid" class="easyui-textbox" type="hidden" name="apiid"></input>
			</td>
		</tr>
		<tr>
			<td>业务名称：</td>
			<td>
				<input id="id_apiname" class="easyui-textbox" type="text" name="apiname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>URL：</td>
			<td>
				<input id="id_apiurl" class="easyui-textbox" type="text" name="apiurl" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>返回类型：</td>
			<td>
				<input id="id_retype" class="easyui-textbox" type="text" name="retype" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input id="cbx_apist" class="easyui-combobox" type="text" name="apist" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var apistCombox = new BSS.Combox('#cbx_apist');
apistCombox.fromDict('DICT_APIST',function(){
	initApiEditPage();
});

function initApiEditPage(){
	BSS.dispatch({code:21011,data:[{apiid:'${apiid}'}]},function(resp){
		if(resp.code == 0){
			BSS.json2form('#frm_apiedit',resp.data[0]);
			APIDIALOG.ok = function(){
				var api = BSS.form2json('#frm_apiedit');
				BSS.dispatch({code:21013,data:[api]},function(rslt){
					if(rslt.code == 0){
						BSS.info('更新成功');
					}else{
						BSS.warning(rslt.message);
					}
				},function(){});
			}
		}else{
			BSS.warning(resp.message);
		}
	});
}
</script>