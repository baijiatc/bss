/**
 * 定义全局对象
 */
BSS = {
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
	 * 定时执行
	 * @param interval 间隔时间
	 * @param callback 回调函数
	 * @param callback 执行次数 0/负数表示无限执行
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
	 * @param delay 延迟时间
	 * @param callback 回调函数
	 */
	delay:function(delay,callback){
		window.setTimeout(callback,delay);
	},
	/**
	 * 移除同一类元素的类样式
	 * @param {Object} selector
	 * @param {Object} clazz
	 */
	removeClassEveryone:function(selector,clazz){
		$(selector).each(function(){
			if($(this).hasClass(clazz)){
				$(this).removeClass(clazz);
			}
		});
	},
	/**
	 * 弹出提示框
	 * @param {String} msg
	 * @param {String} title
	 */
	alert:function(msg,title){
		this.Dialog.__modal({
			type:'info',
			message:msg,
			title:title
		});
	},
	/**
	 * 弹出错误框
	 * @param {String} msg
	 * @param {String} title
	 */
	error:function(msg,title){
		this.Dialog.__modal({
			type:'danger',
			message:msg,
			title:title
		});
	},
	/**
	 * 弹出成功框
	 * @param {String} msg
	 * @param {String} title
	 */
	success:function(msg,title){
		this.Dialog.__modal({
			type:'success',
			message:msg,
			title:title
		});
	},
	/**
	 * 弹出警告框
	 * @param {String} msg
	 * @param {String} title
	 */
	warning:function(msg,title){
		this.Dialog.__modal({
			type:'warning',
			message:msg,
			title:title
		});
	}
};

/**
 * 对话框对象，显示模态窗口
 */
BSS.Dialog = {
	parent:BSS,
	/**
	 * 设置模态窗口标题
	 * @param {String} title
	 */
	__setModelTitle:function(title){
		$('.modal .modal-header .modal-title').html(title);
	},
	/**
	 * 设置模态窗口内容
	 * @param {String} html
	 */
	__setModelContent:function(url,html){
		if(url){
			this.parent.include('.modal .modal-body',url);
			return;
		}
		$('.modal .modal-body').html(html);
	},
	/**
	 * 显示取消按钮
	 * @param {Boolean} showCancel
	 */
	__showBtnCancel:function(showCancel){
		if(showCancel){
			$('.modal .modal-footer #v_modal_btn_cancel').show();
		}else{
			$('.modal .modal-footer #v_modal_btn_cancel').hide();
		}
	},
	/**
	 * 更改确定按钮样式
	 * @param {Object} type
	 */
	__setEnsureBtnClass:function(type){
		$('.modal .modal-footer #v_modal_btn_sure').addClass('btn btn-'+type);
	},
	/**
	 * 设置取消按钮事件
	 * @param {Function} callback
	 */
	__setCancelFunction:function(callback){
		$('.modal .modal-footer #v_modal_btn_cancel').unbind('click');
		$('.modal .modal-footer #v_modal_btn_cancel').click(function(){
			callback();
		});
	},
	/**
	 * 设置确定按钮事件
	 * @param {Function} callback
	 */
	__setEnsureFunction:function(callback){
		$('.modal .modal-footer #v_modal_btn_sure').unbind('click');
		$('.modal .modal-footer #v_modal_btn_sure').click(function(){
			callback();
		});
	},
	/**
	 * 清除确定按钮样式
	 */
	__clearEnsureBtnClass:function(){
		$('.modal .modal-footer #v_modal_btn_sure').attr('class','');
	},
	/**
	 * 生成模态窗口
	 * @param {Object} option
	 */
	__modal:function(option){
		var _option = option || {};
		_option.type = option.type || 'info';
		_option.message = option.message || '提示信息';
		var _default = {
			showCancel:false,
			title:'提示信息',
			cancel:function(){},
			ensure:function(){}
		}
		_default.html = '<div class="alert alert-'+_option.type+'" role="alert">'+_option.message+'</div>',
		$.extend(_default,_option);
		this.__clearEnsureBtnClass();
		this.__setModelTitle(_default.title);
		this.__setModelContent(_default.url,_default.html);
		this.__showBtnCancel(_default.showCancel);
		this.__setCancelFunction(_default.cancel);
		this.__setEnsureBtnClass(_default.type);
		this.__setEnsureFunction(_default.ensure);
		$('.modal').modal('show');
	},
	/**
	 * 显示模态窗口<br/>
	 * 当制定url属性时，message属性将失效
	 * @param {Object} option
	 */
	dialog:function(option){
		this.__modal(option);
	}
};

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

/**
 * 对Tab标签页进行封装
 */
BSS.Tab = {
	parent:BSS,
	ids:[],
	/**
	 * 添加一个tab
	 * @param {String} selector tab组件ul标签的selector
	 * @param {String} name tab上显示的文字
	 * @param {String} url tab内容页要显示的内容
	 */
	add:function(selector,name,url){
		this.tabContentId = 'v_tabs_content_';
		this.id = this.parent.DateTime.nowMillis();
		this.selector = selector;
		this.inactiveAll();
		var tab = '<li role="presentation" class="active"><a href="#'+this.tabContentId+this.id+'" data-toggle="tab">'+name+'<i style="right:4px;" onclick="BSS.Tab.close(this);">&times;</i></a></li>';
		$(selector).append(tab);
		var tabContent = '<div class="tab-pane active" id="'+this.tabContentId+this.id+'"></div>';
		$(this.selector).siblings('.tab-content').append(tabContent);
		$('#'+this.tabContentId+this.id).load(url);
	},
	/**
	 * 关闭tab
	 * @param {Object} e 触发关闭事件的对象
	 */
	close:function(e,selector){
		this.selector = selector || this.selector;
		this.inactiveAll();
		$(e).parent().parent().remove();
		var removeId = $(e).parent().attr('href').replace('#'+this.tabContentId,'');
		$('#'+this.tabContentId+removeId).remove();
		$(this.selector+' li').last().addClass('active');
		$('.tab-content .tab-pane').last().addClass('active');
	},
	/**
	 * 移除标签活跃状态
	 * @param {String} selector tab组件ul标签的selector
	 */
	inactiveAll:function(selector){
		this.selector = selector || this.selector;
		this.parent.removeClassEveryone(this.selector+' li','active');
		this.parent.removeClassEveryone('.tab-content .tab-pane','active');
	}
};
