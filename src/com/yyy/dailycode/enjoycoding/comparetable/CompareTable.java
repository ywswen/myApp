package com.yyy.dailycode.enjoycoding.comparetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.yyy.dailycode.enjoycoding.comparetable.db.OrabDB;
import com.yyy.dailycode.enjoycoding.comparetable.db.OraeDB;
import com.yyy.dailycode.enjoycoding.comparetable.db.vo.FieldBean;
import com.yyy.dailycode.enjoycoding.comparetable.db.vo.TableBean;
import com.yyy.dailycode.enjoycoding.comparetable.util.BeanMapUtil;
import com.yyy.util.FileWriter;
import com.yyy.util.UUIDFactoryUtil;

public class CompareTable {
	private static final String B_FIELD_PATH = "D:\\b_field.sql";
	private static final String B_TABLE_PATH = "D:\\b_table.sql";
	private static final String E_FIELD_PATH = "D:\\e_field.sql";
	private static final String E_TABLE_PATH = "D:\\e_table.sql";
	/**
	 *   @生成时间： 2014-10-14 上午11:03:37
	 *   @方法说明： 比较b库和e库中的差异，将b库中缺少的带出来
	 *   @参数：
	 *   @返回值： 
	 * @throws Exception 
	 *   @异常：
	 **/
	@Test
	public void testGetDifferentD() throws Exception{
		List<Object> btableList = getOrabTableList();
		List<Object> etableList = getOraeTableList();
		for(Object btable : btableList){
			boolean isTableDifferent = true;
			TableBean btableBean = (TableBean)btable;
			for(Object etable : etableList){
				TableBean etableBean = (TableBean)etable;
				if(btableBean.getTablename().equals(etableBean.getTablename())){
					isTableDifferent = false;
					List<FieldBean> bfieldBeanList = btableBean.getFieldList();
					List<FieldBean> efieldBeanList = etableBean.getFieldList();
					for(FieldBean bfieldBean : bfieldBeanList){
						boolean isFieldDifferent = true;
						for(FieldBean efieldBean : efieldBeanList){
							if(bfieldBean.getColname().equals(efieldBean.getColname())){
								isFieldDifferent = false;
								break;//跳出当前循环
							}
						}
						if(isFieldDifferent){
//							String content = "alter table " + btableBean.getTablename() + " add " + bfieldBean.getColname() + "【" + bfieldBean.getColcomment()+ "】 " + getDataType(bfieldBean.getZd_zdlx());
//							content += "是否为空【" + bfieldBean.getNullable() + "】;";
							String id = UUIDFactoryUtil.generateZafkUUID();
							
							String colname = bfieldBean.getColname();
							String colcomment = exchangeNull(bfieldBean.getColcomment());
							String zd_zdlx = getDataType(bfieldBean.getZd_zdlx());
							String isNullAble = exchangeNullAble(bfieldBean.getNullable());
							StringBuffer insert = new StringBuffer("INSERT INTO rcm_fieldlist (ID,tableid,colname,colcomment,hasdic,zd_zdlx,zd_sfwk,zd_sfbt,ts,uts,zjzd)VALUES(");
							insert.append("'").append(id).append("',");
							insert.append("'").append(etableBean.getId()).append("',");
							insert.append("'").append(colname).append("',");
							insert.append("'").append(colcomment).append("',");
							insert.append("'0',");
							insert.append("'").append(zd_zdlx.toUpperCase()).append("',");
							insert.append("'").append(isNullAble).append("',");
							insert.append("'0',");
							insert.append("SYSTIMESTAMP,");
							insert.append("SYSTIMESTAMP,");
							insert.append("'0');");
							FileWriter.write(insert.toString(), B_FIELD_PATH);
							//System.out.println("e库中的表【" + etableBean.getTablename() + "】的字段【" + efieldBean.getColname()+ "】在b库中不存在！");
							//System.out.println("alter table " + btableBean.getTablename() + " add " + bfieldBean.getColname() + " " + getDataType(bfieldBean.getZd_zdlx()));
						}
					}
					break;//跳出当前循环
				}
			}
			if(isTableDifferent){
				FileWriter.write("'" + btableBean.getTablename() + "',", B_TABLE_PATH);
				//System.out.println("b库中的表【" + btableBean.getTablename() + "】在e库中不存在！");
			}
		}
	}
	/**
	 *   @生成时间： 2014-10-14 上午11:04:18
	 *   @方法说明： 比较b库和e库中的差异，将e库中缺少的带出来
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void testGetDifferentE() throws Exception{
		List<Object> etableList = getOraeTableList();
		List<Object> btableList = getOrabTableList();
		for(Object etable : etableList){
			boolean isTableDifferent = true;
			TableBean etableBean = (TableBean)etable;
			for(Object btable : btableList){
				TableBean btableBean = (TableBean)btable;
				if(etableBean.getTablename().equals(btableBean.getTablename())){
					isTableDifferent = false;
					List<FieldBean> efieldBeanList = etableBean.getFieldList();
					List<FieldBean> bfieldBeanList = btableBean.getFieldList();
					for(FieldBean efieldBean : efieldBeanList){
						boolean isFieldDifferent = true;
						for(FieldBean bfieldBean : bfieldBeanList){
							if(efieldBean.getColname().equals(bfieldBean.getColname())){
								isFieldDifferent = false;
								break;//跳出当前循环
							}
						}
						if(isFieldDifferent){
							String content = "alter table " + etableBean.getTablename() + " drop column  " + efieldBean.getColname() + ";";
							FileWriter.write(content, E_FIELD_PATH);
							//System.out.println("e库中的表【" + etableBean.getTablename() + "】的字段【" + efieldBean.getColname()+ "】在b库中不存在！");
							System.out.println("alter table " + etableBean.getTablename() + " drop column  " + efieldBean.getColname() + ";");
						}
					}
					break;//跳出当前循环
				}
			}
			if(isTableDifferent){
				FileWriter.write(etableBean.getTablename(), E_TABLE_PATH);
				System.out.println("e库中的表【" + etableBean.getTablename() + "】在b库中不存在！");
			}
		}
	}
	/**
	 *   @生成时间： 2014-10-13 下午04:42:49
	 *   @方法说明： 获取e库的表和字段的集合
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public static List<Object> getOraeTableList() {
		String tableSql = "select t.id as id,"
				+ "       t.TABLENAME as tablename,"
				+ "       t.tablecomment as tablecomment"
				+ "  from RCM_TABLELIST t, rcm_sys_table_map m"
				+ " where t.id = m.tableid"
				+ "   and m.sysid = '8a88860338b2e1040138b6fe33ad02c1'"
				+ " order by UPPER(t.TABLENAME)";
		List<Map> tableListMap = OraeDB.queryForList(tableSql);
		List<Object> tableList = BeanMapUtil.convertMapForList(TableBean.class,
				tableListMap);

		String fieldSql = "select t.id as id,"
				+ "       t.tablename as tablename,"
				+ "       f.colname,"
				+ "       f.colcomment,"
				+ "       f.zd_zdlx"
				+ "  from rcm_tablelist t, rcm_sys_table_map m, rcm_fieldlist f"
				+ " where t.id = m.tableid"
				+ "   and m.sysid = '8a88860338b2e1040138b6fe33ad02c1'"
				+ "   and t.id = f.tableid"
				+ " order by upper(t.tablename), colname";
		List<Map> fieldListMap = OraeDB.queryForList(fieldSql);
		List<Object> fieldList = BeanMapUtil.convertMapForList(FieldBean.class,
				fieldListMap);

		for (Object otable : tableList) {
			TableBean tableBean = (TableBean) otable;
			List<FieldBean> tmpFieldList = new ArrayList<FieldBean>();
			for (Object ofield : fieldList) {
				FieldBean fieldBean = (FieldBean) ofield;
				if (fieldBean.getTablename().equals(tableBean.getTablename())) {
					tmpFieldList.add(fieldBean);
				}
			}
			tableBean.setFieldList(tmpFieldList);
		}
		return tableList;
	}
	/**
	 *   @生成时间： 2014-10-13 下午04:42:49
	 *   @方法说明： 获取b库的表和字段的集合
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public static List<Object> getOrabTableList() {
		String tableSql = "select '' as id,"
			+ "       table_name as tablename,"
			+ "       comments as tablecomment"
			+ "  from user_tab_comments where table_type='TABLE' order by table_name";
		List<Map> tableListMap = OrabDB.queryForList(tableSql);
		List<Object> tableList = BeanMapUtil.convertMapForList(TableBean.class,
				tableListMap);
		
		String fieldSql = "select '' id," 
			    + " 	  c.table_name tablename,"
				+ "       c.column_name colname,"
				+ "       c.nullable nullable,"
				+ "       cc.comments colcomment,"
				+ "       c.data_type || ':' || c.data_length zd_zdlx"
				+ "  from user_tab_cols c, user_col_comments cc, user_tab_comments t"
				+ " where c.table_name = cc.table_name and c.column_name = cc.column_name"
				+ " 	  and t.table_name = c.table_name"
				+ " 	  and t.table_type='TABLE'"
				+ " order by upper(c.table_name), c.column_name";

		List<Map> fieldListMap = OrabDB.queryForList(fieldSql);
		List<Object> fieldList = BeanMapUtil.convertMapForList(FieldBean.class,
				fieldListMap);
		
		for (Object otable : tableList) {
			TableBean tableBean = (TableBean) otable;
			List<FieldBean> tmpFieldList = new ArrayList<FieldBean>();
			for (Object ofield : fieldList) {
				FieldBean fieldBean = (FieldBean) ofield;
				if (fieldBean.getTablename().equals(tableBean.getTablename())) {
					tmpFieldList.add(fieldBean);
				}
			}
			tableBean.setFieldList(tmpFieldList);
		}
		return tableList;
	}
	public static String getDataType(String data) throws Exception{
		if(StringUtils.isEmpty(data)){
			throw new Exception("表字段为空");
		} 
		data = data.toLowerCase();
		if(data.indexOf("varchar2") > -1){
			data = data.replace(":", "(") + ")";
		}else if(data.indexOf("clob") > -1){
			data = "clob";
		}else if(data.indexOf("timestamp") > -1){
			data = data.substring(0, data.indexOf(":"));
		}else if(data.indexOf("integer") > -1){
			data = "integer";
		}else if(data.indexOf("number") > -1){
			data = "number";
		}else if(data.indexOf("date") > -1){
			data = "date";
		}else if(data.indexOf("char") > -1){
			data = data.replace(":", "(") + ")";
		}else if(data.indexOf("nvarchar2") > -1){
			data = data.replace(":", "(") + ")";
		}else if(data.indexOf("blob") > -1){
			data = "blob";
		}else if(data.indexOf("long") > -1){
			data = "long";
		}else if(data.indexOf("long raw") > -1){
			data = "long raw";
		}else if(data.indexOf("undefined") > -1){
			data = "undefined";
		}
		return data;
	}
	/**
	 *   @生成时间： 2014-10-15 上午11:32:13
	 *   @方法说明： 转换是否为空字段，转换格式标准为：Y-->0;N-->1;其他-->0
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String exchangeNullAble(String isNullAble){
		if(StringUtils.isEmpty(isNullAble)){
			isNullAble = "0";
		}else if("Y".equals(isNullAble.toUpperCase())){
			isNullAble = "0";
		}else if("N".equals(isNullAble.toUpperCase())){
			isNullAble = "1";
		}else{
			isNullAble = "0";
		}
		return isNullAble;
	}
	/**
	 *   @生成时间： 2014-10-15 上午11:32:13
	 *   @方法说明： 转换字段，如果str为空，则返回" "空格，否则返回原值str
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String exchangeNull(String str){
		if(null == str){
			str = " ";
		}
		return str;
	}
}
