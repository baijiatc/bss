<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_spec" method="post">
	<table cellpadding="5">
		<tr>
			<td>规格名称：</td>
			<td><input class="easyui-textbox" type="text" name="specname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>规格值说明：</td>
			<td><input class="easyui-textbox" type="text" name="specdesc" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>规格类型：</td>
			<td><input id="cbx_spectype" class="easyui-textbox" type="text" name="spectype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>规格状态：</td>
			<td><input id="cbx_specst" class="easyui-textbox" type="text" name="specst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var spectypeCombox = new BSS.Combox('#cbx_spectype');
spectypeCombox.fromDict('DICT_SPECTYPE',function(){
	var specstCombox = new BSS.Combox('#cbx_specst');
	specstCombox.fromDict('DICT_SPECST',function(){
		setOk();
	});
});
function setOk(){
	SPECDIALOG.ok = function(){
		var prm = BSS.form2json('#frm_spec');
		BSS.dispatch({code:14010,data:[prm]},function(resp){
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