<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_staff" method="post">
	<table cellpadding="5">
		<tr>
			<td>员工姓名：</td>
			<td>
				<input class="easyui-textbox" type="text" name="staffname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><input id="cbx_gender" class="easyui-textbox" type="text" name="gender" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>手机：</td>
			<td><input class="easyui-textbox" type="text" name="mobile" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>身份证：</td>
			<td><input class="easyui-textbox" type="text" name="idcard" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>电话：</td>
			<td><input class="easyui-textbox" type="text" name="telephone" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>邮件：</td>
			<td><input class="easyui-textbox" type="text" name="email" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>教育程度：</td>
			<td><input id="cbx_edu" class="easyui-textbox" type="text" name="edu" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>岗位：</td>
			<td><input class="easyui-textbox" type="text" name="jobstation" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input class="easyui-textbox" type="text" name="passwd" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>联系地址：</td>
			<td><input class="easyui-textbox" type="text" name="address" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>所属部门：</td>
			<td><input id="cbx_departid" class="easyui-textbox" type="text" name="departid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>紧急联系人：</td>
			<td><input class="easyui-textbox" type="text" name="emername" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>紧急联系人手机：</td>
			<td><input class="easyui-textbox" type="text" name="emerphone" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>员工状态：</td>
			<td><input id="cbx_staffst" class="easyui-textbox" type="text" name="staffst" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>离职时间：</td>
			<td><input class="easyui-textbox" type="text" name="leavetime" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>入职时间：</td>
			<td><input class="easyui-textbox" type="text" name="jointime" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var genderCombox = new BSS.Combox('#cbx_gender');
var deptNameCombox = new BSS.Combox('#cbx_departid');
genderCombox.fromDict('DICT_GENDER',function(){
	var staffstCombox = new BSS.Combox('#cbx_staffst');
	staffstCombox.fromDict('DICT_STAFFST',function(){
		var eduCombox = new BSS.Combox('#cbx_edu');
		eduCombox.fromDict('DICT_EDU',function(){
			STAFFDIALOG.loadDepartName('#cbx_departid',function(){
				setOk();
			});
		});
	});
});
function setOk(){
	STAFFDIALOG.ok = function(){
		var staff = BSS.form2json('#frm_staff');
		BSS.dispatch({code:11001,data:[staff]},function(resp){
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