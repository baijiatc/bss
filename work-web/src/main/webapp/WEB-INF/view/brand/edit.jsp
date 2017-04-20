<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_brand" method="post">
	<table cellpadding="5">
			<tr>
			<td>品牌名称：</td>
			<td>
				<input  id="id_brandname" class="easyui-textbox" type="text" name="brandname" data-options="required:true"></input>
			    <input  id="id_id" class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>品牌别称：</td>
			<td><input  id="id_brandalias" class="easyui-textbox" type="text" name="brandalias" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>品牌网址：</td>
			<td><input   id="id_weburl" class="easyui-textbox" type="text" name="weburl" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>品牌介绍：</td>
			<td><input  id="id_branddesc" class="easyui-textbox" type="text" name="branddesc" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>品牌logo：</td>
			<td><input  id="id_brandlogo" class="easyui-textbox" type="text" name="brandlogo" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>排序：</td>
			<td><input  id="id_sort" class="easyui-textbox" type="text" name="sort" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input  id="id_brandst" class="easyui-textbox" type="text" name="brandst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:14090,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_brand',resp.data[0]);
});
BRANDDIALOG.ok = function(){
	var brand = BSS.form2json('#frm_brand');
	BSS.dispatch({code:14002,data:[brand]},function(){
		BSS.alert('保存成功！');
	},function(){});	
}
</script>