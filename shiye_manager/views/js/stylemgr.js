var stylemgr = {
	//页面窗口尺寸初始化
	initBodySize: function() {
		console.log("windows height="+parent.innerHeight);
		console.log("body" + $(document).height());
		var docuomentHeight = $(document).height();
		var bodyHeight = parent.innerHeight*0.6546;
		$("body").attr("style", "height: " + bodyHeight + "px;");
		/*$("#style-list").height(bodyHeight * 0.812);
		$("#style-detail").height(bodyHeight * 0.812);*/
		var styleHeight=bodyHeight * 0.75;
		$("#style-list").height(styleHeight);
		$("#style-detail").height(styleHeight);
	}
}