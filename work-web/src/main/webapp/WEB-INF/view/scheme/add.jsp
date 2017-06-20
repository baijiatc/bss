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
			<td>
			<textarea name="schmdesc"  style="height:40px;width:200px" data-options="required:false"></textarea>
			
			</td>
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