<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<body>
	<script src="js/jquery-1.3.2.js"></script>
	<script src="js/jquery-1.4.2.min.js"></script>
	<form action="/myApp//export" id="exportForm">
	</form>
	 ${error_008} <br>
	 ${mapf['ddd']} <br>
		<input type="button" id="yws" name="yws" value="yws">
		<input type="button" name="exportWord" id="exportWord" value="exportWord">
		<script type="text/javascript">
			$("#yws").click(function(){
				$("#exportForm").submit();
			});
			$("#exportWord").click(function(){
				$.ajax({
					url:'/myApp//export',
					type:'post'
					
				});
				
			});
		</script>
	</body>
</html>