<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form   >
	<table cellpadding="8">
		<tr>
			<td>方案名称：</td>
			<td>
				<input id="id_schmname"  class="easyui-textbox" type="text" name="schmname" style="width:200px;" ></input>
			</td>
		</tr> 
		 
	</table>
</form>  
<script>
BSS.dispatch({code:22004},function(resp){
	if(resp.code == 0){ 
		SCHEMEQUERYDIALOG.ok=function(){
			  var scheme = $('#id_schmname').val();
				  SCMEGRID.load({code:22004,data:[{schmname:scheme}]});	 
	}
	}else{
		BSS.warning(resp.message);
	    
	}
},function(resp){});

// SCHEMEQUERYDIALOG.ok=function(){
// 			  var scheme = $('#id_schmname').val();
// 			SCMEGRID.load({code:22004,data:[{schmname:scheme}]});

// }
</script>