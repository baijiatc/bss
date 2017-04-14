<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_privset_container" style="height:491px;">
	<div id="div_privset_left" data-options="region:'west'" style="width:180px;height:80px;">
		<div id="div_privset_west_pnl">
			<div id="div_privset_tab">
				<div title="角色">
					<ul id="ul_privset_role_tree">
						<li>客服角色</li>
						<li>市场角色</li>
					</ul>
				</div>
				<div title="员工">
					<ul id="ul_privset_staff_tree">
						<li>员工1</li>
						<li>员工2</li>
					</ul>
				</div>
			</div>
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
	var privsetWestPnl = new BSS.Panel('#div_privset_west_pnl');
	var privsetTab = new BSS.Tab('#div_privset_tab');
	var privsetRoleTree = new BSS.Tree('#ul_privset_role_tree');
	var privsetStaffTree = new BSS.Tree('#ul_privset_staff_tree');
	privsetLayout.layout();
	var html = $('#div_privset_west_pnl').html();
	privsetWestPnl.init({
		title:'列表',
		tools:[{
			iconCls:'icon-save',
			handler:function(){
				var nodes = $('#ul_privset_show_tree').tree('getChecked', ['checked','indeterminate']);
				var arrStr = [];
				for(var i = 0; i < nodes.length; i++){
					arrStr.push(nodes[i].text);
				}
				BSS.info('选择了:'+JSON.stringify(arrStr))
			}
		}]
	},html);
	privsetTab.init();
	BSS.dispatch({code:20007,data:[{rolest:1}]},function(resp){
		var roles = [];
		var data = resp.data;
		var len = data.length;
		for(var i = 0; i < len; i++){
			var role = {text:data[i].rolename,id:data[i].roleid};
			roles.push(role);
		}
		privsetRoleTree.init({
			data:roles,
			onClick:function(node){
				showPrivDetView(node.text);
			}
		});
	},function(resp){});
	BSS.dispatch({code:11003,data:[{staffst:1}]},function(resp){
		var staffs = [];
		var data = resp.data;
		var len = data.length;
		for(var i = 0; i < len; i++){
			var staff = {text:data[i].staffname,id:data[i].staffid};
			staffs.push(staff);
		}
		privsetStaffTree.init({
			data:staffs,
			onClick:function(node){
				showPrivDetView(node.text);
			}
		});
	},function(resp){});
});
function showPrivDetView(title){
	BSS.showView('privset/det.html',function(html){
		var options = {title:'['+title+']权限分配'};
		var privsetCenterPnl =new BSS.Panel('#div_privset_center_pnl');
		privsetCenterPnl.init(options,html);
	});
}
</script>