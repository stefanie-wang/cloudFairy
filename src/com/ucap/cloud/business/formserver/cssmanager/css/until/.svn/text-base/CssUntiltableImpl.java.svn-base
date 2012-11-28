package com.ucap.cloud.business.formserver.cssmanager.css.until;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.dom4j.Element;

import com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate.GetCssFileDateGetTableModle;
import com.ucap.cloud.business.formserver.data.model.DataEventLoader;
import com.ucap.cloud.business.formserver.data.model.EventsModel;
import com.ucap.cloud.business.formserver.data.model.RepeatCalculateModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

public class CssUntiltableImpl implements CssUntiltable,CssUntilGetModel {

	public CssUntiltableImpl(){
		
	}
	/**
	 * 获取所有需要进行解析的具体类对象
	 */
	private Map<String, CssUntilGetAllModel> tablemap ;
	/**
	 *  重复表的属性 例如 宽度，几行几列
	 */
    private Map<String,String> mapcol ;
	/**
	 * 重复表内可以放置的控件类型
	 */
	private  Map<String, CssUntilGetAllModel> chongfutablemap;
	
	/**
	 * 保存重复表的控件
	 */
	private List<String> listcfb = new ArrayList<String>();
	
	/**
	 * 处理重复表
	 * @param controlsson idf重复表节点
	 * @param pxl    解析idf类 
	 * @return     返回重复表本身以及控件的css样式
	 * @throws Exception
	 */
	public List<String> getBigControls(Element controlsson,CssUntilParseXML pxl) throws Exception{
		//css样式的总和
		List<String> list = new ArrayList<String>();
		//个别控件的处理总和
//		List<String> arr = new ArrayList<String>();
		// add by sunjq 创建保存重复表数据的模型
		RepeateTable repeatt = new RepeateTable(controlsson);
		String repname = "";
		// end add
		GetCssFileDateGetTableModle gtable = new GetCssFileDateGetTableModle();
		int tablerowcount = 0;
		String tablename = "";
		List<String> listtabel = gtable.getStringCss(controlsson);
		for (String ss : listtabel) {
			list.add(ss);
		}
		List<Element> listtable = controlsson.elements();
		for (int tabel = 0; tabel < listtable.size(); tabel++) {
			Element columns = listtable.get(tabel);
			 //获取重复表内部的计算公式
			if(columns.getName().equals("binds")){
				if(this.getbinds(columns).getCalculate().length()>0){
					  repeatt.setCallist(this.getbinds(columns));
				}
			}
			if(columns.getName().equals("events")){
				//处理重复块的自定义事件
				String conname = controlsson.getName();
				Map<String, String> map = new HashMap<String, String>();
				DataEventLoader devl = (DataEventLoader)SPRINGCONTEXT.getBean("eventloader");
				//获得事件模型
					EventsModel evmo = devl.getEvns().get(conname);
					if (null != evmo) {
						//所有事件类型
						Set<String> set = evmo.getEventC().keySet();	
						for (String k : set) {
							columns.getName();
							if (null != columns.element(k)
									.element("JScript").getText()
									&& !"".equals(columns
											.element(k).element("JScript")
											.getText())) {
								//将事件类型（如onclick或者onchange）和js内容放入map中
								map.put(k, controlsson.element("events")
										.element(k).element("JScript").getText());
							}
							evmo.setId(controlsson.element("name").getText());
							evmo.setEventC(map);
						}
				}
				pxl.getDm().setEvents(evmo);
			}
			//获得重复表的属性
			if(null!=mapcol.get(columns.getName())){
				this.getTableAtrr(repeatt, columns);
			}
			if (columns.getName().equals("name")) {
				tablename = columns.getText();
				repname = tablename;						
//				CreateTableJsp cr = new CreateTableJsp(pxl);
//				cr.setTablename(tablename);
//				cr.ceeatetablejsp();
			}
			if (columns.getName().equals("columns")) {
				//重复表内的控件接卸
				list.addAll(this.getTableControls(columns, pxl, repeatt, tablerowcount, tablename));
			}
		}
		List<RepeateTable> repeattable = new ArrayList<RepeateTable>();
		repeattable.add(repeatt);
		
		pxl.getDm().setRepeattable(repname, repeatt);
		return list;
	}
	/**
	 * 解析重复表中的计算公式
	 * @param columns idf节点
	 * @return  计算公式模型
	 */
	public RepeatCalculateModel getbinds(Element columns){
		RepeatCalculateModel repcal = new RepeatCalculateModel();
		List<Element> binds = columns.elements();//获取计算公式节点
		if(null!=binds && binds.size()>0){
			for(Element bind:binds){//循环处理每个计算公式
				String ref = bind.attributeValue("ref");//获取计算公式的源
				String calculate = bind.attributeValue("calculate");//获取计算公式的主体
				String calculatedata = calculate.replaceAll("\\(", "");//截取计算公式的计算元
				calculatedata = calculatedata.replaceAll("\\)", "");
				
				//编译成一个给定的正则表达式模式。
				Pattern pattern = Pattern.compile("\\+|-|\\*|\\/");
				//将this.calculate中所有的(或者)都替换成空值，然后分隔成字符串数组
				String[] matchers = pattern.split(calculate.replaceAll("\\(|\\)",
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
				repcal.setCal(set);
				repcal.setRef(ref);
				repcal.setCalculate(calculatedata);
			}
		}
	    return repcal;
	}
	/**
	 *   解析重复表本身的属性
	 * @param repeatt 重复表模型
	 * @param columns idf重复表节点
	 * @return        模型
	 */
	public RepeateTable getTableAtrr(RepeateTable repeatt,Element columns){
		if(columns.getName().equals("columns")){
			List<Element> colwdiths = columns.elements();
			if(null!=colwdiths){
				for(Element el:colwdiths ){
					String colwidth = el.element("colWidth").getText(); //行宽
					repeatt.setWidths(colwidth);
				}
			}
		}
		if (columns.getName().equals("rowHeight")) {
			String rowHeight = columns.getText();
			// 获取重复表重复域的行高
			repeatt.setRowHeight(rowHeight);
		}
		// 重复表行数
		if (columns.getName().equals("rowsNum")) {
			int tablerowcount = Integer.valueOf(columns.getText())-1;
			// 获取重复表的行数
			repeatt.setRowsNum(tablerowcount);
			repeatt.setDaterowsNum(tablerowcount);
		}
		// 重复表列数
		if (columns.getName().equals("colsNum")) {
			// 获取重复表的列数
			repeatt.setColsNum(Integer.valueOf(columns
					.getText()));
			repeatt.setDatecolsNum(Integer.valueOf(columns
					.getText()));
		}// end add
		return repeatt;
	}
	/**
	 * 解析重复表内的控件并生成String
	 * @param columns  重复表节点
	 * @param pxl      idf解析类
	 * @param repeatt  重复表模型
	 * @param tablerowcount  总行数
	 * @param tablename   重复表名称
	 * @return           重复表内的控件的css样式集合
	 * @throws Exception
	 */
	public List<String> getTableControls(Element columns,CssUntilParseXML pxl,RepeateTable repeatt,int tablerowcount,String tablename) throws Exception{
		List<String> arr = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		List<Element> listele = columns.elements();
		List<String> conlist = new ArrayList<String>();
		for (int cb = 0; cb < listele.size(); cb++) {
			Element columnlist = listele.get(cb);
			if (columnlist.getName().equals("column")) {
				List<Element> listcol = columnlist
				.elements();
				for (int ax = 0; ax < listcol.size(); ax++) {
					Element controls = listcol.get(ax);
					/**
					 * 重复表下面的controls
					 */
					
					if (controls.getName().equals(
					"controls")) {
						List<Element> listtablecontrols = controls
						.elements();
						
						for (int kk = 0; kk < listtablecontrols
						.size(); kk++) {
							Element tableele = listtablecontrols
							.get(kk);
							// 重复表下面的控件名称
							String namex = tableele.getName();
							String conname = tableele.attributeValue("name");//获取控件的iD
							repeatt.setConindex(conname);//将控件的ID添加到重复表的控件顺序中
							String convalue = tableele.attributeValue("value");//获取控件的iD
							conlist.add(convalue);
							if (null!=this.tablemap.get(tableele.getName())) {
								// add by sunjq
								// 将该控件添加到repeattableModel中
								pxl.getinput(tableele);
								if(tableele.getName().equals("dropList")){
									arr.add(pxl.getDm().getInputs().get(tableele.attributeValue("name")).getDroplm().getOptions().get(0).getText());
								}else{
									arr.add(pxl.getDm().getInputs().get(tableele.attributeValue("name")).getValue());
								}
								list.add(this.tablemap.get(namex).getStringCss(tableele));
								// end add
								//并不是所有的控件都可以在重复表内画，
							 if(null!=this.chongfutablemap.get(tableele.getName())){
								 for (int iinput = 1; iinput < tablerowcount; iinput++) {
										pxl.getinput(tableele);
										// 重复表内的控件（后加的控件样式）
										list.add(this.tablemap.get(namex).getStringCss(tableele,iinput,tablename));
									}
							 }
								//重复表的样式
								this.listcfb.add(this.tablemap.get(namex).getStringCss(tableele));
							} 
						}
						repeatt.getRep().put("0", conlist);
						repeatt.setIndex(1);
					}
				}
			}
		}
		return list;
	}
	
		public Map<String, CssUntilGetAllModel> getMap() {
		return tablemap;
		}
		public void setMap(Map<String, CssUntilGetAllModel> map) {
			this.tablemap = map;
		}
		public Map<String, String> getMapcol() {
		return mapcol;
	    }
	    public void setMapcol(Map<String, String> mapcol) {
		this.mapcol = mapcol;
	    }
		public Map<String, CssUntilGetAllModel> getTablemap() {
			return tablemap;
		}
		public void setTablemap(Map<String, CssUntilGetAllModel> tablemap) {
			this.tablemap = tablemap;
		}
		public Map<String, CssUntilGetAllModel> getChongfutablemap() {
			return chongfutablemap;
		}
		public void setChongfutablemap(Map<String, CssUntilGetAllModel> chongfutablemap) {
			this.chongfutablemap = chongfutablemap;
		}
		public List<String> getListcfb() {
			return listcfb;
		}
		public void setListcfb(List<String> listcfb) {
			this.listcfb = listcfb;
		}
}
