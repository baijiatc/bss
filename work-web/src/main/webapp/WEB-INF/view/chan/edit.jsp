<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_chanedit" method="post">
	<table cellpadding="5">
		<tr>
			<td>渠道名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="channame" data-options="required:true"></input>
				<input class="easyui-textbox" type="hidden" name="chanid"></input>
			</td>
		</tr>
		<tr>
			<td>渠道分类：</td>
			<td>
				<input class="easyui-textbox" type="text" name="chantype" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>联系人：</td>
			<td>
				<input class="easyui-textbox" type="text" name="contact" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>手机：</td>
			<td>
				<input class="easyui-textbox" type="text" name="mobile" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>省市区：</td>
			<td>
				<input class="easyui-textbox" type="text" style="width:18%" name="province"></input>
				<input class="easyui-textbox" type="text" style="width:18%" name="city"></input>
				<input class="easyui-textbox" type="text" style="width:18%" name="district"></input>
			</td>
		</tr>
		<tr>
			<td>地址：</td>
			<td>
				<input class="easyui-textbox" type="text" name="address" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>上级渠道：</td>
			<td>
				<input class="easyui-textbox" type="text" name="parentid"></input>
			</td>
		</tr>
		<tr>
			<td>渠道状态：</td>
			<td><input id="cbx_chanst" class="easyui-combobox" type="text" name="chanst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var chanstCombox = new BSS.Combox('#cbx_chanst');
chanstCombox.fromDict('DICT_CHANST');

BSS.dispatch({code:13014,data:[{chanid:'${chanid}'}]},function(resp){
	BSS.json2form('#frm_chan',resp.data[0]);
});
</script>