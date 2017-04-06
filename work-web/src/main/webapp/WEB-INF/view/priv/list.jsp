<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid"></table>
<div id="div_privadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'privid',title: 'ID',align: 'center',hidden:'true'},
          {field:'privname',title: '权限名',align: 'center',width: 200},
          {field:'privdesc',title: '描述',align: 'center',width: 200},
          {field:'privtype',title: '分类',align: 'center',width: 200},
          {field:'privcat',title: '定位',align: 'center',width: 200},
          {field:'privst',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('.easyui-datagrid');
	PRIVDIALOG = new BSS.Dialog('#div_privadd');
	dataGrid.build(options,{code:20003});
	//设置新建事件
	dataGrid.create = function(){
		PRIVDIALOG.init({href:'priv/add',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var privid = row['privid'];
		PRIVDIALOG.init({href:'priv/'+privid,width:400});
	};
})
</script>