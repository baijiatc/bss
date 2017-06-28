<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_scheme" method="post">
	<table cellpadding="8">
		<tr>
			<td>方案名称：</td>
			<td>
				<input  id="id_schmname" class="easyui-textbox" type="text" name="schmname" data-options="required:true"></input>
				<input  id="id_id"  class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>方案描述：</td>
			<td><textarea  id="id_schmdesc" name="schmdesc"  style="height:40px;width:200px" data-options="required:false"></textarea></td>
		</tr>
		 
	</table>
</form>
<script>
BSS.dispatch({code:22002,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_scheme',resp.data[0]);
});
SCHEMEDIALOG.ok = function(){
	var scheme = BSS.form2json('#frm_scheme');
	BSS.dispatch({code:22003,data:[scheme]},function(){
		BSS.alert('保存成功！');
	},function(){});	
}
</script>