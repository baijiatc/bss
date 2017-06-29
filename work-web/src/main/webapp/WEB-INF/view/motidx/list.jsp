<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_motidx_datagrid" class="easyui-datagrid"></table>
<div id="div_motidxadd" style="padding:0 0 0 50px;"></div>
<div id="motidx_query" style="display:none;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'idxname',title: '指标名称',align: 'center',width: 100},
          {field:'tblid',title: '数据源表ID',align: 'center',width: 100,hidden:'true'},
          {field:'tblname',title: '数据源表',align: 'center',width: 100},
          {field:'colid',title: '数据源列ID',align: 'center',width: 100,hidden:'true'},
          {field:'colname',title: '数据源列',align: 'center',width: 100},
          {field:'biztype',title: '业务类型',align: 'center',width: 100,hidden:'true'},
          {field:'biztypeStr',title: '业务类型',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	
	MOTIDXGRID = new BSS.DataGrid('#tbl_motidx_datagrid');
	MOTIDXDIALOG = new BSS.Dialog('#div_motidxadd');
	MOTIDXGRID.toolbar.push({
		text:'查找',
		iconCls:'icon-search',
		handler:function(){
			showQueryDialog();
		}
	});
	MOTIDXGRID.build(options,{code:22007});
	//设置新建事件
	MOTIDXGRID.create = function(){
		MOTIDXDIALOG.init({href:'motidx/add.html',width:400});
	};
	//设置编辑事件
	MOTIDXGRID.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		MOTIDXDIALOG.init({href:'motidx/'+id+'.html',width:400});
	};
	MOTIDXDIALOG.loadTblName=function(selector,callback){
		BSS.dispatch({code:22009},function(resp){
			if(resp.code == 0){
				var datas = resp.data;
				var options = {valueField:'id',textField:'tblname',data:datas};
				var tblCombox=new BSS.Combox(selector);
				tblCombox.init(options);
				if(jQuery.isFunction(callback)){
					callback();
				}
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){});
	}
	MOTIDXDIALOG.loadColName=function(selector,callback){
		BSS.dispatch({code:22010},function(resp){
			if(resp.code == 0){
				var datas = resp.data;
				var options = {valueField:'id',textField:'colname',data:datas};
				var colCombox=new BSS.Combox(selector);
				colCombox.init(options);
				if(jQuery.isFunction(callback)){
					callback();
				}
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){});
	}
	MOTIDXQUERYDIALOG = new BSS.Dialog('#motidx_query');
	function showQueryDialog(){
		BSS.showView('motidx/query.html',function(html){
			MOTIDXQUERYDIALOG.init({width:400,height:150,content:html});
		});
	}
})
</script>