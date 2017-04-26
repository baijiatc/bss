<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_supp" method="post">
	<table cellpadding="5">
		<tr>
			<td>供应商名称：</td>
			<td>
				<input id="id_suppname" class="easyui-textbox" type="text" name="suppname" data-options="required:true"></input>
				<input id="id_suppid" class="easyui-textbox" type="hidden" name="suppid"></input>
			</td>
		</tr>
		<tr>
			<td>供应商级别：</td>
			<td><input id="cbx_supplv" class="easyui-textbox" type="text" name="supplv" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>联系人：</td>
			<td><input id="id_contact" class="easyui-textbox" type="text" name="contact" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>手机：</td>
			<td><input id="id_mobile" class="easyui-textbox" type="text" name="mobile" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>电话：</td>
			<td><input id="id_telephone" class="easyui-textbox" type="text" name="telephone" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>联系地址：</td>
			<td><input id="id_address" class="easyui-textbox" type="text" name="address" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>是否开店：</td>
			<td><input id="cbx_isopenshop" class="easyui-textbox" type="text" name="isopenshop" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var supCombox = new BSS.Combox('#cbx_supplv');
supCombox.fromDict('DICT_SUPPLV');
var isCombox = new BSS.Combox('#cbx_isopenshop');
isCombox.fromDict('DICT_ISOPENSHOP');

BSS.dispatch({code:13013,data:[{suppid:'${suppid}'}]},function(resp){
	BSS.json2form('#frm_supp',resp.data[0]);
});
SUPPLIERDIALOG.ok = function(){
	var supp = BSS.form2json('#frm_supp');
	BSS.dispatch({code:13002,data:[supp]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>