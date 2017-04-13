<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_idxrate_datagrid" class="easyui-datagrid"></table>
<div id="div_idxratesadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'parmid',title: '参数',align: 'center',width: 200},
          {field:'forshop',title: '适用店铺',align: 'center',width: 200},
          {field:'forcat',title: '适用品类',align: 'center',width: 200},
          {field:'forobj',title: '适用对象',align: 'center',width: 200},
          {field:'parmvalue',title: '参数值',align: 'center',width: 200},
          {field:'creator',title: '创建人',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_idxrate_datagrid');
	IDXRATEDIALOG = new BSS.Dialog('#div_idxratesadd');
	dataGrid.build(options,{code:18009});
	//设置新建事件
	dataGrid.create = function(){
		IDXRATEDIALOG.init({href:'idxrate/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		IDXRATEDIALOG.init({href:'idxrate/'+id+'.html',width:400});
	};
})
</script>