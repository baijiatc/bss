<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_prm" method="post">
	<table cellpadding="5">
		<tr>
			<td>参数名称：</td>
			<td><input class="easyui-textbox" type="text" name="paramname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>参数描述：</td>
			<td><input class="easyui-textbox" type="text" name="paramdesc" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>参数类型：</td>
			<td><input id="cbx_paramtype" class="easyui-textbox" type="text" name="paramtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>规格状态：</td>
			<td><input id="cbx_paramst" class="easyui-textbox" type="text" name="paramst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var typeCombox = new BSS.Combox('#cbx_paramtype');
typeCombox.fromDict('DICT_PARAMTYPE',function(){
	var parCombox = new BSS.Combox('#cbx_paramst');
	parCombox.fromDict('DICT_PARAMST',function(){
		setOk();
	});
});

function setOk(){
	PARMDIALOG.ok = function(){
		var prm = BSS.form2json('#frm_prm');
		BSS.dispatch({code:14007,data:[prm]},function(){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
}
</script>