<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_actrule_datagrid" class="easyui-datagrid"></table>
<div id="div_actruleadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'actid',title: '活动',align: 'center',width: 200},
          {field:'objtype',title: '对象类型',align: 'center',width: 200},
          {field:'objid',title: '活动对象',align: 'center',width: 200},
          {field:'creator',title: '创建人',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	var actruleGrid = new BSS.DataGrid('#tbl_actrule_datagrid');
	ACTRULEDIALOG = new BSS.Dialog('#div_actruleadd');
	actruleGrid.build(options,{code:19012});
	//设置新建事件
	actruleGrid.create = function(){
		ACTRULEDIALOG.init({href:'actrule/add.html',width:400});
	};
	//设置编辑事件
	actruleGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		ACTRULEDIALOG.init({href:'actrule/'+id+'.html',width:400});
	};
})
</script>