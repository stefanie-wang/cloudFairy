/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: ClassAuthority.java
 * @Package com.ucap.cloud.builder.annotation
*/
package com.ucap.cloud.builder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yxk
 * <P>处理一个对象整体的权限</P>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassAuthority {

	String methodId();
}

