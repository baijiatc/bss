<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_actawd_datagrid" class="easyui-datagrid"></table>
<div id="div_actawdadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'actid',title: '活动名称',align: 'center',width: 200},
          {field:'awardtype',title: '奖励类型',align: 'center',width: 200},
          {field:'awobj',title: '奖励对象',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	var actawdGrid = new BSS.DataGrid('#tbl_actawd_datagrid');
	ACTWARDDIALOG = new BSS.Dialog('#div_actawdadd');
	actawdGrid.build(options,{code:19009});
	//设置新建事件
	actawdGrid.create = function(){
		ACTWARDDIALOG.init({href:'actawd/add.html',width:400});
	};
	//设置编辑事件
	actawdGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		ACTWARDDIALOG.init({href:'actawd/'+id+'.html',width:400});
	};
})
</script>