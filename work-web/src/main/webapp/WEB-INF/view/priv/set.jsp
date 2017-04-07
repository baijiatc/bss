<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_privset_container" style="height:491px;">
	<div id="div_privset_left" data-options="region:'west'" style="width:150px;height:80px;">
		<div id="div_privset_west_pnl">
			<ul id="ul_privset_role_tree">
				<li>
					<span>客服角色</span>
					<ul>
						<li><span>客服人员1</span></li>
						<li><span>客服人员2</span></li>
						<li><span>客服人员3</span></li>
						<li><span>客服人员4</span></li>
					</ul>
				</li>
				<li>
					<span>市场角色</span>
					<ul>
						<li><span>市场人员1</span></li>
						<li><span>市场人员2</span></li>
						<li><span>市场人员3</span></li>
						<li><span>市场人员4</span></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<div id="div_privset_center" data-options="region:'center'" style="width:auto">
		<div id="div_privset_center_pnl"></div>
	</div>
</div>
<!-- javascript部分 -->
<script>
$(function(){
	var privsetLayout = new BSS.Layout('#div_privset_container');
	var privsetWestPnl =new BSS.Panel('#div_privset_west_pnl');
	var privsetRoleTree =new BSS.Tree('#ul_privset_role_tree');
	privsetLayout.layout();
	var html = $('#div_privset_west_pnl').html();
	privsetWestPnl.init({
		title:'角色员工列表',
		tools:[{
			iconCls:'icon-save',
			handler:function(){
				BSS.info('保存成功！');
			}
		}]
	},html);
	privsetRoleTree.init({
		onClick:function(node){
			showPrivDetView(node.text);
		}
	});
});
function showPrivDetView(title){
	BSS.showView('privset/det.html',function(html){
		var options = {title:'['+title+']权限分配'};
		var privsetCenterPnl =new BSS.Panel('#div_privset_center_pnl');
		privsetCenterPnl.init(options,html);
	});
}
</script>