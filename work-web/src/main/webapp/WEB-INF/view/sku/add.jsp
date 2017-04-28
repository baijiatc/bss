<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_sku" method="post">
	<table cellpadding="5">
		<tr>
			<td>商品SKU名称：</td>
			<td><input class="easyui-textbox" type="text" name="skuname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>条形码：</td>
			<td><input class="easyui-textbox" type="text" name="barcode" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>商品SKU价格：</td>
			<td><input class="easyui-textbox" type="text" name="price" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>市场价格：</td>
			<td><input class="easyui-textbox" type="text" name="mktprice" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>来源平台：</td>
			<td><input id="cbx_fromsys" class="easyui-textbox" type="text" name="fromsys" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>平台编码：</td>
			<td><input class="easyui-textbox" type="text" name="sourceid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>产品：</td>
			<td><input class="easyui-textbox" type="text" name="productid" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var objCombox = new BSS.Combox('#cbx_fromsys');
objCombox.fromDict('DICT_FROMSYS',function(){
	setOk();
});
function setOk(){
	SKUDIALOG.ok = function(){
		var sku = BSS.form2json('#frm_sku');
		BSS.dispatch({code:14016,data:[sku]},function(){
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