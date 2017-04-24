<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_factor_datagrid" class="easyui-datagrid"></table>
<div id="div_factoradd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'factid',title: 'ID',align: 'center',hidden:'true'},
          {field:'factname',title: '因子名称',align: 'center',width: 200},
          {field:'defaultval',title: '默认值',align: 'center',width: 200},
          {field:'defaultunit',title: '默认单位值',align: 'center',hidden:'true'},
          {field:'defaultunitStr',title: '默认单位',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var factorGrid = new BSS.DataGrid('#tbl_factor_datagrid');
	FACTORDIALOG = new BSS.Dialog('#div_factoradd');
	factorGrid.build(options,{code:15007});
	//设置新建事件
	factorGrid.create = function(){
		FACTORDIALOG.init({href:'factor/add.html',width:400});
	};
	//设置编辑事件
	factorGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var factorid = row['factid'];
		FACTORDIALOG.init({href:'factor/'+factorid+'.html',width:400});
	};
})
</script>