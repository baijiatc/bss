<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<table width="100%;" height="450px;" style="padding:5px;">
	<tr height="220px;">
		<td width="45%">
			<div id="div_profile_top_left">
				<ul style="line-height:20px;margin:0;padding:10px 0 0 10px">
					<li><a id="lnk_proshow" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a></li>
				</ul>
			</div>
		</td>
		<td width="45%">
			<div id="div_profile_top_right">
				
			</div>
		</td>
	</tr>
	<tr height="220px;">
		<td width="45%">
			<div id="div_profile_bottom_left">
				
			</div>
		</td>
		<td width="45%">
			<div id="div_profile_bottom_right" >
				<ul id="ul_profile_log" style=" list-style-type:none;line-height:20px;margin:0;padding:10px 0 0 10px">
					<li><label>2017-04-14 13:32:55</label><span>:</span>新增角色</li>
					<li><label>2017-04-14 13:31:55</label><span>:</span>访问角色管理</li>
					<li><label>2017-04-14 13:30:55</label><span>:</span>登录</li>
				</ul>
			</div>
		</td>
	</tr>
</table>
<div id="rpasswd" style="padding:0 0 0 50px;"></div>
<script>
$(function(){
	var tlpnl = new BSS.Panel('#div_profile_top_left');
	tlpnl.init({title:'功能面板',border:true});
	
	var trpnl = new BSS.Panel('#div_profile_top_right');
	trpnl.init({title:'绩效考核',border:true});
	
	var blpnl = new BSS.Panel('#div_profile_bottom_left');
	blpnl.init({title:'消息提醒',border:true});
	
	var brpnl = new BSS.Panel('#div_profile_bottom_right');
	brpnl.init({title:'操作日志',border:true});
	
	var stffid = ${_current_user.uid};
	BSS.dispatch({code:21004,data:[{operator:stffid}],psize:8},function(resp){
		if(resp.code == 0){
			var data = resp.data;
			var len = data.length;
			var sb = new BSS.StringBuilder();
			for(var i = 0; i < len; i++){
				var log = data[i];
				sb.append('<li><label>')
				  .append(BSS.formatTime(log.createtime))
				  .append('</label><span>:</span>')
				  .append(log.content)
				  .append('</li>');
			}
			$('#ul_profile_log').html(sb.toString());
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
});
$('#lnk_proshow').click(function(){
	var stfid = ${_current_user.uid};
	RPASSDIALOG = new BSS.Dialog('#rpasswd');
	RPASSDIALOG.init({href:'staff/'+stfid+'/repasswd.html',width:400});
	});
</script>