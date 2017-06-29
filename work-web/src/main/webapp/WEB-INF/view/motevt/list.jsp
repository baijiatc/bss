<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_motevt_datagrid" class="easyui-datagrid"></table>
<div id="div_motevtadd" style="padding:0 0 0 50px;"></div>
<div id="motevt_query" style="display:none;"></div>
<div id="motevt_control" style="display:none;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'evtname',title: '事件名称',align: 'center',width: 100},
          {field:'evtdesc',title: '事件描述',align: 'center',width: 100},
          {field:'evtstats',title: '事件状态',align: 'center',width: 100,hidden:'true'},
          {field:'evtstatStr',title: '事件状态',align: 'center',width: 100},
          {field:'biztype',title: '业务类型',align: 'center',width: 100,hidden:'true'},
          {field:'biztypeStr',title: '业务类型',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	
	MOTEVTGRID = new BSS.DataGrid('#tbl_motevt_datagrid');
	MOTEVTDIALOG = new BSS.Dialog('#div_motevtadd');
	MOTEVTGRID.toolbar.push({
		text:'查找',
		iconCls:'icon-search',
		handler:function(){
			showQueryDialog();
		}
	});
	MOTEVTGRID.toolbar.push({
		text:'设定群体',
		iconCls:'icon-tip',
		handler:function(){
			showQueryDialog();
		}
	});
	MOTEVTGRID.toolbar.push({
		text:'绑定条件',
		iconCls:'icon-ok',
		handler:function(){
			showQueryDialog();
		}
	});
	//支配方案
	MOTEVTCONTROLDIALOG = new BSS.Dialog('#motevt_control');
	MOTEVTGRID.toolbar.push({iconCls:'icon-redo',text:'支配方案',handler:function(){
	var row =MOTEVTGRID.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要支配的方案');
			return;
		}
			var id = row['id'];
			MOTEVTCONTROLDIALOG.init({href:'motevt/'+id+'/control.html',width:500,height:500});
		}
	});
	MOTEVTGRID.build(options,{code:22013});
	//设置新建事件
	MOTEVTGRID.create = function(){
		MOTEVTDIALOG.init({href:'motevt/add.html',width:400});
	};
	//设置编辑事件
	MOTEVTGRID.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		MOTEVTDIALOG.init({href:'motevt/'+id+'.html',width:400});
	};
	//查询
	MOTEVTQUERYDIALOG = new BSS.Dialog('#motevt_query');
	function showQueryDialog(){
		BSS.showView('motevt/query.html',function(html){
			MOTEVTQUERYDIALOG.init({width:400,height:200,content:html});
		});
	}
})
</script>