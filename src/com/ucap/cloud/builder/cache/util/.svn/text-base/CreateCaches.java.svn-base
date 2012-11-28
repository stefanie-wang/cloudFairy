/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CreateCaches .java
 * @Package com.ucap.cloud.builder.cache.util
 */
package com.ucap.cloud.builder.cache.util;

import org.apache.log4j.Logger;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @ClassName CreateCaches
 * @Description TODO
 *              <p>
 *              获取cache的工具类
 *              </p>
 * @author sunjq
 * @date 2012-8-10
 */
public class CreateCaches {

	static private Logger log = Logger.getLogger(CreateCaches.class);
	private CacheManager manager;
	
	/** 
	* @Fields ucapcache : TODO
	* 默认缓存的名字
	*/
	private String ucapcache;
	/** 
	* @Fields xmlpath : TODO
	* 缓存的配置文件路径
	*/
	private String xmlpath;

	public CreateCaches() {
		// TODO Auto-generated constructor stub
	}

	public CreateCaches(String xmlpath) {

		this.xmlpath = xmlpath;
	}

	// 获得CacheManager对象
	public CacheManager getManager() {
		return manager;

	}

	public Cache getCache() {
		return this.manager.getCache(this.ucapcache);
	}

	public Cache getCache(String cachename) {
		return this.manager.getCache(cachename);
	}

	// 通过Key值将Object对象放入缓存
	public Cache putElement(String key, Object value) {
		this.getCache().put(new Element(key, value));
		return this.getCache();
	}

	// 通过key在cache中获得Object对象
	public Object getVluae(String key) {
		if (null == this.getCache().get(key)) {
			return null;
		}
		return this.getCache().get(key).getValue();
	}

	// 通过Key删除在cache中的缓存对象
	public boolean removeCaches(String key) {
		try {
			this.manager.getCache(this.ucapcache).remove(key);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 通过配置文件初始化CacheManager
	 * 
	 * @param xml
	 * @return
	 */
	public void init() {
		String xml = this.getClass().getClassLoader().getResource(this.xmlpath)
				.getFile();

		log.info(xml);
		manager = CacheManager.create(xml);

	}

	/**
	 * 关闭cache连接
	 * 
	 * @return
	 */
	public boolean shotdown() {
		try {
			this.manager.shutdown();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getUcapcache() {
		return ucapcache;
	}

	public void setUcapcache(String ucapcache) {
		this.ucapcache = ucapcache;
	}



}
