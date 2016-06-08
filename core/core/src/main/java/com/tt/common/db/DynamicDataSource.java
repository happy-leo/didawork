/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: DynamicDataSource.java 
 * @Prject: core
 * @Package: com.tt.common.db 
 * @Description: TODO
 * @author: Administrator   
 * @date: 2016年5月23日 下午4:29:45 
 * @version: V1.0   
 */
package com.tt.common.db;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
	 
	/**
	 * Mysql 多数据源切换
	 *
	 * @version V1.0
	 * @Description:
	 * @date 2015/10/09
	 */
	public class DynamicDataSource extends AbstractRoutingDataSource
	{
	    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>(); 
	        
	    /*
	     * (non-Javadoc)
	     * 
	     * @see
	     * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
	     * determineCurrentLookupKey()
	     */ 
	    @Override 
	    protected Object determineCurrentLookupKey() { 
	        return getCurrentLookupKey(); 
	    } 
	     
	    /**
	     * 
	     * @author sa
	     * @date 2012-5-18 下午4:06:44
	     * @return the currentLookupKey
	     */ 
	    public static String getCurrentLookupKey() { 
	        return (String) contextHolder.get(); 
	    } 
	    
	    /**
	     * 
	     * @author sa
	     * @date 2012-5-18 下午4:06:44
	     * @param currentLookupKey
	     *            the currentLookupKey to set
	     */ 
	    public static void setCurrentLookupKey(String currentLookupKey) { 
	        contextHolder.set(currentLookupKey); 
	    } 
	    
}
