<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<table style="text-align:center">
	<tr>
		<td>事件名称</td>
		<td><input id="motevt_name" type="text" name="evtname"class="easyui-textbox" style="width:200px;" readonly="readonly"/></td>
	</tr>
</table>
<form id="frm_motevtsem" method="post">
	<input id="id_evtid"  name="evtid" class="easyui-textbox" type="hidden" value="${id }"/>
	<input type="hidden" name="isactive" value="1" />
	<table style="text-align:center">
		<tr>
			<td>渠&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;道</td>
			<td><input id="motevtsme_chinid" type="text" name="chnid" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
		</tr>
		<tr>
			<td>事件方案</td>
			<td><input id="motevtsme_schmid" type="text" name="schmid" class="easyui-textbox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td>处理方式</td>
			<td><input id="motevtsme_auto" type="text" name="isautomatic" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
	</table>
</form>
<div style="text-align:right;">
	<a id="lnk_viewshow" href="javascript:void(0);" class="easyui-linkbutton" onclick="add()" data-options="iconCls:'icon-add'" style="width:80px">添加</a>
</div>
<table id="tbl_motevtcon_datagrid" class="easyui-datagrid"></table>
<script>
$(function(){
	var options={
		columns:[[
          {field:'chnidStr',title: '渠道',align: 'center',width: 100},
          {field:'chnid',title: '渠道',align: 'center',hidden:true},
          {field:'schmid',title: '方案',align: 'center',hidden:true},
          {field:'schmname',title: '方案名称',align: 'center',width: 100},
          {field:'schmdesc',title: '方案描述',align: 'center',width: 100},
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
	motevtsmeGrid.build(options,{code:22016,data:[{evtid:'${id}'}]});
	
	var schemCombox = new BSS.Combox('#motevtsme_schmid');
	var chinCombox = new BSS.Combox('#motevtsme_chinid');
	var automaticCombox = new BSS.Combox('#motevtsme_auto');
	
	chinCombox.fromDict('DICT_CHNAL',function(){
		automaticCombox.fromDict('DICT_AUTO');
	});
	
	//方案列表
	setTimeout(function () { 
		BSS.dispatch({code:22004},function(resp){
			var datas = resp.data;
			var options = {valueField:'id',textField:'schmname',data:datas};
			schemCombox.init(options);
			});
    }, 100);
	
	//事件名
	setTimeout(function () { 
		BSS.dispatch({code:22013,data:[{id:'${id}'}]},function(resp){
			var datas = resp.data;
			$("#motevt_name").textbox('setValue',datas[0].evtname);
			});
    }, 200);
})


function add()
{  
	var evt = BSS.form2json('#frm_motevtsem');
	BSS.dispatch({code:22015,data:[evt]},function(resp){
		if(resp.code == 0){
			BSS.info('保存成功');
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}

function deleteMot(id)
{  
	BSS.dispatch({code:22017,data:[{id:id}]},function(resp){
		if(resp.code == 0){
			BSS.info('删除成功');
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});	    
}
</script>