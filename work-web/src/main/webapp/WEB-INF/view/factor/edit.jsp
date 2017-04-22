<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_factor" method="post">
	<table cellpadding="5">
		<tr>
			<td>角色名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="factname" data-options="required:true"></input>
				<input class="easyui-textbox" type="hidden" name="factid"></input>
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

BSS.dispatch({code:15010,data:[{factorid:'${factorid}'}]},function(resp){
	if(resp.code == 0){
		BSS.json2form('#frm_factor',resp.data[0]);
		
		FACTORDIALOG.ok = function(){
			var factor = BSS.form2json('#frm_factor');
			BSS.dispatch({code:15009,data:[factor]},function(){
				BSS.alert('保存成功！');
			},function(){});
		};
	}else{
		FACTORDIALOG.ok = function(){};
		BSS.warning(resp.message);
	}
});
</script>