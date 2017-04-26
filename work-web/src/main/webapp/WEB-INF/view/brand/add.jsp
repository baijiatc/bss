<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_brand" method="post">
	<table cellpadding="7">
		<tr>
			<td>品牌名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="brandname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>品牌别称：</td>
			<td><input class="easyui-textbox" type="text" name="brandalias" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>品牌网址：</td>
			<td><input class="easyui-textbox" type="text" name="weburl" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>品牌介绍：</td>
			<td><input class="easyui-textbox" type="text" name="branddesc" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>品牌logo：</td>
			<td><input class="easyui-textbox" type="text" name="brandlogo" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>排序：</td>
			<td><input class="easyui-textbox" type="text" name="sort" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input id="cbx_brandst"  class="easyui-textbox" type="text" name="brandst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var brandStCombox = new BSS.Combox('#cbx_brandst');
brandStCombox.fromDict('DICT_BRANDST',function(){
	setOk();
});

function setOk(){
	BRANDDIALOG.ok = function(){
		var brand = BSS.form2json('#frm_brand');
		BSS.dispatch({code:14001,data:[brand]},function(resp){
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