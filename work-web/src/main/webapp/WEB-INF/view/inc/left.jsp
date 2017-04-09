<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_leftview">
	<div title="员工管理" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="staff/show.html"><a href="javascript:void(0)">员工管理</a></li>
			<li data-href="passwd/show.html"><a href="javascript:void(0)">密码管理</a></li>
			<li data-href="dprt/show.html"><a href="javascript:void(0)">机构管理</a></li>
		</ul>
	</div>
	<div title="客户维护" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="cstmchk/show.html"><a href="javascript:void(0)">客户审核</a></li>
			<li data-href="cstmls/show.html"><a href="javascript:void(0)">客户查询</a></li>
			<li data-href="cstmrs/show.html"><a href="javascript:void(0)">客户员工关系</a></li>
		</ul>
	</div>
	<div title="合作伙伴" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="supp/show.html"><a href="javascript:void(0)">供应商管理</a></li>
			<li data-href="supprs/show.html"><a href="javascript:void(0)">供应商员工关系</a></li>
			<li data-href="chan/show.html"><a href="javascript:void(0)">渠道管理</a></li>
			<li data-href="chanrs/show.html"><a href="javascript:void(0)">渠道员工关系</a></li>
		</ul>
	</div>
	<div title="产品维护" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="brand/show.html"><a href="javascript:void(0)">品牌管理</a></li>
			<li data-href="cat/show.html"><a href="javascript:void(0)">品类管理</a></li>
			<li data-href="param/show.html"><a href="javascript:void(0)">参数维护</a></li>
			<li data-href="spec/show.html"><a href="javascript:void(0)">规格维护</a></li>
			<li data-href="prod/show.html"><a href="javascript:void(0)">产品管理</a></li>
			<li data-href="sku/show.html"><a href="javascript:void(0)">SKU管理</a></li>
		</ul>
	</div>
	<div title="库存管理" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="stock/show.html"><a href="javascript:void(0)">库存</a></li>
			<li data-href="alarm/show.html"><a href="javascript:void(0)">预警配置</a></li>
		</ul>
	</div>
	<div title="交易记录" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="order/show.html"><a href="javascript:void(0)">订单</a></li>
			<li data-href="flow/show.html"><a href="javascript:void(0)">资金流水</a></li>
		</ul>
	</div>
	<div title="数据传输" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="trans/show.html"><a href="javascript:void(0)">数据传输</a></li>
		</ul>
	</div>
	<div title="绩效配置" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="idx/show.html"><a href="javascript:void(0)">指标</a></li>
			<li data-href="idxparam/show.html"><a href="javascript:void(0)">指标参数</a></li>
			<li data-href="idxrate/show.html"><a href="javascript:void(0)">参数比例</a></li>
		</ul>
	</div>
	<div title="营销活动" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="act/show.html"><a href="javascript:void(0)">活动</a></li>
			<li data-href="actparam/show.html"><a href="javascript:void(0)">活动参数</a></li>
			<li data-href="actawd/show.html"><a href="javascript:void(0)">活动奖励</a></li>
			<li data-href="actrule/show.html"><a href="javascript:void(0)">活动规则</a></li>
		</ul>
	</div>
	<div title="权限管理" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="priv/show.html"><a href="javascript:void(0)">权限定义</a></li>
			<li data-href="privset/show.html"><a href="javascript:void(0)">权限分配</a></li>
			<li data-href="role/show.html"><a href="javascript:void(0)">角色管理</a></li>
		</ul>
	</div>
	<div title="系统设置" data-options="iconCls:'icon-blank'" style="overflow:auto;padding:10px;">
		<ul style="margin:0;padding:0 0 0 20px">
			<li data-href="menu/show"><a href="javascript:void(0)">菜单维护</a></li>
			<li data-href="syslog/show.html"><a href="javascript:void(0)">日志查询</a></li>
			<li data-href="dict/show.html"><a href="javascript:void(0)">字典管理</a></li>
			<li data-href="sysparam/show.html"><a href="javascript:void(0)">参数设定</a></li>
		</ul>
	</div>
</div>
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$('#div_leftview').accordion({border:false});
$('div[id^="div_leftview"] ul>li').click(function(){
	var url = $(this).attr('data-href');
	var title = $(this).text();
	BSS.showView(url,function(html){
		MAINTAB.add(title,html);
	});
});
</script>