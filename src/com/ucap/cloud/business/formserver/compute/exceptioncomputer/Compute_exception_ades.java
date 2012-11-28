package com.ucap.cloud.business.formserver.compute.exceptioncomputer;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.script.ScriptException;

import com.ucap.cloud.builder.jsengine.JsEngineTool;
import com.ucap.cloud.business.formserver.compute.ICompute_exceptioin;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.RepeatCalculateModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;
/**
 * 
 * @author yxk
 * <P>处理统计之外的所有业务处理</P>
 */
public class Compute_exception_ades implements ICompute_exceptioin {

	public Compute_exception_ades() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * js计算引擎
	 */
	private JsEngineTool js;
	@Override
	public String computer(String calculate, DataModel dm) {
		// TODO Auto-generated method stub
		Map<String, RepeateTable> rmap = dm.getRepeattable();
		for(String tablekey:rmap.keySet())
		{
			RepeateTable rt = dm.getRepeattable(tablekey);
			List<RepeatCalculateModel> calculatetable = rt.getCallist();
			for(RepeatCalculateModel rc :calculatetable)
			{
				this.computer(rc, rt);
			}
		}
		return null;
	}
	
	
	private String computer(RepeatCalculateModel rc,RepeateTable rt)
	{
		String calculate = rc.getCalculate();
//		System.out.println(calculate);
		Set<String> calset = rc.getCal();
		Map<String,List<String>> valuemap = rt.getRep();
		for(String rowkey:valuemap.keySet())//获取每行
		{
			List<String> value = valuemap.get(rowkey);//获取每行数据
			for(String key:calset)//key为每个计算元素
			{
				int index = rt.getConindex().indexOf(key.trim());//替换计算元的具体值
				String v = value.get(index);
				if(null==v||v.equals(""))
				{
					v = "0";
				}
				calculate = calculate.replaceAll(key.trim()+".Value",v );
			}
			try {
				String result = this.js.getJsResult(calculate);//获取到计算结果
				int resultindex = rt.getConindex().indexOf(rc.getRef());
				value.set(resultindex, result);//将计算结果重新放入原始数据中
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			valuemap.put(rowkey, value);//将行数据放入原始数据中
		}
		return null;
	}
	
	public JsEngineTool getJs() {
		return js;
	}
	public void setJs(JsEngineTool js) {
		this.js = js;
	}

	
}
