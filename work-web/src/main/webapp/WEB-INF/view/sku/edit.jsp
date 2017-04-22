<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_sku" method="post">
	<table cellpadding="5">
		<tr>
			<td>商品SKU名称：</td>
			<td><input id="id_skuname" class="easyui-textbox" type="text" name="skuname" data-options="required:true"></input></td>
			<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
		</tr>
		<tr>
			<td>条形码：</td>
			<td><input id="id_barcode" class="easyui-textbox" type="text" name="barcode" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>商品SKU价格：</td>
			<td><input id="id_price" class="easyui-textbox" type="text" name="price" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>市场价格：</td>
			<td><input id="id_mktprice" class="easyui-textbox" type="text" name="mktprice" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>来源平台：</td>
			<td><input id="id_fromsys" class="easyui-textbox" type="text" name="fromsys" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>平台编码：</td>
			<td><input id="id_sourceid" class="easyui-textbox" type="text" name="sourceid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>产品：</td>
			<td><input id="id_productid" class="easyui-textbox" type="text" name="productid" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:14021,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_sku',resp.data[0]);
});
SKUDIALOG.ok = function(){
	var sku = BSS.form2json('#frm_sku');
	BSS.dispatch({code:14017,data:[sku]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>