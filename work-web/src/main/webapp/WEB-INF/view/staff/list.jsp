<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_staff_datagrid" class="easyui-datagrid"></table>
<div id="div_staffadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'staffid',title: 'ID',align: 'center',hidden:'true'},
          {field:'staffname',title: '员工姓名',align: 'center',width: 100},
          {field:'gender',title: '性别值',align: 'center',hidden:'true'},
          {field:'genderStr',title: '性别',align: 'center',width: 100},
          {field:'mobile',title: '手机',align: 'center',width: 100},
          {field:'idcard',title: '身份证',align: 'center',width: 100},
          {field:'telephone',title: '电话',align: 'center',width: 100},
          {field:'email',title: '邮件',align: 'center',width: 100},
          {field:'edu',title: '教育程度值',align: 'center',hidden:'true'},
          {field:'eduStr',title: '教育程度',align: 'center',width: 100},
          {field:'jobstation',title: '岗位',align: 'center',width: 100},
          {field:'address',title: '联系地址',align: 'center',width: 100},
          {field:'departid',title: '所属部门',align: 'center',width: 100},
          {field:'emername',title: '紧急联系人',align: 'center',width: 100},
          {field:'emerphone',title: '紧急联系人手机',align: 'center',width: 100},
          {field:'staffst',title: '员工状态值',align: 'center',hidden:'true'},
          {field:'staffStr',title: '员工状态',align: 'center',width: 100},
          {field:'leavetime',title: '离职时间',align: 'center',width: 150,formatter:BSS.formatTime},
          {field:'jointime',title: '入职时间',align: 'center',width: 150,formatter:BSS.formatTime},
          {field:'creator',title: '创建人',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_staff_datagrid');
	STAFFDIALOG = new BSS.Dialog('#div_staffadd');
	dataGrid.toolbar.push({iconCls:'icon-redo',text:'分配角色',handler:function(){
			var row = dataGrid.getSelectedRow();
			if(BSS.Helper.isNull(row)){
				BSS.warning('请选择要分配的员工');
				return;
		}
		var staffid = row['staffid'];
		STAFFDIALOG.init({href:'staffrole/'+staffid+'.html',width:400});
	}});
	dataGrid.build(options,{code:11003});
	//设置新建事件
	dataGrid.create = function(){
		STAFFDIALOG.init({href:'staff/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var staffid = row['staffid'];
		STAFFDIALOG.init({href:'staff/'+staffid+'.html',width:400});
	};
})
</script>