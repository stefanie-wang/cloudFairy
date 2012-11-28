/**
 * 
 */
package com.ucap.cloud.business.formserver.compute.exceptioncomputer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ucap.cloud.builder.jsengine.JsEngineTool;
import com.ucap.cloud.business.formserver.compute.ICompute_exceptioin;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

/**
 * @author yxk
 * <P>处理求和计算</P>
 */
public class Compute_exceptioin_sum implements ICompute_exceptioin {

	/**
	 * 
	 */
	public Compute_exceptioin_sum() {
		// TODO Auto-generated constructor stub
	}

	private JsEngineTool js;
	
	/* (non-Javadoc)
	 * @see com.ucap.cloud.business.formserver.compute.ICompute_exceptioin#computer(java.lang.String, com.ucap.cloud.business.formserver.data.model.DataModel)
	 * 
	 */
	@Override
	public String computer(String calculate, DataModel dm) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[(_\\.]");
		Pattern px = Pattern.compile("\\d");
		String arg[] = p.split(calculate);
		String tablekey = arg[1].trim();
		String clumkey = arg[2].trim();
		RepeateTable rt = dm.getRepeattable(tablekey);
		int index  = dm.getRepeattable(tablekey).getConindex().indexOf(clumkey);
		double count = 0.0d;
		for(String key:rt.getRep().keySet())
		{
			if(index!=-1){
				
				
			String value = (String) rt.getRep().get(key).get(index);
			Matcher mx = px.matcher(value);
			if(null==value||value.equals("")||!mx.matches())
			{
				value = "0.0";
			}
			count=count +Double.valueOf(value);
			}
		}
		return ""+count;
	}
	
//	static public  void main(String arg[])
//	{
//		Pattern p = Pattern.compile("[(_\\.]");
//		String ar[]= p.split("( Table1.EditBox4_2_Sum.text)");
//		for(String s:ar)
//		{
//			if(s.length()>0)
//			System.out.println(s);
//		}
//	}

	public JsEngineTool getJs() {
		return js;
	}

	public void setJs(JsEngineTool js) {
		this.js = js;
	}

	
}
