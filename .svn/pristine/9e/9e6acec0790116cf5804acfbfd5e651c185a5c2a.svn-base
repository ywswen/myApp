<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URLConnection"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" name="yws" value="yws">
<%
	// 下载网络文件
	int bytesum = 0;
	int byteread = 0;

	URL url = new URL("http://www.baidu.com/img/baidu_sylogo1.gif");

	try {
		URLConnection conn = url.openConnection();
		InputStream inStream = conn.getInputStream();
		FileOutputStream fs = new FileOutputStream("c:/abc.gif");

		byte[] buffer = new byte[1204];
		int length;
		while ((byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread;
			System.out.println(bytesum);
			fs.write(buffer, 0, byteread);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
%>

</body>
</html>