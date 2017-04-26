<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_spec_datagrid" class="easyui-datagrid"></table>
<div id="div_specadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'specname',title: '规格名称',align: 'center',width: 100},
          {field:'specdesc',title: '规格值说明',align: 'center',width: 100},
          {field:'spectype',title: '规格类型',align: 'center',hidden:'true'},
          {field:'spectypeStr',title: '规格类型',align: 'center',width: 100},
          {field:'specst',title: '规格状态',align: 'center',hidden:'true'},
          {field:'specstStr',title: '规格状态',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_spec_datagrid');
	SPECDIALOG = new BSS.Dialog('#div_specadd');
	dataGrid.build(options,{code:14012});
	//设置新建事件
	dataGrid.create = function(){
		SPECDIALOG.init({href:'spec/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		SPECDIALOG.init({href:'spec/'+id+'.html',width:400});
	};
})
</script>