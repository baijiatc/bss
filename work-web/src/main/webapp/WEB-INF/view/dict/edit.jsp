<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_dict" method="post">
	<table  >
		<tr>
			<td>枚举名称：</td>
			<td>
				<input class="easyui-textbox" id="id_dictname"  type="text" name="dictname" data-options="required:true"></input>
			    <input class="easyui-textbox"  id="id_dictid" type="hidden" name="dictid" data-options="required:true"></input>
			</td>
		</tr>
		
		<tr>
			<td>枚举值：</td>
			<td>
				<input class="easyui-textbox" id="id_dictval" type="text" name="dictval" data-options="required:true"></input>
			</td>
		</tr>
		
		<tr>
			<td>枚举类型：</td>
			<td>
		    	<input class="easyui-textbox"  id="id_dicttype" type="text" name="dicttype" data-options="required:true"></input>	 
			</td>
		</tr>
		
		<tr>
			<td>状态：</td>
			<td> 
		     <input class="easyui-textbox"  id="id_dictst" type="text" name="dictst" data-options="required:true"></input>
			</td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:21090,data:[{dictid:'${dictid}'}]},function(resp){
	BSS.json2form('#frm_dict',resp.data[0]);
});
DICTDIALOG.ok = function(){
	var dict = BSS.form2json('#frm_dict');
	BSS.dispatch({code:21006,data:[dict]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>