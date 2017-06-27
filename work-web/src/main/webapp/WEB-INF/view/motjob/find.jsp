<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form   >
	<table cellpadding="8">
		<tr>
			<td>事件名称：</td>
			<td>
				<input id="id_evtid"  class="easyui-textbox" type="text" name="evtid" style="width:200px;" ></input>
			</td>
		</tr> 
		 	<tr>
			<td>优先级：</td>
			<td>
				<select id="cbx_priority"  class="easyui-combobox"  name="priority" style="width:200px;" > 
			<option value="-1" selected>全部</option>
            <option value="1">低</option>
            <option value="2">中</option>
            <option value="3">高</option>
            </select>
			</td>
		</tr> 
			<tr>
			<td>任务性质：</td>
			<td>
 			<select id="cbx_isauto"  class="easyui-combobox"  name="isauto" style="width:200px;" > 
			<option value="1" selected>自动</option>
            <option value="2">非自动</option>  
            </select>
			</td>
		</tr> 
			<tr>
			<td>任务状态：</td>
			<td>		
		<select id="cbx_jobstats"  class="easyui-combobox"  name="jobstats" style="width:200px;" > 
			<option value="0" > 过期未执行</option>
            <option value="1" selected> 待执行</option>
            <option value="2">执行完成</option>
            </select>
		
		</td>
		</tr> 
			<tr>
			<td>开始时间：</td>
			<td>
				<input id="id_begintime"  class="easyui-textbox" type="text" name="begintime" style="width:200px;" ></input>
			</td>
		</tr> 
			<tr>
			<td>结束时间：</td>
			<td>
				<input id="id_endtime"  class="easyui-textbox" type="text" name="endtime" style="width:200px;" ></input>
			</td>
		</tr> 
		 
		
	</table>
</form>  
<script>
 
  
BSS.dispatch({code:23001},function(resp){
	if(resp.code == 0){ 
		JOBQUERYDIALOG.ok=function(){
			  var  evtid = $('#id_evtid').val();
  			  var cbx_priority=$('#cbx_priority').combobox('getValue');
  			  var cbx_isauto=$('#cbx_priority').combobox('getValue');
  			  var cbx_jobstats=$('#cbx_priority').combobox('getValue'); 
			  var  begintime = $('#id_begintime').val();
			  var  endtime = $('#id_endtime').val();
			  
			  JOBGRID.load({code:23001,data:[{evtid:evtid,priority:cbx_priority,isauto:cbx_isauto,
					  jobstats:cbx_jobstats,begintime:begintime,endtime:endtime}]});	 
	}
	}else{
		BSS.warning(resp.message);
	    
	}
},function(resp){});

 
</script>