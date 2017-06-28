<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_motjob_datagrid" class="easyui-datagrid"></table>
<div id="job_query" style="display:none;"></div>
<div id="job_dispose" style="display:none;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
		          {field:'id',title: 'ID',align: 'center',hidden:'true'},
		          {field:'evtid',title: '事件名称',align: 'center',width: 220},
		          {field:'priority',title: '优先级',align: 'center',width: 220},
 		          {field:'isauto',title: '任务性质',align: 'center',width: 220},
 		          {field:'executor',title: '执行人',align: 'center',width: 220},
		          {field:'jobstats',title: '任务状态',align: 'center',width: 220},
 		          {field:'begintime',title: '开始时间',align: 'center',width: 220},
		          {field:'endtime',title: '结束时间',align: 'center',width: 200},
		          {field:'finishtime',title: '完成时间',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	JOBGRID = new BSS.DataGrid('#tbl_motjob_datagrid');
	JOBGRID.toolbar=[{text:'<b>任务管理</b>',iconCls:'icon-tip'}];
	//查询
	 JOBGRID.toolbar.push({iconCls:'icon-search',text:'查询 ',
		handler:function(){
			showJQueryDialog();
	}
	});
	//处理
// 	JOBGRID.toolbar.push({iconCls:'icon-redo',text:'处理',
// 		handler:function(){
//     	showDisDialog();
// 	}
// 	});
	 
	JOBGRID.build(options,{code:23001});
	 
// 	//设置处理事件
// 	SCMEGRID.edit = function(){
// 		var row=this.getSelectedRow();
// 		if(BSS.Helper.isNull(row)){
// 			BSS.warning('请选择要编辑的数据行');
// 			return;
// 		}
// 		var id = row['id'];
// 		SCHEMEDIALOG.init({href:'scheme/'+id+'.html',width:400});
// 	};
	
})
    JOBQUERYDIALOG = new BSS.Dialog('#job_query');
	function showJQueryDialog(){
		BSS.showView('motjob/find.html',function(html){
			JOBQUERYDIALOG.init({width:400,height:400,content:html});
		});
	}

</script>