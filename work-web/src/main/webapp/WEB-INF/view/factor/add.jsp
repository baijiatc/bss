<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_factor" method="post">
	<table cellpadding="5">
		<tr>
			<td>因子名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="factname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>默认值：</td>
			<td><input class="easyui-textbox" type="text" name="defaultval" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>默认单位：</td>
			<td><input class="easyui-textbox" type="text" name="defaultunit" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var factorStCombox = new BSS.Combox('#cbx_factorst');
factorStCombox.fromDict('DICT_FACTORST');

FACTORDIALOG.ok = function(){
	var factor = BSS.form2json('#frm_factor');
	BSS.dispatch({code:15008,data:[factor]},function(resp){
		if(resp.code == 0){
			BSS.info('保存成功');
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}
</script>