<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="ul_privset_show_tree">
	<li>
		<span>员工管理</span>
		<ul>
			<li>
				<span>员工管理</span>
				<ul>
					<li><span>新增</span></li>
					<li><span>编辑</span></li>
					<li><span>查询</span></li>
				</ul>
			</li>
			<li>
				<span>密码管理</span>
				<ul>
					<li><span>重置</span></li>
					<li><span>修改</span></li>
				</ul>
			</li>
		</ul>
	</li>
	<li>
		<span>客户维护</span>
		<ul>
			<li>
				<span>客户审核</span>
				<ul>
					<li><span>	审核</span></li>
				</ul>
			</li>
			<li>
				<span>客户查询</span>
				<ul>
					<li><span>会员查询</span></li>
					<li><span>商户查询</span></li>
				</ul>
			</li>
		</ul>
	</li>
</ul>
<!-- javascript部分 -->
<script>
$(function(){
	var privsetShowTree =new BSS.Tree('#ul_privset_show_tree');
	privsetShowTree.init({
		checkbox:true,
		onClick:function(node){
			BSS.warning(node.text);
		}
	});
});
</script>