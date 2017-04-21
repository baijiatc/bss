<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_prod" method="post">
	<table cellpadding="6">
		<tr>
			<td>源标识：</td>
			<td>
				<input class="easyui-textbox" type="text" name="sourceid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>来源平台：</td>
			<td><input class="easyui-textbox" type="text" name="fromsys" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>名称：</td>
			<td><input class="easyui-textbox" type="text" name="prodname" data-options="required:false"></input></td>
		</tr>
			<tr>
			<td>类别：</td>
			<td><input class="easyui-textbox" type="text" name="catid" data-options="required:false"></input></td>
		</tr>
		
		<tr>
			<td>品牌：</td>
			<td><input class="easyui-textbox" type="text" name="brandid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>商品详情：</td>
			<td><input class="easyui-textbox" type="text" name="description" data-options="required:true"></input></td>
		</tr>
		 
	</table>
</form>
<script>
PRODDIALOG.ok = function(){
	var prod= BSS.form2json('#frm_prod');
	BSS.dispatch({code:14013,data:[prod]},function(){
		BSS.alert("添加成功");;
	},function(){});
}
</script>