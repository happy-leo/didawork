package com.tt.modules.sys.entity;

import com.tt.common.config.Global;
import com.tt.common.persistence.DataEntity;

public class App extends DataEntity<App> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//应用名称
    private String  appName;
    // 应用关键key
    private String  appKey;
    //加密名称
    private String  appSecret;
    //是否可用 1:可用 0：不可用
    private String useable;
    
    
	public App() {
		super();
		this.useable = Global.YES;
	}

	public App(String id) {
		super(id);
	} 
    
    
	/**
	 * @return Returns the useable.
	 */
	public String getUseable() {
		return useable;
	}
	/**
	 * @param useable The useable to set.
	 */
	public void setUseable(String useable) {
		this.useable = useable;
	}
	/**
	 * @return Returns the appName.
	 */
	public String getAppName() {
		return appName;
		
	}
	/**
	 * @param appName The appName to set.
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * @return Returns the appKey.
	 */
	public String getAppKey() {
		return appKey;
	}
	/**
	 * @param appKey The appKey to set.
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	/**
	 * @return Returns the appSecret.
	 */
	public String getAppSecret() {
		return appSecret;
	}
	/**
	 * @param appSecret The appSecret to set.
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

    
    
    
}
