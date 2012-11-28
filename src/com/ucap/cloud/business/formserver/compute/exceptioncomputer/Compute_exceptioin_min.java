package com.ucap.cloud.business.formserver.compute.exceptioncomputer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.ucap.cloud.business.formserver.compute.ICompute_exceptioin;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

public class Compute_exceptioin_min implements ICompute_exceptioin{

	public Compute_exceptioin_min() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
		
		return ""+list.get(0);
	}

}
