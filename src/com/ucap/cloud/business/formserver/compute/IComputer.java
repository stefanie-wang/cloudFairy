/**
 * <br>
 * computer 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: IComputer.java
 * @Package com.ucap.cloud.business.formserver.compute
 */
package com.ucap.cloud.business.formserver.compute;

import com.ucap.cloud.business.formserver.data.model.DataModel;

/**
 * @ClassName IComputer
 * @Description TODO
 *              <P>
 *              进行公式计算同时将结果赋值,在计算之前一定要进行公式解析完成
 *              </P>
 * @author yxk
 * @date 2012-8-9
 */
public interface IComputer {

	DataModel computer();
}
