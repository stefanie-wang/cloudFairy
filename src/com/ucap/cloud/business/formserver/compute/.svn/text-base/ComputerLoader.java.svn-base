/**
 * <br>
 * compute 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: ComputerLoader.java
 * @Package com.ucap.cloud.business.formserver.compute
 */
package com.ucap.cloud.business.formserver.compute;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.compute.model.ComputeModel;
import com.ucap.cloud.business.formserver.data.model.DataModel;

/**
 * @ClassName ComputerLoader
 * @Description TODO
 *              <P>
 *              加载所有的计算公式
 *              </P>
 * @author sunjq
 * @date 2012-8-9
 */
public class ComputerLoader {
	static private Logger log = Logger.getLogger(ComputerLoader.class);
	/**
	 * <p>
	 * Title:初始化一个无参的ComputerLoader对象
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public ComputerLoader() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * <p>
	 * Title:有参构造函数
	 * </p>
	 * <p>
	 * Description: 共用一个DataModel
	 * </p>
	 * 
	 * @param dm idf文件原始的数据信息
	 */
	public ComputerLoader(DataModel dm) {
		// TODO Auto-generated constructor stub
		this.dm = dm;
	}

	/**
	 * 记录所有的计算公式
	 */
	private DataModel dm;

	public DataModel getDm() {
		return dm;
	}

	public void setDm(DataModel dm) {
		this.dm = dm;
	}

	// 临时存放计算公式解析的结果
	private List<ComputeModel> cmplist = new ArrayList<ComputeModel>();

	/**
	 * @Title: loader
	 * @Description: TODO
	 * @param bindsEle
	 *                计算公式的根节点
	 * @return void   
	 * @throws
	 */
	public void loader(Element bindsEle) {
		List<Element> list = bindsEle.elements();
		for (int i = 0; i < list.size(); i++) {
			ComputeModel cm = new ComputeModel();
			Element e = list.get(i);
			String calculate = e.attributeValue("calculate");
			String ref = e.attributeValue("ref");
			cm.setCalculate(calculate);
			cm.setRef(ref);
			cm.setIndex("" + i);
			cm.init();

			cmplist.add(cm);
		}
		this.binds();
	}
	/** 
	* @Title: binds 
	* @Description: TODO进行计算公式关系的设定
	* @param      
	* @return void     
	* @throws 
	*/
	private void binds() {
		// System.out.println(this.cmplist.size());
		for (ComputeModel nm : this.cmplist) {
			Set<String> calculatepaty = nm.getComputeelement();
			for (String key : calculatepaty) {
				for (ComputeModel nn : this.cmplist) {
					if (!nn.equals(nm)) {
						if (nn.getComputeelement().contains(key)) {
							nm.setRelevants(nn.getIndex());
						}
						if (nn.getComputeelement().contains(nm.getRef())) {
							nm.setAfterrelevants(nn.getIndex());
						}
					}
				}
			}
			if ((nm.getRelevants().size() > 0 && nm.getAfterrelevants().size() > 0)
					&& (nm.getRelevants().containsAll(nm.getAfterrelevants()))
					&& (nm.getAfterrelevants().containsAll(nm.getRelevants()))) {
				log.info("计算公式嵌套！");
				break;
			}
			this.dm.setComMap(nm.getIndex(), nm);
		}
		log.info("共有计算公式个数：" + this.dm.getCompMap().size());
	}

}
