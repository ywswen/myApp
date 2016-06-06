<%@ page contentType="text/html;charset=GBK"%>

<%@page import = " java.io.FileNotFoundException " %> 
<%@page import = " java.io.FileOutputStream " %> 
<%@page import = " org.apache.commons.logging.Log " %> 
<%@page import = " java.io.IOException " %> 

<%@page import = " org.apache.commons.logging.LogFactory " %> 
<%@page import = " org.jfree.chart.ChartFactory " %> 
<%@page import = " org.jfree.chart.ChartUtilities " %> 
<%@page import = " org.jfree.chart.JFreeChart " %> 
<%@page import = " org.jfree.chart.plot.PlotOrientation " %> 
<%@page import = " org.jfree.data.category.CategoryDataset " %> 
<%@page import = " org.jfree.data.category.DefaultCategoryDataset " %> 

<%@page import = " java.awt.Color " %> 
<%@page import = " org.jfree.chart.renderer.category.BarRenderer3D " %> 
<%@page import = " org.jfree.chart.labels.StandardCategoryItemLabelGenerator " %> 
<%@page import = " org.jfree.chart.axis.CategoryAxis " %> 
<%@page import = " org.jfree.chart.plot.CategoryPlot " %> 
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%>
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="java.io.*"%>
<HTML> 
<HEAD> 
<META http-equiv=Content-Type content="text/html; charset=GBK"> 
<META NAME="Author" CONTENT="Alpha">
<TITLE>程序员学历情况调查表-By Alpha</TITLE> 
</HEAD> 
<BODY> 
<% 
  DefaultCategoryDataset dataset     =   new  DefaultCategoryDataset();
  dataset.addValue( 150 ,  "北京" ,  " 苹果 " );
  dataset.addValue( 530 ,  " 上海 " ,  " 苹果 " );
  dataset.addValue( 160 ,  " 广州 " ,  " 苹果 " );
  dataset.addValue( 120 ,  " 北京 " ,  " 梨子 " );
  dataset.addValue( 230 ,  " 上海 " ,  " 梨子 " );
  dataset.addValue( 360 ,  " 广州 " ,  " 梨子 " );
  dataset.addValue( 600 ,  " 北京 " ,  " 葡萄 " );
  dataset.addValue( 430 ,  " 上海 " ,  " 葡萄 " );
  dataset.addValue( 560 ,  " 广州 " ,  " 葡萄 " );
  dataset.addValue( 400 ,  " 北京 " ,  " 香蕉 " );
  dataset.addValue( 530 ,  " 上海 " ,  " 香蕉 " );
  dataset.addValue( 660 ,  " 广州 " ,  " 香蕉 " );
  dataset.addValue( 500 ,  " 北京 " ,  " 荔枝 " );
  dataset.addValue( 630 ,  " 上海 " ,  " 荔枝 " );
  dataset.addValue( 430 ,  " 广州 " ,  " 荔枝 " );
  
    JFreeChart chart  =  ChartFactory.createBarChart3D( " 水果销量图统计-By Alpha " , " 水果种类-http://www.blogjava.net/Alpha/ " , " 销量 " ,dataset,PlotOrientation.VERTICAL, true , false , false );
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot  =  chart.getCategoryPlot();

        CategoryAxis domainAxis  =  plot.getDomainAxis();
         // domainAxis.setVerticalCategoryLabels( false );
        plot.setDomainAxis(domainAxis);

        BarRenderer3D renderer  =   new  BarRenderer3D();
        renderer.setBaseOutlinePaint(Color.BLACK);

         // 设置每个地区所包含的平行柱的之间距离
        renderer.setItemMargin( 0.1 );
         // 显示每个柱的数值，并修改该数值的字体属性
        renderer.setItemLabelGenerator( new  StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible( true );
        plot.setRenderer(renderer);

         //  设置柱的透明度
        plot.setForegroundAlpha(0.8f);

  //  ChartUtilities.writeChartAsJPEG(response.getOutputStream(),chart, 640 , 400 );
    StandardEntityCollection sec = new StandardEntityCollection(); 
            ChartRenderingInfo info = new ChartRenderingInfo(sec); 
            PrintWriter w = new PrintWriter(out);//输出MAP信息 
            //500是图片长度，300是图片高度
            //String filename = ServletUtilities.saveChartAsPNG(chart,500,300,info,session); 
            String filename = ServletUtilities.saveChartAsJPEG(chart,500,300,info,session); 
            ChartUtilities.writeImageMap(w,"map0",info,false); 

            String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
%> 
<P ALIGN="CENTER"> 
<img src="<%= graphURL %>" width=500 height=300 border=0 usemap="#map0"> 
</P> 
</BODY> 
</HTML>