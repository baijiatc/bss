<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_quartz_datagrid" class="easyui-datagrid"></table>
<div id="div_quartzadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'SCHED_NAME',title: '调度器名称',align: 'center',hidden:'true'},
          {field:'TRIGGER_NAME',title: '触发器名称',align: 'center',hidden:'true'},
          {field:'TRIGGER_GROUP',title: '触发器组',align: 'center',hidden:'true'},
          {field:'JOB_NAME',title: '任务名称',align: 'center',width: 150},
          {field:'JOB_GROUP',title: '任务组',align: 'center',hidden:'true'},
          {field:'NEXT_FIRE_TIME',title: '下次触发时间',align: 'center',width: 150,formatter:formatTime},
          {field:'PREV_FIRE_TIME',title: '上次触发时间',align: 'center',width: 150,formatter:formatTime},
          {field:'PRIORITY',title: '优先级',align: 'center',width: 100},
          {field:'TRIGGER_STATE',title: '当前状态',align: 'center',width: 100},
          {field:'TRIGGER_TYPE',title: '类型',align: 'center',width: 100},
          {field:'START_TIME',title: '开始时间',align: 'center',width: 150,formatter:formatTime},
          {field:'END_TIME',title: '结束时间',align: 'center',width: 150,formatter:formatTime},
          {field:'DESCRIPTION',title: '描述',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var quartzGrid = new BSS.DataGrid('#tbl_quartz_datagrid');
	quartzGrid.toolbar = 
	[
  	    {id:'dg_tool_resume',disabled:true,iconCls:'icon-repair',text:'恢复',handler:function(){
  	    	var row=quartzGrid.getSelectedRow();
  			if(BSS.Helper.isNull(row)){
  				BSS.warning('请选择要恢复的数据行');
  				return;
  			}
  			var jobname = row['JOB_NAME'];
  			var jobgroup = row['JOB_GROUP'];
  			BSS.dispatch({code:17004,data:[{jobname:jobname,jobgroup:jobgroup}]},function(){
  				$('#dg_tool_pause').linkbutton("enable");
  				$('#dg_tool_resume').linkbutton("disable");
  				quartzGrid.load({code:17001});
  			},function(){});
  	    }},
  	    {id:'dg_tool_pause',disabled:true,iconCls:'icon-lock',text:'暂停',handler:function(){
  	    	var row=quartzGrid.getSelectedRow();
  			if(BSS.Helper.isNull(row)){
  				BSS.warning('请选择要暂停的数据行');
  				return;
  			}
  			var jobname = row['JOB_NAME'];
  			var jobgroup = row['JOB_GROUP'];
  			BSS.dispatch({code:17002,data:[{jobname:jobname,jobgroup:jobgroup}]},function(){
  				$('#dg_tool_pause').linkbutton("disable");
  				$('#dg_tool_resume').linkbutton("enable");
  				quartzGrid.load({code:17001});
  			},function(){});
  	    }},
  	    {id:'dg_tool_hand',iconCls:'icon-redo',text:'手动执行',handler:function(){
  	    	var row=quartzGrid.getSelectedRow();
  			if(BSS.Helper.isNull(row)){
  				BSS.warning('请选择要手动触发的数据行');
  				return;
  			}
  			var jobname = row['JOB_NAME'];
  			var jobgroup = row['JOB_GROUP'];
  			BSS.dispatch({code:17003,data:[{jobname:jobname,jobgroup:jobgroup}]},function(resp){
  				console.log(JSON.stringify(resp));
  			},function(resp){
  				console.log('err:'+JSON.stringify(resp));
  			});
  	    }}
  	];
	QUARTZDIALOG = new BSS.Dialog('#div_quartzadd');
	quartzGrid.build(options,{code:17001});
	quartzGrid.clickRow = function(ridx,rdat){
		var jobPaused = rdat['TRIGGER_STATE']=='PAUSED';
		var jobWaiting = rdat['TRIGGER_STATE']=='WAITING';
		if(jobPaused){
			$('#dg_tool_pause').linkbutton("disable");
		}else{
			$('#dg_tool_pause').linkbutton("enable");
		}
		if(jobWaiting){
			$('#dg_tool_resume').linkbutton("disable");
		}else{
			$('#dg_tool_resume').linkbutton("enable");
		}
	};
})

function formatTime(val,row){
	if(val <= 0){return '-';}
	var valDate = new Date(val);
	return BSS.DateTime.format(valDate);
}
</script>