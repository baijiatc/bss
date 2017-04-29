<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_spec" method="post">
	<table cellpadding="5">
		<tr>
			<td>规格名称：</td>
			<td><input id="id_specname" class="easyui-textbox" type="text" name="specname" data-options="required:true"></input></td>
			<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
		</tr>
		<tr>
			<td>规格值说明：</td>
			<td><input id="id_specdesc" class="easyui-textbox" type="text" name="specdesc" data-options="required:false"></input></td>
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
		initSpecEditPage();
	});
});
function initSpecEditPage(){
	BSS.dispatch({code:14020,data:[{id:'${id}'}]},function(resp){
		if(resp.code == 0){
			BSS.json2form('#frm_spec',resp.data[0]);
			SPECDIALOG.ok = function(){
				var spec = BSS.form2json('#frm_spec');
				BSS.dispatch({code:14011,data:[spec]},function(){
					BSS.alert('保存成功！');
				},function(){});
			};
		}else{
			PARMDIALOG.ok = function(){};
			BSS.warning(resp.message);
		}
	});
}
</script>