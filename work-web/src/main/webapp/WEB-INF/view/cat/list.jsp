<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_cat_datagrid" class="easyui-datagrid"></table>
<div id="div_catadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'catname',title: '分类名称',align: 'center',width: 200},
          {field:'parentid',title: '上级分类',align: 'center',width: 200},
          {field:'catlogo',title: '分类logo',align: 'center',width: 200},
          {field:'catst',title: '状态值',align: 'center',hidden:'true' },
          {field:'catstStr',title: '状态',align: 'center',width: 200},
         
		]]
	};
	//构建datagrid，并填充数据
	var catGrid = new BSS.DataGrid('#tbl_cat_datagrid');
	CATDIALOG = new BSS.Dialog('#div_catadd');
	catGrid.build(options,{code:14006});
	//设置新建事件
	catGrid.create = function(){
		CATDIALOG.init({href:'cat/add.html',width:400});
	};
	//设置编辑事件
	catGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		CATDIALOG.init({href:'cat/'+id+'.html',width:400});
	};
})
</script>