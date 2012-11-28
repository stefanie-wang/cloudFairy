/**
 * <br>
 * compute <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: ComputerImpl.java
 * @Package com.ucap.cloud.business.formserver.compute
 */
package com.ucap.cloud.business.formserver.compute;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.ucap.cloud.builder.jsengine.JsEngineTool;
import com.ucap.cloud.business.formserver.compute.model.ComputeModel;
import com.ucap.cloud.business.formserver.data.model.DataModel;

/**
 * @ClassName ComputerImpl
 * @Description TODO 进行公式计算同时将计算结果赋值给最终的数据对象 解析的时候将数据进行替换 IComputer接口的实现类
 * @author sunjq
 * @date 2012-8-9
 */
public class ComputerImpl implements IComputer {

	/**
	 * <p>
	 * Title:ComputerImpl
	 * </p>
	 * <p>
	 * Description:进行公式计算同时将计算结果赋值给最终的数据对象 解析的时候将数据进行替换
	 * </p>
	 */
	public ComputerImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 最终的数据模型对象
	 */
	private DataModel dm;
	/**
	 * 记录当前公式所影响到的其他公式
	 */
	private Set<String> iscomputer = new HashSet<String>();

	/**
	 * js计算引擎
	 */
	private JsEngineTool js;

	private Map<String, ICompute_exceptioin> exceptionmap;

	/*
	 * (non-Javadoc) <p>Title: computer</p> <p>Description: </p>
	 * 
	 * @return DataModel 返回idf文件原始的数据信息
	 * 
	 * @see com.ucap.cloud.business.formserver.compute.IComputer#computer()
	 */
	public DataModel computer() {
		// TODO Auto-generated method stub
		// long i = System.currentTimeMillis();
		ICompute_exceptioin ie = this.exceptionmap.get("ades_ucap_formserver");
		ie.computer(null, this.dm);// 计算重复表中的普通公式
		// 获取要计算的公式
		Map<String, ComputeModel> compMap = this.dm.getCompMap();
		Set<String> keyset = compMap.keySet();
		for (String key : keyset) {
			// 循环处理要计算的公式
			if(null!=compMap.get(key) && null!=key){
				computer(compMap, compMap.get(key));
			}
			
		}
		// System.out.println("计算耗时：" + (System.currentTimeMillis() - i));
		return this.dm;
	}

	/**
	 * @Title: computer
	 * @Description: TODO 计算每个公式的值
	 * @param @param map 当前公式所影响的其他公式
	 * @param @param cm   当前公式
	 * @return void   
	 * @throws
	 */
	private void computer(Map<String, ComputeModel> map, ComputeModel cm) {
		// 非空判断，如果计算公式不为空时进行下列操作
		if(null!=cm){
			
		
		if (null != cm.getCalculate()) {

			String calculate = cm.getCalculate();// 当前计算公式(EditBox11.Value)+(EditBox14.Value)
			// System.out.println(calculate);
			Set<String> after = cm.getAfterrelevants();// 前置条件
			Set<String> relacet = cm.getRelevants();// 后置条件
			if (after.size() > 0) {
				for (String afterkey : after) {
					if (this.iscomputer.add(cm.getIndex())) {
						this.computer(map, map.get(afterkey));
					}
				}
			}
			Set<String> paramters = cm.getComputeelement();
			for (String key : paramters) {
				if (null != this.dm.getInputs().get(key)) {
					// 获取键值为key的idf文件的输入项数据
					String value = this.dm.getInputs().get(key).getValue();
					if (null == value || value.trim().equals("")) {
						// System.out.println(this.dm.getInputs().get(key).getNamepath());
						// 若输入项数据为空，则将其初值赋为0
						value = "0";
					}
					// 将计算公式中的空件名.Value全部替换成实际值
					calculate = calculate.replaceAll(key + ".Value", value);
				}
			}
//			System.out.println(calculate);
			// 获取计算结果
			String result = "";
			try {
				result = this.js.getJsResult(calculate);
			} catch (Exception e) {
				if(null!=this.getExceptionmap(calculate)){
					result = this.getExceptionmap(calculate).computer(calculate,
							this.dm);
					
				}

				
				/**
				 * 处理重复表中的统计公式
				 */

			}
			if(result.equals("NaN")){
				result = "0";
			}
			// System.out.println(calculate+"计算结果:"+result);
			// 将计算结果赋值给需计算的那个控件
			this.dm.getInputs().get(cm.getRef()).setValue(result);
			// 如果是后置条件
			if (relacet.size() > 0) {
				for (String beforekey : relacet) {
					if (this.iscomputer.add(cm.getIndex())) {
						this.computer(map, map.get(beforekey));

					}
				}
			}
		}
	}
	}

	public DataModel getDm() {
		return dm;
	}

	public void setDm(DataModel dm) {
		this.dm = dm;
	}

	public JsEngineTool getJs() {
		return js;
	}

	public void setJs(JsEngineTool js) {
		this.js = js;
	}

	public Map<String, ICompute_exceptioin> getExceptionmap() {
		return exceptionmap;
	}

	/**
	 * 
	 * @param key
	 *            为正则表达式
	 * @return 获取相关的可以进行计算的特殊公式处理处理对象
	 */
	private ICompute_exceptioin getExceptionmap(String calculate) {
		ICompute_exceptioin ie = null;

		Set<String> keyset = this.exceptionmap.keySet();
		for (String k : keyset) {
			Pattern px = Pattern.compile(k);

			boolean bx = px.matcher(calculate).find();

			if (bx) {
				ie = this.exceptionmap.get(k);
				break;
			}
		}
		return ie;
	}

	static public void main(String arg[]) {
		// Pattern p = Pattern.compile("Table[\\d\\.\\w]*Sum");
		// boolean b = p.matcher("( Table.EditBox4_Sum.text)").find();
		// System.out.println(b);

	}

	public void setExceptionmap(Map<String, ICompute_exceptioin> exceptionmap) {
		this.exceptionmap = exceptionmap;
	}

}
