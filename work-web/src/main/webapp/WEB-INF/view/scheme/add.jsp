<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_scheme" method="post">
	<table cellpadding="8">
		<tr>
			<td>方案名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="schmname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>方案描述：</td>
			<td><input  class="easyui-textbox" type="text" name="schmdesc" data-options="required:false"></input></td>
		</tr>
		 
	</table>
</form>  
<script>
SCHEMEDIALOG.ok = function(){
	var scheme = BSS.form2json('#frm_scheme');
	BSS.dispatch({code:22001,data:[scheme]},function(){
		BSS.alert("添加成功");;
	},function(){});
}
</script>