/**
 * 
 */
package com.ucap.cloud.business.formserver.compute.exceptioncomputer;

import java.util.regex.Pattern;

import com.ucap.cloud.builder.jsengine.JsEngineTool;
import com.ucap.cloud.business.formserver.compute.ICompute_exceptioin;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

/**
 * @author yxk
 *<P>处理求平均值计算</P>
 */
public class Compute_exceptioin_avg implements ICompute_exceptioin {

	/**
	 * 
	 */
	public Compute_exceptioin_avg() {
		// TODO Auto-generated constructor stub
	}
	
	private JsEngineTool js;

	/* (non-Javadoc)
	 * @see com.ucap.cloud.business.formserver.compute.ICompute_exceptioin#computer(java.lang.String, com.ucap.cloud.business.formserver.data.model.DataModel)
	 */
	@Override
	public String computer(String calculate, DataModel dm) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[(_\\.]");
		String arg[] = p.split(calculate);
		String tablekey = arg[1].trim();
		String clumkey = arg[2].trim();
		RepeateTable rt = dm.getRepeattable(tablekey);
		int index  = dm.getRepeattable(tablekey).getConindex().indexOf(clumkey);
		double count = 0.0d;
		for(String key:rt.getRep().keySet())
		{
			String value = (String) rt.getRep().get(key).get(index);
			if(null==value||value.equals(""))
			{
				value = "0.0";
			}
			count=count +Double.valueOf(value);
		}
		count = count/rt.getRep().size();
		return ""+count;
	}

	public JsEngineTool getJs() {
		return js;
	}

	public void setJs(JsEngineTool js) {
		this.js = js;
	}

	
}
