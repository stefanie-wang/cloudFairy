/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: JspCreate_util.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until
 */
package com.ucap.cloud.business.formserver.cssmanager.css.until;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ucap.cloud.builder.cache.util.CreateCaches;
import com.ucap.cloud.builder.util.Jsonparse;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.IdfMessage;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.IdfUserModel;
import com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate.GetCssFileDateGetSortCss;
import com.ucap.cloud.business.formserver.data.initdata.InitIdfData;
import com.ucap.cloud.business.formserver.data.model.AllNiMingIdfModel;
import com.ucap.cloud.business.formserver.data.model.NiMingIdfModel;

/**
 * @author yxk
 *         <P>
 *         处理IDF文件的解析
 *         </P>
 */
public class JspCreate_util implements Runnable {

	static private Logger log = Logger.getLogger(JspCreate_util.class);

	public static SAXReader getreader() {
		SAXReader reader = new SAXReader();
		try {
			reader
					.setFeature(
							"http://apache.org/xml/features/nonvalidating/load-external-dtd",
							false);
			return reader;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * <P>
	 * 处理IDF文件的解析
	 * </P>
	 */
	public JspCreate_util() {
		// TODO Auto-generated constructor stub
		log.info("loader" + this.getClass());
	}
    public JspCreate_util(String tablepath,String filename,String xslt,String xslt1,String xmlpath,String path){
    	this.tablepath = tablepath;
    	this.filename = filename;
    	this.xslt = xslt;
    	this.xslt1 = xslt1;
    	this.xmlpath = xmlpath;
    	this.path = path;
//    	this.px =px;
    }
	// private static Logger logger = Logger.getLogger(JspCreate_util.class);

	public void run() {
		// TODO Auto-generated method stub
		this.doit();
	}

	private String userid;
	
	/** 
	* @Fields zdusers : 保存指定发布表单的用户列表
	*/
	private List<String> zdusers = new ArrayList<String>();
	
	
	public List<String> getZdusers() {
		return zdusers;
	}

	public void setZdusers(List<String> zdusers) {
		this.zdusers = zdusers;
	}

	/** 
	* @Fields idfType : 表示idf文件的类型
	*/
	private String idfType ="";

	public String getIdfType() {
		return idfType;
	}

	public void setIdfType(String idfType) {
		this.idfType = idfType;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	/** 
	* @Fields blockxslt : 重复块生成弹出页面的xslt
	*/
	private String blockxslt = "";
	
	
	public String getBlockxslt() {
		return blockxslt;
	}

	public void setBlockxslt(String blockxslt) {
		this.blockxslt = blockxslt;
	}

	private String xslt1 = "";
	/**
	 * @Fields filename : 发布的表单的名
	 */
	private String filename;

	/**
	 * @Fields path : TODO
	 */
	private String path;

	/**
	 * @Fields xmlpath : 发布表单的文件路径
	 */
	private String xmlpath;

	/**
	 * @Fields xslt : 系统中XSLT文件的路径
	 */
	private String xslt;

	private Jsonparse jp;

	private CreateCaches cache;

	/**
	 * @Fields px : 表单解析工具类
	 */
	private CssUntilParseXML px;

	/**
	 * @Fields tablepath : 重复表填报数据点击新弹出页面的路径
	 */
	private String tablepath = "";

	private GetCssFileDateGetSortCss gcc;

	public GetCssFileDateGetSortCss getGcc() {
		return gcc;
	}

	public String getXslt1() {
		return xslt1;
	}

	public void setXslt1(String xslt1) {
		this.xslt1 = xslt1;
	}

	public void setGcc(GetCssFileDateGetSortCss gcc) {
		this.gcc = gcc;
	}

	/**
	 * @Title: doit
	 * @Description: <p>
	 *               将表单转换JSP，生成对应的页面的CSS，将表单信息放入缓存中
	 *               </p>
	 * @param
	 * @return void
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public void doit() {
		this.init();
		px.setIdfname(filename);
		// 文件名称
		List<String> lists = new ArrayList<String>();
		// jsp名称
		List<String> listjsp = new ArrayList<String>();
		// idf原始模型
		String csname = "";
		// css文件名称集合
		List<String> cssfilename = new ArrayList<String>();
		if (null != cache ) {
			// 用于生成文件的集合
			List<Map<String, String>> listm = new ArrayList<Map<String, String>>();
			try {
				Document doc = getreader().read(new File(xmlpath));// 读取节点
				
				Element e = doc.getRootElement();
				// 总文件
				List<Element> listpage = (List<Element>) doc
						.selectNodes("//uformdoc/formdoc/uform/form/pages/page");
				lists = this.getJspName(listpage);
				for (int i = 0; i < listpage.size(); i++) {
					Map<String, String> map1 = new HashMap<String, String>();
					// page 节点
					Element e1 = listpage.get(i);
					// 将element对象转为String
					String start = this.getJsp(e1);
					// 生成jsp内容
					String jsp1 = CssUntilJSPCreate.creatJsp(xslt, start
							.toString(), "");
					// jsp内容 和jsp要存放的路径
					map1.put(jsp1, path + "/formjsp/" + filename + i + ".jsp");
					listjsp.add(filename + i + ".jsp");
					listm.add(map1);
				}
				CssUntilfinelPath.CSSPATH = path + "/xml/cssModel.xml";
				// 中文转换
				csname = this.getFileNmae(filename);
				// 获得总的css
				List<String> list = px.getCssString(e);// 包括计算公式和校验
				// css名称和css样式内容
				Map<String, String> map = this.createCss(list, csname);
				// 生成css样式表名称的集合
				cssfilename = this.getCssName(list, csname);
				listm.add(map);
				listm.addAll(this.gettableJsp());
				Thread t = new Thread(new CssUntilFileOut(listm));
				t.start();
				log.info("JSP生成结束" + new Date());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			px.getDm().bindCalculate();
			px.getDm().setCssname(filename, cssfilename);
			Document doc = null;
			try {
				doc = getreader().read(new File(xmlpath));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 读取节点
			InitIdfData intf = new InitIdfData();
			intf.setDm(px.getDm());
			intf.getData(doc);
			// 赋值
			IdfMessage idf = new IdfMessage(filename,px.getDm(),lists,listjsp);
			idf.setRoles(px.getRoles());
			IdfUserModel user = (IdfUserModel) this.cache.getVluae(userid);
			if (null == user) {
				user = new IdfUserModel();
				user.setUserid(userid);
			}
		  //此处操作是处理匿名表单的发布
			if(idfType.equals("niming")){//如果是匿名表单
				
				NiMingIdfModel nm = new NiMingIdfModel();//新建匿名表单的模型
				
				Jsonparse jp = (Jsonparse) SPRINGCONTEXT.getBean("createJson");
//				idf.getDmj().setBarcodes(idf.getDm().getBarcodes());
//				idf.getDmj().setCompMap(idf.getDm().getCompMap());
//				idf.getDmj().setInputs(idf.getDm().getInputs());
//				idf.getDmj().setRepeatBlock(idf.getDm().getRepeatBlock());
//				idf.getDmj().setRepeattable(idf.getDm().getRepeattable());
				idf.setJson(jp.getJSON(idf.getDm()));
				nm.setIdfmesg(idf);//将表单的模型保存，作为原始的IDF信息
				AllNiMingIdfModel allnm = (AllNiMingIdfModel)this.cache.getVluae("allNiMingIdf");
				if(allnm==null){
					allnm = new AllNiMingIdfModel();
				}
				allnm.setAllIdf(filename, nm);
				this.cache.putElement("allNiMingIdf", allnm);//将匿名表单放入缓存中
			}else{
				//add by sunjq  此处添加操作是处理指定用户发布的表单
			    if(zdusers.size()>0 && zdusers!=null){
			    	  for(String ss:zdusers){//循环处理指定的用户
					    	IdfUserModel user1 = (IdfUserModel) this.cache.getVluae(ss);//在缓存中依据用户ID获取模型
							if (null == user1) {//如果依据ID获取不到模型，就新建一个模型
								user1 = new IdfUserModel();
								user1.setUserid(ss);
							}			
							try {
								IdfMessage idf1 = (IdfMessage)idf.clone();//将表单模型复制一份，放入指定用户模型中
								user1.setIdfmessage(filename, idf1);
							} catch (CloneNotSupportedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							this.cache.putElement(ss, user1);//将指定用户模型放入缓存中
					  }
			    }
			    user.setIdfmessage(filename, idf);//将表单信息放入用户信息
				   // this.cache.putElement(filename, idf);
				this.cache.putElement(userid, user);//将用户及表单信息放入缓存中
			}
			
			

		}
	}

	/**
	 * 生成css样式表名称的集合
	 * 
	 * @param list
	 *            css样式总和
	 * @param csname
	 *            css文件名称
	 * @return 返回css样式名称集合
	 */
	public List<String> getCssName(List<String> list, String csname) {
		List<String> list1 = new ArrayList<String>();
		int countlength = list.size();
		int k = countlength / 1500;// 分的次数
		int x = countlength % 1500;// 取余
		if (k > 0 && x != 0) {
			for (int i = 0; i < k + 1; i++) {
				String name = csname + i;
				list1.add(name);
			}
		} else {
			list1.add(csname);
		}
		return list1;
	}

	/**
	 * css名称和css样式内容
	 * 
	 * @param list
	 *            css样式总和
	 * @param csname
	 *            css名称
	 * @return css名称和css样式内容
	 */
	public Map<String, String> createCss(List<String> list, String csname) {
		int countlength = list.size();
		Map<String, String> map = new HashMap<String, String>();
		int k = countlength / 1500;// 分的次数
		int x = countlength % 1500;// 取余
		StringBuffer sb = new StringBuffer();
		if (k > 0) {
			for (int ii = 1; ii < k + 1; ii++) {
				StringBuffer sb1 = new StringBuffer();
				for (int i = (ii - 1) * 1500; i < ii * 1500; i++) {
					sb1.append(list.get(i));
				}
				// css生成路径
				map.put(sb1.toString(), path + "/formcss/" + csname + (ii - 1)
						+ "_All_class.css");
			}
		} else {
			for (int i = 0; i < countlength; i++) {
				sb.append(list.get(i));
			}
			map.put(sb.toString(), path + "/formcss/" + csname
					+ "_All_class.css");
		}
		if (k > 0 && x != 0) {
			StringBuffer sb1 = new StringBuffer();
			for (int i = 1500 * k; i < countlength; i++) {
				sb1.append(list.get(i));
			}
			map.put(sb1.toString(), path + "/formcss/" + csname + (k)
					+ "_All_class.css");
		}
		return map;
	}
	/**
	 * 
	 * @param e1  重复块或者重复表节点
	 * @return  以重复块或者重复表为节点生成一个字符串
	 */
	public List<Map<String, String>> gettableJsp() {
		//返回值 Map内是生成字符串的内容和要生成的地址
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 要处理的重复表或者是重复块集合
		List<Map<String,Element>> listmap = px.getListtableorrepat();
		for(int i=0;i<listmap.size();i++){
			if(listmap.get(i).get("table")!=null){  
				//返回值 Map内是生成字符串的内容和要生成的地址
				Map<String,String> maps = new HashMap<String, String>();
				//获取重复表名称
				String tablename = this.getTablename(listmap.get(i).get("table"));
				//获取该重复表与XSLt解析后的jsp字符串
				String jsp1 = this.getTableorReJSp(listmap.get(i).get("table"));
				//内容 与地址
				maps.put(jsp1, px.getTablejsppath()+"/"+this.filename.hashCode()+""+"_"+tablename+".jsp");
				list.add(maps);
			}
			if(listmap.get(i).get("repeatUnit")!=null){
				Map<String,String> maps = new HashMap<String, String>();
				String jsp1 = this.getBlockJSp(listmap.get(i).get("repeatUnit"));
				maps.put(jsp1, px.getTablejsppath()+"/"+this.filename.hashCode()+""+"_"+listmap.get(i).get("repeatUnit").attributeValue("name")+".jsp");
				list.add(maps);
			}
		}
		
		return list;
	}
	/**
	 * 获得重复表名称
	 * @param e 重复表的节点
	 * @return  重复表名称
	 */
	public String getTablename(Element e){
		
		 String s =  "";
		List<Element> list = e.elements();
		for(int i=0;i<list.size();i++){
			 if(list.get(i).getName().equals("name")){
				s = list.get(i).getText();
			 }
		}
		return s;
	}
	/**
	 * 
	 * @return  IDF与XSLT生成jsp串
	 */
	public String getTableorReJSp(Element e){
		String jsp = "";
		if(e!=null){
			StringBuilder start = new StringBuilder();
			start.append(CssUntilfinelPath.TABLEXMLSTART);
			start.append(e.asXML());
			start.append(CssUntilfinelPath.TABLEXMLEND);
		    jsp = CssUntilJSPCreate.creattableJsp(xslt1, start
					.toString(), "");
		}
		return jsp;
	}
	public String getBlockJSp(Element e){
		String jsp = "";
		if(e!=null){
			StringBuilder start = new StringBuilder();
			start.append(CssUntilfinelPath.TABLEXMLSTART);
			start.append(e.asXML());
			start.append(CssUntilfinelPath.TABLEXMLEND);
		    jsp = CssUntilJSPCreate.creattableJsp(blockxslt, start
					.toString(), "");
		}
		return jsp;
	}
	/**
	 * 将element转变为string
	 * 
	 * @param e1
	 *            每一个page节点
	 * @return 返回e1节点内容 用字符串显示
	 */
	public String getJsp(Element e1) {
		// page 节点
		StringBuilder start = new StringBuilder();
		start.append(CssUntilfinelPath.XMLFORMATSTAR);
		start.append(e1.asXML());
		start.append(CssUntilfinelPath.XMLFORMATEND);
		return start.toString();
	}

	/**
	 * 处理css样式文件名称中文问题 ，中文名称无法引入
	 * 
	 * @param filename
	 *            要处理的文件名称
	 * @return 返回处理完成的名称
	 */
	public String getFileNmae(String filename) {
		String csname = "";
		if (filename != null) {
			// 处理中文字符
			if (filename.getBytes().length != filename.length()) {
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String str = format.format(date);
				csname = str;
			} else {
				csname = filename;
			}
			return csname;
		} else {
			return "";
		}
	}

	/**
	 * 处理idf所以的page节点
	 * 
	 * @param listpage
	 *            解析出来的page集合
	 * @return 返回所有的page名字
	 */
	public List<String> getJspName(List<Element> listpage) {
		List<String> list = new ArrayList<String>();
		String pagename = "";
		if (listpage != null && listpage.size() > 0) {
			for (int i = 0; i < listpage.size(); i++) {
				Element e1 = listpage.get(i);
				List<Element> liste = e1.elements();
				for (int j = 0; j < liste.size(); j++) {
					if (liste.get(j).getName().equals("extras")) {
						pagename = liste.get(j).attributeValue("pageName");
						list.add(pagename);
					}
				}
			}
		}
		return list;
	}
	/**
	 * 专门处理重复表的jsp生成
	 * 
	 * @return map中是jsp名称和jsp内容
	 */
	@SuppressWarnings("unchecked")
	public String ceeatetablejsp() {
		String jsp1 = "";
		try {
			Document doc = getreader().read(new File(xmlpath));
			// 总文件
			List<Element> listpage = (List<Element>) doc
					.selectNodes("//uformdoc/formdoc/uform/form/pages/page/controls/table");
			for (int i = 0; i < listpage.size(); i++) {
				// page 节点
				Element e1 = listpage.get(i);
				String start = this.getJsp(e1);
				jsp1 = CssUntilJSPCreate.creatJsp(xslt, start.toString(), "");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// logger.info(e.getMessage());
		}
		return jsp1;
	}
	/**
	 *  初始化赋值
	 */
  public void init(){
	    px.setTablejsppath(this.tablepath);
		px.setXmlpath(this.xmlpath);
		px.setXslt(this.xslt1);
		px.setTablexslt(this.xslt1);
  }
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getXmlpath() {
		return xmlpath;
	}

	public void setXmlpath(String xmlpath) {
		this.xmlpath = xmlpath;
	}

	public String getXslt() {
		return xslt;
	}

	public void setXslt(String xslt) {
		this.xslt = xslt;
	}

	public Jsonparse getJp() {
		return jp;
	}

	public void setJp(Jsonparse jp) {
		this.jp = jp;
	}

	public CreateCaches getCache() {
		return cache;
	}

	public void setCache(CreateCaches cache) {
		this.cache = cache;
	}

	public CssUntilParseXML getPx() {
		return px;
	}

	public void setPx(CssUntilParseXML px) {
		this.px = px;
	}

	public String getTablepath() {
		return tablepath;
	}

	public void setTablepath(String tablepath) {
		this.tablepath = tablepath;
	}

}
