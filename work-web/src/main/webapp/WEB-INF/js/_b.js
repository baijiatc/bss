/**
 * 定义全局对象
 */
BSS = {
	/**
	 * 将表单序列化为JSON对象
	 */
	form2json:function(selector) {  
	   var o = {};  
	   var a = $(selector).serializeArray();  
	   $.each(a, function() {  
	       if (o[this.name]) {  
	           if (!o[this.name].push) {  
	               o[this.name] = [o[this.name]];  
	           }  
	           o[this.name].push(this.value || '');  
	       } else {  
	           o[this.name] = this.value || '';  
	       }  
	   });  
	   return o;  
	},
	json2form:function(selector,json){
		var obj = $(selector).form('load',json);
	},
	/**
	 * 动态加载页面内容<br/>
	 * 依赖于Jquery
	 * @param selector 装在页面的容器
	 * @param url 页面URL或返回HTML文本的URL
	 */
	include:function(selector,url){
		$(selector).load(url);
	},
	/**
	 * 重定向到URL指向的资源
	 * @param url
	 */
	redirect:function(url){
		window.location.href = url;
	},
	/**
	 * 
	 * @param obj json对象
	 * @param success，成功后回调
	 * @param error，成功后回调
	 */
	dispatch:function(obj,success,error){
		$.ajax({
			url:'route/dispatch',
			type:'POST',
			contentType:'application/json;charset=utf-8',
			data:JSON.stringify(obj),
			success:function(data){
				success(data);
			},
			error:function(data){
				error(data);
			}
		});
	},
	showView:function(url,callback){
		$.ajax({
			url:url,
			type:'GET',
			success:function(html){
				callback(html);
			},
			error:function(err){
				callback(JSON.stringify(err));
			}
		});
	},
	/**
	 * 定时执行
	 * @param {Number}interval 间隔时间
	 * @param {Function}callback 回调函数
	 * @param {Function}callback 执行次数 0/负数表示无限执行
	 */
	interval:function(interval,callback,times){
		times = times || -1;
		var inter = null;
		var newFunc = function(){
			callback();
			if(times > 0){
				times--;
				if(times <= 0){
					window.clearInterval(inter);
				}
			}
		}
		inter = window.setInterval(newFunc,interval);
	},
	/**
	 * 延迟执行一次
	 * @param {Number}delay 延迟时间
	 * @param {Function}callback 回调函数
	 */
	delay:function(delay,callback){
		window.setTimeout(callback,delay);
	},
	/**
	 * 移除同一类元素的类样式
	 * @param {String} selector
	 * @param {String} clazz
	 */
	removeClassEveryone:function(selector,clazz){
		$(selector).each(function(){
			if($(this).hasClass(clazz)){
				$(this).removeClass(clazz);
			}
		});
	},
	/**
	 * 提醒框
	 * @param msg
	 * @param title,
	 */
	alert:function(msg,title){
		this.__modal(null,msg,title);
	},
	info:function(msg,title){
		this.__modal('info',msg,title);
	},
	error:function(msg,title){
		this.__modal('error',msg,title);
	},
	warning:function(msg,title){
		this.__modal('warning',msg,title);
	},
	question:function(msg,title){
		this.__modal('question',msg,title);
	},
	__modal:function(type,msg,title){
		title = title || '提示信息';
		$.messager.alert({
			title:title,
			msg:msg,
			icon:type,
			showType:'show'
		});
	}
};
BSS.StringBuilder = function(){
	var $this = this;
	$this.strArr = [];
	$this.append=function(str){
		str = str || '';
		$this.strArr.push(str);
		return $this;
	};
	$this.toString=function(){
		var str = '';
		var len = $this.strArr.length;
		if(len==0){
			return str;
		}
		for(var i = 0; i < len; i++){
			var subStr = $this.strArr[i];
			str += subStr;
		}
		return str;
	};
}
BSS.PropGrid = function(selector){
	var $this = this;
	$this.selector=selector;
	$this.init=function(options){
		options = options || {};
		var defaults = {showGroup:false,border:true,showHeader:true};
		$.extend(defaults,options);
		$($this.selector).propertygrid(defaults);
	};
	$this.append=function(row){
		$($this.selector).propertygrid('appendRow',row);
	};
	$this.getChanges=function(){
		return $($this.selector).propertygrid('getChanges');
	}
}
BSS.Accordion = function(selector){
	var $this = this;
	$this.selector=selector;
	$this.init=function(options){
		options = options || {};
		var defaults = {border:false};
		$.extend(defaults,options);
		$($this.selector).accordion(defaults);
	}
}
/**
 * 封装Jquery EasyUI DataGrid
 */
BSS.DataGrid = function(selector){
	var $this = this;
	$this.selector=selector;
	$this.create=function(){};
	$this.edit=function(){};
	/**
	 * 初始化DataGrid
	 * @param {String}selector
	 * @param {Object}options
	 */
	$this.init=function(options){
		options = options || {};
		var defaults = {
			width:'auto',
			height:400,
			pagination:true,
			pageSize:10,
			pageNumber:1,
			rownumbers:true,
			singleSelect:true,
			onClickRow:function(ridx,rdata){
				$this.clickRow(ridx,rdata);
			},
			toolbar:$this.toolbar
		};
		$.extend(defaults,options);
		$($this.selector).datagrid(defaults);
	};
	$this.toolbar=$this.toolbar 
	|| [
	     {iconCls:'icon-add',text:'新建',handler:function(){$this.create();}},
	     {iconCls:'icon-edit',text:'编辑',handler:function(){$this.edit();}}
	];
	$this.clickRow=function(ridx,rdata){
		
	};
	/**
	 * 为DataGrid填充数据
	 * @param selector
	 * @param param
	 */
	$this.load=function(param){
		BSS.dispatch(param,function(data){
			$($this.selector).datagrid('loadData',{"total":data.count,"rows":data.data});
			$this.__whenSelectPage(param);
		 },function(data){
			console.log('err:'+JSON.stringify(data)); 
		 });
	};
	/**
	 * 当选择分页时执行的操作
	 * @param selector
	 * @param param
	 */
	$this.__whenSelectPage=function(param){
		$($this.selector).datagrid('getPager').pagination({
			onSelectPage:function(pPageIndex, pPageSize){
				 param.pindex = pPageIndex;
				 param.psize = pPageSize;
				 BSS.dispatch(param,function(data){
					 $($this.selector).datagrid('loadData',{"total":data.count,"rows":data.data});
				 },function(data){
					console.log(JSON.stringify(data)); 
				 });
			}
		});
	};
	$this.getSelectedRow=function(){
		var row = $($this.selector).datagrid('getSelected');
		return row;
	};
	/**
	 * 直接构建DataGrid，含数据填充
	 */
	$this.build=function(options,param){
		$this.init(options);
		$this.load(param);
	};
};
/**
 * 封装EasyUI 对话框
 */
BSS.Dialog = function(selector){
	var $this = this;
	$this.selector = selector;
	$this.init=function(options){
		options = options || {};
		var defaults = {
			title:'提示',
			width: 500,
			height: 300,
			modal: true,
			cache: false,
			buttons:[{
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
					$this.ok();
					$($this.selector).dialog('close');
				}
			},{
				text:'取消',
				handler:function(){
					$this.cancel();
					$($this.selector).dialog('close');
				}
			}]
		};
		$.extend(defaults,options);
		$($this.selector).dialog(defaults);
	};
	$this.ok=function(){};
	$this.cancel=function(){};
};
/**
 * 封装EasyUI Tab
 */
BSS.Tab = function(selector){
	var $this = this;
	$this.selector = selector;
	$this.init=function(options){
		options = options || {};
		var defaults = {border:false};
		$.extend(defaults,options);
		$($this.selector).tabs(defaults);
	};
	$this.add=function(title,content){
		if($($this.selector).tabs('exists', title)){
			$($this.selector).tabs('select', title);
		}else{
			$($this.selector).tabs('add',{
				title:title,
				content:content,
				border:false,
				closable: true
			});
		}
	};
	$this.colse=function(){
		var tab = $($this.selector).tabs('getSelected');
		if(tab){
			var index = $($this.selector).tabs('getTabIndex', tab);
			$($this.selector).tabs('close', index);
		}
	};
	$this.selectedTab=function(){
		return $($this.selector).tabs('getSelected');
	};
	$this.updateSelectedTab=function(html){
		if(!html){BSS.warning('请设定要更新的内容!');}
		var tab = $this.selectedTab();
		$($this.selector).tabs('update',{
			tab:tab,
			options:{content:html}
		});
	};
}
/**
 * 封装EasyUI Tree。
 */
BSS.Tree = function(selector){
	var $this = this;
	$this.selector = selector;
	$this.init=function(options){
		options = options || {};
		var defaults = {
			animate:true,
			border:false,
			checkbox:false,
			cascadeCheck:true,
			onlyLeafCheck:false,
			onClick:function(node){
				$this.nodeClick(node);
			}
		};
		$.extend(defaults,options);
		$($this.selector).tree(defaults);
	};
	$this.nodeClick=function(node){
		
	};
}
BSS.Panel = function(selector){
	var $this = this;
	$this.selector = selector;
	$this.init=function(options,html){
		options = options || {};
		var defaults = {
			title:'标题',
			fit:true,
			border:false,
			content:html || null
		};
		$.extend(defaults,options);
		$($this.selector).panel(defaults);
	};
}
BSS.Layout = function(selector){
	var $this = this;
	$this.selector = selector;
	$this.layout=function(options){
		options = options || {};
		var defaults = {fit:true,border:false};
		$.extend(defaults,options);
		$($this.selector).layout(defaults);
	};
}
/**
 * 帮助类，包含各种常用操作
 */
BSS.Helper = {
	parent:BSS,
	/**
	 * 判断对象是否为NULL
	 * @param {Object} obj
	 */
	isNull:function(obj){
		if(obj == null){
			return true;
		}
		return false;
	},
	/**
	 * 判断对象是否为undefined
	 * @param {Object} obj
	 */
	isUndefined:function(obj){
		if(obj == undefined){
			return true;
		}
		return false;
	},
	/**
	 * 判断字符串是否为空
	 * @param {String} str
	 */
	isEmpty:function(str){
		if(this.isNull(str)){
			return true;
		}
		if(this.isUndefined(str)){
			return true;
		}
		if(str.trim().length <= 0){
			return true;
		}
		return false;
	}
};

/**
 * 定义时间对象
 */
BSS.DateTime = {
	/**
	 * 将字符串解析为Date对象
	 * @param date 日期字符串
	 * @returns
	 */
	parseDate:function(date){
		return new Date(date);
	},
	/**
	 * 获取当前时间
	 */
	now:function(){
		return new Date();
	},
	/**
	 * 获取当前日期字符串形式<br/>
	 * yyyy-MM-dd hh:mm:ss.S ==> 2016-01-05 08:09:04.423<br/>
	 * yyyy-M-d h:m:s.S ==> 2016-1-5 8:9:4.18
	 * @param pattern 默认yyyy-MM-dd hh:mm:ss
	 * @returns
	 */
	nowStr:function(pattern){
		pattern = pattern || 'yyyy-MM-dd hh:mm:ss';
		var now = this.now();
		return this.format(now,pattern);
	},
	/**
	 * 获取当前时间的毫秒数
	 */
	nowMillis:function(){
		return this.now().getTime();
	},
	/**
	 * 当前日期追加天数
	 * @param date 可以是Date对象，也可以是日期类型字符串
	 * @param dayNum 增减的天数
	 * @returns {Date}
	 */
	addDay:function(date, dayNum){
		date = date || this.now();
		var oldDate;
		if(date.constructor == Date){
			oldDate = date;
		}else{
			oldDate = this.parseDate(date);
		}
		oldDate = oldDate.valueOf();
		oldDate += dayNum * 24 * 60 * 60 * 1000;
		var newDate = this.parseDate(oldDate);
		return newDate;
	},
	/**
	 * 计算两个日期相差天数
	 * @param date1
	 * @param date2
	 * @returns
	 */
	diff:function(date1,date2){
		var iDays = parseInt(Math.abs(date1 - date2) / 1000 / 60 / 60 / 24);
		if(date1 < date2){
			return -iDays
		}
		return iDays
	},
	/**
	 * 获取日期是星期几
	 * @param date 日期类型字符串/日期对象
	 * @returns {String}
	 */
	week:function(date){
		date = date || this.now();
		var oldDate;
		if(date.constructor == Date){
			oldDate = date;
		}else{
			oldDate = this.parseDate(date);
		}
		var wd = oldDate.getDay();
		var ws;
		switch(wd){
		case 0:
			ws = '星期日';
			break;
		case 1:
			ws = '星期一';
			break;
		case 2:
			ws = '星期二';
			break;
		case 3:
			ws = '星期三';
			break;
		case 4:
			ws = '星期四';
			break;
		case 5:
			ws = '星期五';
			break;
		case 6:
			ws = '星期六';
			break;
		}
		return ws;
	},
	/**
	 * 对日期进行格式化
	 * yyyy-MM-dd hh:mm:ss.S ==> 2016-01-05 08:09:04.423
	 * yyyy-M-d h:m:s.S ==> 2016-1-5 8:9:4.18
	 * @param date
	 * @param pattern
	 * @returns
	 */
	format:function(date,pattern) {
		pattern = pattern || 'yyyy-MM-dd hh:mm:ss';
		var o = {
			"M+" : date.getMonth() + 1, //月份 
			"d+" : date.getDate(), //日 
			"h+" : date.getHours(), //小时 
			"m+" : date.getMinutes(), //分 
			"s+" : date.getSeconds(), //秒 
			"q+" : Math.floor((date.getMonth() + 3) / 3), //季度 
			"S" : date.getMilliseconds()//毫秒 
		};
		if (/(y+)/.test(pattern))
			pattern = pattern.replace(RegExp.$1, (date.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(pattern))
				pattern = pattern.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return pattern;
	}
};
