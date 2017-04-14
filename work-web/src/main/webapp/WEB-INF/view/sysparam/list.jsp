<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_sysparam" style="padding:10px;">
	<table id="tbl_sysparam"></table>
	<div id="div_sysparam_footer" align="right" style="padding:5px;">
		<a id="lnk_sysparam_refresh" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-refresh'">刷新</a>
		<a id="lnk_sysparam_update" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
	</div>
</div>
<!-- javascript部分 -->
 <script>
$(function(){
	var propGrid = new BSS.PropGrid('#tbl_sysparam');
	propGrid.init({showHeader:false,footer:'#div_sysparam_footer',width:500});
	BSS.dispatch({code:21009},function(resp){
		if(resp.code == 0){
			var data = resp.data;
			var len = data.length;
			for(var i = 0; i < len; i++){
				var item = data[i];
				var row = {name:item.paramname,value:item.paramvalue,group:'系统参数',editor:'text',id:item.paramid,remark:item.remark};
				propGrid.append(row);
			}
		}
	},function(resp){});
	
	$('#lnk_sysparam_update').click(function(){
		var rows = propGrid.getChanges();
		if(!rows || rows.length <= 0){
			BSS.info('未做任何更改！');
			return;
		}
		var len = rows.length;
		var params = [];
		for(var i = 0; i < len; i++){
			var row = rows[i];
			var param = {paramid:row.id,paramname:row.name,paramvalue:row.value,remark:row.remark};
			params.push(param);
		}
		BSS.dispatch({code:21015,data:params},function(resp){
			if(resp.code == 0){
				BSS.info('更新成功！');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			BSS.error(resp.message);
		});
	});
	
	$('#lnk_sysparam_refresh').click(function(){
		BSS.dispatch({code:21016},function(resp){
			if(resp.code == 0){
				BSS.info('刷新成功！<br/>请刷新页面！');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			BSS.error(resp.message);
		});
	});
})
</script>