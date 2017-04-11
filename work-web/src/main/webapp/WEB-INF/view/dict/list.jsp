<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_dict_datagrid" class="easyui-datagrid"></table>
<div id="div_dictadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'dictid',title: 'ID',align: 'center',hidden:'true'},
          {field:'dictname',title: '枚举名称',align: 'center',width: 200},
          {field:'dictval',title: '枚举值',align: 'center',width: 200},
          {field:'dicttype',title: '枚举类型',align: 'center',width: 200},
          {field:'dictst',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var dictGrid = new BSS.DataGrid('#tbl_dict_datagrid');
	DICTDIALOG = new BSS.Dialog('#div_dictadd');
	dictGrid.build(options,{code:21007});
	//设置新建事件
	dictGrid.create = function(){
		DICTDIALOG.init({href:'dict/add.html',width:400});
	};
	//设置编辑事件
	dictGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var dictid = row['dictid'];
		DICTDIALOG.init({href:'dict/'+dictid+'.html',width:400});
	};
})
</script>