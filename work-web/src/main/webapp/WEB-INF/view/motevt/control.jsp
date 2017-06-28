<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form>
	<table style="text-align:center">
		<tr>
			<td>事件名称</td>
			<td><input id="motevt_name" type="text" class="easyui-textbox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td>渠&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;道</td>
			<td><input id="motevtsme_chinid" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td>事件方案</td>
			<td><input id="motevtsme_schmid" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td>处理方式</td>
			<td><input id="motevtsme_stats" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
	</table>
</form>
<div style="text-align:right;">
	<a id="lnk_viewshow" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="width:80px">添加</a>
</div>
<table id="tbl_motevtcon_datagrid" class="easyui-datagrid"></table>
<script>
$(function(){
	var options={
		columns:[[
          {field:'chnid',title: '渠道',align: 'center',width: 100},
          {field:'schmid',title: '方案',align: 'center',hwidth: 100},
          {field:'schmidStr',title: '方案描述',align: 'center',width: 100},
          {field:'id',title: '操作',align:'center',width:100,
        	  formatter:function(id){
	        	  var btn = '<a  onclick="deleteMot(\''+id+'\')" href="javascript:void(0)">删除</a>';  
	        	  return btn;
	          	}
	          }
		  ]]
	};
	//构建datagrid，并填充数据
	var motevtsmeGrid = new BSS.DataGrid('#tbl_motevtcon_datagrid');
	motevtsmeGrid.toolbar=null;
	motevtsmeGrid.build(options,{code:22016,data:[{id:'${id}'}]});
})
function deleteMot(id){  
	    alert(id);
	}
</script>