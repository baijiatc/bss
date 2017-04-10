<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_dict" method="post">
	<table  >
		<tr>
			<td>枚举名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="dictname" data-options="required:true"></input>
			</td>
		</tr>
		
		<tr>
			<td>枚举值：</td>
			<td>
				<input class="easyui-textbox" type="text" name="dictval" data-options="required:true"></input>
			</td>
		</tr>
		
		<tr>
			<td>枚举类型：</td>
			<td>
				<input class="easyui-textbox" type="text" name="dicttype" data-options="required:true"></input> 
				 
			</td>
		</tr>
		
		<tr>
			<td>状态：</td>
			<td> 
			    	<input class="easyui-textbox" type="text" name="dictst" data-options="required:true"></input>
			 
			
			</td>
		</tr>
	</table>
</form>
<script>
DICTDIALOG.ok = function(){
	var dict = BSS.form2json('#frm_dict');
	BSS.dispatch({code:21005,data:[dict]},function(){
		BSS.alert("保存成功");;
	},function(){});
}
</script>