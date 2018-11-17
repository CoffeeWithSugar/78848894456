/**
 * 框架类js
 */

var mainframe = {
	//已打开的tab
	openedTabs: [],

	//菜单配置数据
	menus: [{
		menu_id: '1000',
		menu_name: '订单管理',
		menu_url: '#',
		menu_icon: '',
		sub_menu: [{
				menu_id: '1001',
				menu_name: '新增订单',
				menu_url: 'http://127.0.0.1:8020/shiye_manager/views/stylemanager.html'
			},
			{
				menu_id: '1002',
				menu_name: '查询订单',
				menu_url: '404.html'
			}
		]
	}, {
		menu_id: '1000',
		menu_name: '款号管理',
		menu_url: '#',
		menu_icon: '',
		sub_menu: [{
				menu_id: '1001',
				menu_name: '新增款号',
				menu_url: '404.html'
			},
			{
				menu_id: '1002',
				menu_name: '查询款号',
				menu_url: '404.html'
			}
		]
	}, {
		menu_id: '1000',
		menu_name: '人事管理',
		menu_url: '#',
		menu_icon: '',
		sub_menu: [{
				menu_id: '1001',
				menu_name: '员工管理',
				menu_url: '500.html'
			},
			{
				menu_id: '1002',
				menu_name: '部门管理',
				menu_url: '500.html'
			}
		]
	}],

	//构建菜单html
	buildMenu: function() {
		var mainMenuHtml = '';
		var subMenuHtml = '';
		if(this.menus && this.menus.length > 0) {
			for(var index = 0; index < this.menus.length; index++) {
				var mainItem = this.menus[index];
				mainMenuHtml += '<li onclick="mainframe.menuClick(this);" sub-menu-id="sub-nav-ul-' + index + '">' +
					'<a href="' + mainItem.menu_url + '">' +
					'<div class="fs1" aria-hidden="true" data-icon="&#xe0a0;"></div>' +
					mainItem.menu_name +
					'</li>'
				if(mainItem.sub_menu && mainItem.sub_menu.length > 0) {
					var subMenus = mainItem.sub_menu;
					subMenuHtml += '<ul id="sub-nav-ul-' + index + '" style="display:none;">';
					for(var subIndex = 0; subIndex < subMenus.length; subIndex++) {
						var item = subMenus[subIndex];
						subMenuHtml += '<li tabId="sub-nav-li-' + index + '-' + subIndex + '"onclick="mainframe.submenuClick(this);" url="' + item.menu_url + '"><a href="#" >' + item.menu_name + '</a></li>';
					}
					subMenuHtml += '</ul>';
				}
			}
			$("#main-nav-ul").html(mainMenuHtml);
			$("#sub-nav-div").html(subMenuHtml);

			//添加选择样式
			$("#main-nav-ul li:first-child").find("a").addClass("selected");
			$("#sub-nav-div ul:first-child").show();
			$("#sub-nav-div ul:first-child li:first-child").find("a").addClass("heading");
		} else {
			return;
		}
	},

	//主菜单点击事件
	menuClick: function(e) {
		var subMenuId = $(e).attr("sub-menu-id");
		//选中当前主菜单
		$("#main-nav-ul .selected").removeClass("selected");
		$(e).find("a").addClass("selected");
		//切换子菜单
		$("#sub-nav-div ul:visible").hide().find("a").removeClass("heading");
		$("#" + subMenuId).show().children("li:first").find("a").addClass("heading");
	},

	//子菜单点击事件
	submenuClick: function(e) {
		var url = $(e).attr("url");
		var menuName = $(e).find("a").html();
		var tabId = $(e).attr("tabId");
		$(e).parent().find(".heading").removeClass("heading");
		$(e).find("a").addClass("heading");
		this.createTab(url, menuName, tabId);
	},

	//初始化主窗口高度
	initBodySize: function() {
		console.log($(document).height());
		var docuomentHeight = $(document).height();
		$(".dashboard-wrapper").attr("style", "height: " + docuomentHeight * 0.74 + "px;");
	},
	
	//iframe高度自适应
	changeFrameHeight: function(e) {
		var height=document.documentElement.clientHeight;
		console.log("if"+height);
		$(e).height(height*0.65469);
	},
	
	//alertify初始化
	reset: function() {
		alertify.set({
			labels: {
				ok: "OK",
				cancel: "Cancel"
			},
			delay: 5000,
			buttonReverse: false,
			buttonFocus: "ok"
		});
	},

	//创建tab页
	createTab: function(url, name, tabId) {
		console.log(url + name + tabId);
		var openedTabs = this.openedTabs;
		if(openedTabs && openedTabs.length > 0) {
			if(openedTabs.length >= 8) {
				this.reset();
				alertify.alert("最多只能同时打开8个菜单！");
				return;
			}
			for(var index = 0; index < openedTabs.length; index++) {
				//如果已经创建不再重复创建，直接active
				if(tabId == openedTabs[index]) {
					$("#mytab .active").removeClass("active");
					$("#myTabContent .active").removeClass("active");
					$("#mytab #" + tabId).addClass("active");
					$("#myTabContent #" + tabId).addClass("active");
					return;
				}
			}
		}
		//创建tab页
		this.openedTabs.push(tabId);
		var tab = '<li class="active" id="' + tabId + '" onclick="mainframe.tabClick(this);">' +
			'<a data-toggle="tab" href="#' + tabId + '">' +
			name +
			'<span class="fs1" tabId="' + tabId + '"aria-hidden="true" data-icon="&#xe0fd;" onclick="event.stopPropagation();mainframe.closeTab(this)"></span>' +
			'</a>' +
			'</li>';
		var tabContent = '<div id="' + tabId + '" class="tab-pane active">' +
			'<iframe src="' + url + '" width="100%" onload="mainframe.changeFrameHeight(this)" scrolling="yes" frameborder="no" border="0" marginwidth="0" marginheight="0" allowtransparency="yes"></iframe>' +
			'</div>';
		$("#mytab .active").removeClass("active");
		$("#myTabContent .active").removeClass("active");
		$("#mytab").append(tab);
		$("#myTabContent").append(tabContent);
	},

	//tab点击切换页面
	tabClick: function(e) {
		var tabId = $(e).attr("id");
		$("#myTabContent .active").removeClass("active");
		$("#myTabContent #" + tabId).addClass("active");
	},

	//关闭tab页
	closeTab: function(e) {
		var tabId = $(e).attr("tabId");
		console.log(tabId);
		console.log(this.openedTabs);
		var index = this.openedTabs.indexOf(tabId);
		if(index > -1) {
			this.openedTabs.splice(index, 1);
		}
		console.log(this.openedTabs);
		$("#mytab #" + tabId).remove();
		$("#myTabContent #" + tabId).remove();
		if(this.openedTabs.length == 0) {
			$("#mytab #home").addClass("active");
			$("#myTabContent #home").addClass("active");
		} else {
			var activeTab = $("#mytab .active").html();
			if(activeTab) {
				return;
			}
			var id = this.openedTabs[this.openedTabs.length - 1];
			$("#mytab #" + id).addClass("active");
			$("#myTabContent #" + id).addClass("active");
		}
	}

};