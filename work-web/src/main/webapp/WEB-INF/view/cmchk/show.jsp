<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_cstmchk_show_pnl">
	<table id="tbl_cstmchk_datagrid" class="easyui-datagrid"></table>
</div>
<div id="div_cstmchk_show_pnlheader">
	<a id="lnk_viewshow" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width:80px">查看资质</a>
</div>
<script>
$(function(){
	var options={
		columns:[[
          {field:'cstmid',title: 'ID',align: 'center',hidden:'true'},
          {field:'cstmno',title: '商户编号',align: 'center',width: 200},
          {field:'cstmname',title: '商户名称',align: 'center',width: 200},
          {field:'mobile',title: '手机',align: 'center',width: 200},
          {field:'cstmlevel',title: '级别',align: 'center',width: 200},
          {field:'cstmst',title: '状态值',align: 'center',hidden:'true'},
          {field:'cstmstStr',title: '状态',align: 'center',width: 200},
          {field:'regtime',title: '申请时间',align: 'center',width: 200}
		]]
	};
	var cstmchkGrid = new BSS.DataGrid('#tbl_cstmchk_datagrid');
	cstmchkGrid.toolbar=null;
	cstmchkGrid.build(options,{code:12002,data:[{cstmtype:2,cstmst:1}]});
	var showPnl =new BSS.Panel('#div_cstmchk_show_pnl');
	showPnl.init({header:'#div_cstmchk_show_pnlheader'});
	$('#lnk_viewshow').click(function(){
		var row=cstmchkGrid.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要查看的商户');
			return;
		}
		var cid = row['cstmid'];
		BSS.showView('cstmchk/cert/'+cid+'.html',function(html){
			MAINTAB.updateSelectedTab(html);
		});
	});
});
</script>