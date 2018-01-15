package com.yyy.dailycode.stock.getstockitem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *   @类名： GetStockData
 *   @描述： 获取代码
 *   @作者： 杨文胜
 *   @生成时间： 2015-12-21 上午11:07:49
 *   @修改人：
 *   @修改时间：  
 **/
public class GetStockCodeData {
	public static void main(String[] args) {
		try {
			saveStockCodes(codes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String db  = "C:\\Users\\yang\\Desktop\\sina-stock-codes.txt" ;  
//    private static final int COLUMNS = 32;  
    private static List<String> codes = new ArrayList<String>() ;  
      
    static{  
        File in = new File(db) ;  
        if(! in.exists()){  
            // 从网络获取  
            if(codes.size() < 1 )  
                try {  
                    codes = getAllStackCodes() ;  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
        }else{  
            // 从本地获取  
            if(codes.size() < 1)  
                try {  
                    codes = getAllStockCodesFromLocal() ;  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
        }  
    }  
	//把新浪38页的所有股票代码存入本地文件  
    private static void saveStockCodes(List<String> codes ) throws IOException{  
        //将所有股票代码存入文件中  
        File out = new File(db) ;  
        if(! out.exists())  
            out.createNewFile() ;  
        BufferedWriter bw = new BufferedWriter(new FileWriter(out)) ;  
        for(String code : codes ){  
            bw.write(code) ;  
            bw.newLine() ;  
        }  
        if(bw != null ){  
            bw.close() ;  
            bw = null ;  
        }  
    }  
    // 获取新浪38也的所有股票代码  
    private static List<String> getAllStackCodes() throws IOException{  
        List<String> codes = new ArrayList<String>() ;  
        int i =1 ;  
        URL url = null ;  
        // 新浪 股票 好像目前为止就 38页  
        for(; i < 73 ; i ++ ){  
             //url = new URL("http://vip.stock.finance.sina.com.cn/q/go.php/vIR_CustomSearch/index.phtml?p="+i) ;  
             url = new URL("http://vip.stock.finance.sina.com.cn/q/go.php/vIR_CustomSearch/index.phtml?sr_p=-1&p="+i) ;  
             String code = getBatchStackCodes(url) ;  
             System.out.println(code);
             codes.addAll(handleStockCode(code)) ;  
        }  
        if(! ( new File(db) ).exists() )  
            saveStockCodes(codes) ;  
        return codes ;  
    }  
 // 解析一组股票代码字符串   把code中包括的所有股票代码放入List中  
    private static List<String> handleStockCode(String code){  
        List<String> codes = null ;  
        int end = code.indexOf(";") ;  
            code = code.substring(0,end) ;  
        int start = code.lastIndexOf("=") ;  
           code = code.substring(start) ;  
           code = code.substring(code.indexOf("\"")+1,code.lastIndexOf("\"")) ;  
           codes = Arrays.asList(code.split(",")) ;  
        return codes ;  
    }  
//  返回的值是一个js代码段  包括指定url页面包含的所有股票代码  
    private static String getBatchStackCodes(URL url) throws IOException{  
         URLConnection connection = url.openConnection() ;  
         connection.setConnectTimeout(30000) ;  
         BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())) ;  
         String line = null ;  
         StringBuffer sb = new StringBuffer() ;  
        boolean flag =false ;  
         while((line = br.readLine()) != null ){  
             if(line.contains("<script type=\"text/javascript\">") || flag){  
                 sb.append(line) ;  
                 flag = true ;  
             }  
             if(line.contains("</script>")){  
                 flag =false ;  
                 if(sb.length() > 0 ){  
                     if(sb.toString().contains("code_list") && sb.toString().contains("element_list")){  
                         break ;  
                     }else{  
                         sb.setLength(0) ;  
                     }  
                 }  
             }  
         }  
         if(br != null ){  
             br.close() ;  
             br= null ;  
         }  
        return sb.toString() ;  
    }  
    private static List<String> getAllStockCodesFromLocal() throws IOException{  
        List<String> codes = new ArrayList<String>() ;  
        File in = new File(db) ;  
        if(! in.exists())  
            throw new IOException("指定数据文件不存在!");  
        BufferedReader br = new BufferedReader(new FileReader(in)) ;  
        String line = null ;  
        while( ( line = br.readLine() ) != null ){  
            codes.add(line) ;  
        }  
        // 删除最后一个空行  
        codes.remove(codes.size()-1) ;  
        if(br != null ){  
            br.close() ;  
            br = null ;  
        }  
        return codes ;  
    }  
}
