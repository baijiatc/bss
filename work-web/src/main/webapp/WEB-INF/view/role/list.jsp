<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_role_datagrid" class="easyui-datagrid"></table>
<div id="div_roleadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'roleid',title: 'ID',align: 'center',hidden:'true'},
          {field:'rolename',title: '角色名称',align: 'center',width: 200},
          {field:'rolest',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var roleGrid = new BSS.DataGrid('#tbl_role_datagrid');
	ROLEDIALOG = new BSS.Dialog('#div_roleadd');
	roleGrid.build(options,{code:20003});
	//设置新建事件
	roleGrid.create = function(){
		ROLEDIALOG.init({href:'role/add',width:400});
	};
	//设置编辑事件
	roleGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var roleid = row['roleid'];
		if(BSS.Helper.isNull(row)){
			return;
		}
		ROLEDIALOG.init({href:'role/'+roleid,width:400});
	};
})
</script>