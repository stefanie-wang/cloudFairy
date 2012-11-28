/**
 * 
 */
package com.ucap.cloud.business.formserver.compute.exceptioncomputer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.ucap.cloud.business.formserver.compute.ICompute_exceptioin;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

/**
 * @author yxk
 *
 */
public class Compute_exceptioin_max implements ICompute_exceptioin {

	/**
	 * 
	 */
	public Compute_exceptioin_max() {
		// TODO Auto-generated constructor stub
	}

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
		
		List<Double> list = new ArrayList<Double>();
		for(String key:rt.getRep().keySet())
		{
			String value = (String) rt.getRep().get(key).get(index);
			if(null==value||value.equals(""))
			{
				value = "0.0";
			}
			list.add(Double.valueOf(value));
		}
		Collections.sort(list);
		
		return ""+list.get(list.size()-1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> list = new ArrayList<Double>();
		list.add(10000d);
		for(int i=0;i<10;i++)
		{
			list.add(Double.valueOf(i));
		}
		list.add(1000d);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
	}

}
