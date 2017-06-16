<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_motidx_datagrid" class="easyui-datagrid"></table>
<div id="div_motidxadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'idxname',title: '指标名称',align: 'center',width: 100},
          {field:'tblid',title: '数据源表',align: 'center',width: 100},
          {field:'colid',title: '数据源列',align: 'center',width: 100},
          {field:'biztype',title: '业务类型',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var motidxGrid = new BSS.DataGrid('#tbl_motidx_datagrid');
	MOTIDXDIALOG = new BSS.Dialog('#div_motidxadd');
	motidxGrid.build(options,{code:22007});
	//设置新建事件
	motidxGrid.create = function(){
		MOTIDXDIALOG.init({href:'motidx/add.html',width:400});
	};
	//设置编辑事件
	motidxGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		MOTIDXDIALOG.init({href:'motidx/'+id+'.html',width:400});
	};
})
</script>