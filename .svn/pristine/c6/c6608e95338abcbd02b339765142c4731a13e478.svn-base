<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<!--框架必需start-->
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/character.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/specialtask.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.js"></script>
		<link href="<%=request.getContextPath()%>/skins/sky/import_skin.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/css/import_basic.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="../js/form/datePicker/WdatePicker.js"></script>
		<!--框架必需end-->

		<!-- 图形控件start -->
		<script type="text/javascript"
			src="../charts/FusionCharts_new/FusionCharts.js"></script>
		<script type="text/javascript"
			src="../charts/FusionCharts_new/jquery.min.js"></script>
		<script type="text/javascript"
			src="../charts/FusionCharts_new/FusionCharts.jqueryplugin.js"></script>
		<!-- 图形控件end -->
	</head>
	<body>
		<script type="text/javascript">
			function showFusionCharts(){
				$("#chartContainer").insertFusionCharts({               
					swfUrl: "<%=request.getContextPath()%>/charts/FusionCharts_new/Column3D.swf?ChartNoDataText=无数据展示",         
					width: document.body.clientWidth,         
					height: "450",         
					id: "myChartId1",              
					dataFormat: "json",         
					dataSource: {                 
						"chart": {  
						"baseFontSize" : "12",   
						"baseFontColor" : "#000000", 
						"formatNumberScale" : "0",                     
						"caption" : "联网应用",                          
						"xAxisName" : "业务单位",                          
						"yAxisName" : "联网警务室数量",                          
						"numberPrefix" : "",
						"numberSuffix" : "个"             
						},                                        
						"data": [{"value":"11","label":"数据11"},{"value":"2","label":"数据2"},{"value":"3","label":"数据3"},{"value":"4","label":"数据4"},{"value":"5","label":"数据5"},{"value":"6","label":"数据6"},{"value":"7","label":"数据7"},{"value":"8","label":"数据8"},{"value":"9","label":"数据9"}]
					}
				});  
			}
		</script>
		<input type="button" value="加载" onclick="showFusionCharts();"/>
		<div id="chartContainer" style="text-align: center;">
			FusionCharts will load here!
		</div>
	</body>
</html>