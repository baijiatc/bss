<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_pass_show_pnl">
		<table id="tbl_passwd_datagrid" class="easyui-datagrid"></table>
</div>
<div id="div_pass_show_pnlheader">
	<a id="lnk_viewshow" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:80px">重置密码</a>
</div>
<div id="passwd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'staffid',title: 'ID',align: 'center',hidden:'true'},
          {field:'staffname',title: '员工姓名',align: 'center',width: 100},
          {field:'gender',title: '性别',align: 'center',width: 100},
          {field:'mobile',title: '手机',align: 'center',width: 100},
          {field:'idcard',title: '身份证',align: 'center',width: 100},
          {field:'telephone',title: '电话',align: 'center',width: 100},
          {field:'jobstation',title: '岗位',align: 'center',width: 100},
          {field:'passwd',title: '密码',align: 'center',width: 100},
          {field:'departid',title: '所属部门',align: 'center',width: 100},
          {field:'staffst',title: '员工状态',align: 'center',width: 100},
          {field:'leavetime',title: '离职时间',align: 'center',width: 100},
          {field:'jointime',title: '入职时间',align: 'center',width: 100},
          {field:'creator',title: '创建人',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var passGrid = new BSS.DataGrid('#tbl_passwd_datagrid');
	PASSDIALOG = new BSS.Dialog('#passwd');
	passGrid.toolbar=null;
	passGrid.build(options,{code:11003});
	var showPnl =new BSS.Panel('#div_pass_show_pnl');
	showPnl.init({header:'#div_pass_show_pnlheader'});
	$('#lnk_viewshow').click(function(){
		var row=passGrid.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要修改密码的员工');
			return;
		}
		var staffid = row['staffid'];
		PASSDIALOG.init({href:'passwd/'+staffid+'.html',width:400,height:300});
		});
})
</script>