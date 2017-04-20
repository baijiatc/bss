<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_parm_datagrid" class="easyui-datagrid"></table>
<div id="div_parmadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'paramname',title: '参数名称',align: 'center',width: 100},
          {field:'paramdesc',title: '参数描述',align: 'center',width: 100},
          {field:'paramtype',title: '参数类型',align: 'center',width: 100},
          {field:'paramst',title: '规格状态',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_parm_datagrid');
	PARMDIALOG = new BSS.Dialog('#div_parmadd');
	dataGrid.build(options,{code:14009});
	//设置新建事件
	dataGrid.create = function(){
		PARMDIALOG.init({href:'param/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		PARMDIALOG.init({href:'param/'+id+'.html',width:400});
	};
})
</script>