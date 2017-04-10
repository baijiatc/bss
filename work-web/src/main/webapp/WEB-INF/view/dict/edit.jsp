<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
				 
				<select class="easyui-textbox" name="dicttype">
				   <option value="0">定义类型</option>
				   <option>其他</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>状态：</td>
			<td> 
			    	<select class="easyui-textbox" name="dictst">
				   <option value="1">启用</option>
				   <option value="0">停止</option>
				</select>
			 
			
			</td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:21090,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_dict',resp.data[0]);
});
DICTDIALOG.ok = function(){
	var dict = BSS.form2json('#frm_dict');
	BSS.dispatch({code:21006,data:[dict]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>