<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<body>
	<script src="../js/jquery-1.3.2.js"></script>
	<script src="../js/jquery-1.4.2.min.js"></script>
		<input type="button" name="InstrumentPanel" id="InstrumentPanel" value="InstrumentPanel">
		<script type="text/javascript">
			$("#InstrumentPanel").click(function(){
				$.ajax({
					url:'/myApp//InstrumentPanel',
					type:'post',
					success:function(data){
						var returndata = data;
						Window.write(data);
						alert(data);
					}
				});
				
			});
		</script>
	</body>
</html>