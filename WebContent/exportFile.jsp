<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.yyy.dailycode.export.ExportUtil"%>
<%
	ExportUtil.outputXmlFile("导出文件.xml", "C:\\temp\\export\\20140603151923146D6D3774.xml", true, response);
%>