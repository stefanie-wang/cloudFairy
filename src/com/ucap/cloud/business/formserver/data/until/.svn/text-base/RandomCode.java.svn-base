/**  
* @Project: cloudFairy
* @Title: RandomCode.java
* @Package com.ucap.cloud.business.formserver.data.until
* @Description: TODO
* @author zhanglj
* @date 2012-10-22 下午05:03:52
* @Copyright ucap company All rights reserved.<br>
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.until;

import org.apache.commons.codec.binary.Hex;

/**
 * @ClassName RandomCode
 * @Description TODO
 */
public class RandomCode {

	/** 
	 * <p>Title: </p> 
	 * <p>Description:UUID生成类 </p>  
	 */

	public RandomCode() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return String 生成32位的随机数作为id
	 */
	public static String getCode() {
		return new String(Hex.encodeHex(org.apache.commons.id.uuid.UUID
				.randomUUID().getRawBytes()));
	}
}
