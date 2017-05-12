<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<ul id="pro_tree">
	<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
</ul>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui-tree-extend.js" charset="utf-8"></script>
<script>
$(function(){
	var proTree = new BSS.Tree('#pro_tree');
			BSS.dispatch({code:30005,data:[{skuid:'${id}'}]},function(resp){
				if(resp.code == 0){
					var nodes = [];
					var data = resp.data;
					var len = data.length;
					for(var i = 0; i < len; i++){
						var prod = data[i];
						var node = {text:prod.prodname,id:prod.id,checked:prod.checked};
						nodes.push(node);
					}
					proTree.init({
						data:nodes,
						checkbox:true
						})
						
						SKUDIALOG.ok = function(){
							var nodes = proTree.getChecked();
							if(jQuery.isEmptyObject(nodes)){
								BSS.alert('请选择一个产品');
								return;
							}
							var len = nodes.length;
							if(len <= 0){
								BSS.alert('保存成功！');
								return;
							}
							if(len > 1){
								BSS.alert('只能选择一个产品，请重新选择');
								return;
							}
							var prodid;
							for(var i = 0; i < len; i++){
							    prodid = nodes[i].id;
							}
						    var id = ${id};
 							var sku = {id:""+id+"",productid:""+prodid+""};
							BSS.dispatch({code:14017,data:[sku]},function(resp){
	 						BSS.alert('保存成功！');
					});
				 }
				}else{
					BSS.warning(resp.message);
				}
				
			});
});
</script>