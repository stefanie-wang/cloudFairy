/**
 * <br>
 * computer 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: ComputeModel.java
 * @Package com.ucap.cloud.business.formserver.compute.model
 */
package com.ucap.cloud.business.formserver.compute.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName ComputeModel
 * @Description TODO
 *              <P>
 *              记录计算公式
 *              </P>
 * @author sunjq
 * @date 2012-8-9
 */
@SuppressWarnings("serial")
public class ComputeModel implements ModelRoot {

	
	/** 
	* <p>Title: </p> 
	* <p>Description:无参构造函数 </p>  
	*/
	public ComputeModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 计算结果要赋予的对象id
	 */
	private String ref;
	/**
	 * 计算公式
	 */
	private String calculate;
	/**
	 * 我触发别人的计算公式需要触发的计算公式：后置条件
	 */
	private Set<String> relevants = new HashSet<String>();
	/**
	 * 别人触发我的计算公式：前置条件
	 */
	private Set<String> afterrelevants = new HashSet<String>();
	/**
	 * 记录计算公式涉及的计算元素
	 */
	private Set<String> computeelement = new HashSet<String>();

	private String index;

	public Set<String> getComputeelement() {
		return computeelement;
	}

	/**
	 * 
	 * @Title: init
	 * @Description: TODO
	 * @param    
	 * @return void   
	 * @throws
	 */
	public void init() {
		// ((EditBox8.Value)+(EditBox8.Value))*(EditBox3.Value)
		//编译成一个给定的正则表达式模式。
		Pattern pattern = Pattern.compile("\\+|-|\\*|\\/");
		//将this.calculate中所有的(或者)都替换成空值，然后分隔成字符串数组
		String[] matchers = pattern.split(this.calculate.replaceAll("\\(|\\)",
				""));
		Set<String> set = new HashSet<String>();
		for (String s : matchers) {
			if (s.lastIndexOf(".") > 0) {
				//截取字符串从开始到最后一个.的长度
				set.add(s.substring(0, s.lastIndexOf(".")));
			} else {
				set.add(s);
			}

		}

		this.computeelement.addAll(set);
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String id) {
		this.ref = id;
	}

	public String getCalculate() {
		return calculate;
	}

	public void setCalculate(String calculate) {
		this.calculate = calculate;
	}

	public Set<String> getRelevants() {
		return relevants;
	}

	public void setRelevants(Set<String> relevants) {
		this.relevants = relevants;
	}

	public void setRelevants(String relevants) {
		this.relevants.add(relevants);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ComputeModel cm = new ComputeModel();
		cm.setCalculate(this.calculate);
		cm.setRef(this.ref);
		Set<String> rel = new HashSet<String>();
		for (String s : this.relevants) {
			rel.add(s);
		}
		Set<String> comp = new HashSet<String>();
		for (String s : this.computeelement) {
			comp.add(s);
		}
		cm.setRelevants(rel);
		cm.setComputeelement(comp);
		return cm;
	}

	public void setComputeelement(Set<String> computeelement) {
		this.computeelement = computeelement;
	}

	@Override
	public String toString() {
		return "ComputeModel [calculate=" + calculate + ", ref=" + ref
				+ ", relevants=" + relevants + "]";
	}

	public Set<String> getAfterrelevants() {
		return afterrelevants;
	}

	public void setAfterrelevants(Set<String> afterrelevants) {
		this.afterrelevants = afterrelevants;
	}

	public void setAfterrelevants(String afterrelevants) {
		this.afterrelevants.add(afterrelevants);
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		ComputeModel cm = (ComputeModel) obj;
		if (cm.getIndex().equals(this.index)) {
			return true;
		}
		return false;
	}

}
