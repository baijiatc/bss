<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<ul id="spec_tree">
	<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
</ul>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui-tree-extend.js" charset="utf-8"></script>
<script>
$(function(){
	var specTree = new BSS.Tree('#spec_tree');
			BSS.dispatch({code:30002,data:[{skuid:'${id}'}]},function(resp){
				if(resp.code == 0){
					var nodes = [];
					var data = resp.data;
					var len = data.length;
					for(var i = 0; i < len; i++){
						var spec = data[i];
						var node = {text:spec.specname,id:spec.id,checked:spec.checked};
						nodes.push(node);
					}
					specTree.init({
						data:nodes,
						checkbox:true
						})
						
						SKUDIALOG.ok = function(){
							var nodes = specTree.getChecked();
							var len = nodes.length;
							if(len <= 0){
								BSS.alert('保存成功！');
								return;
							}
							var specids = [];
							for(var i = 0; i < len; i++){
							    var specid = nodes[i].id;
							    specids.push(specid);
							}
						    var skuid = ${id};
 						    var skuspec = {skuid:""+skuid+"",specid:""+specids+""};
							BSS.dispatch({code:30003,data:[skuspec]},function(resp){
	 						BSS.alert('保存成功！');
					});
				 }
				}else{
					BSS.warning(resp.message);
				}
				
			});
});
</script>