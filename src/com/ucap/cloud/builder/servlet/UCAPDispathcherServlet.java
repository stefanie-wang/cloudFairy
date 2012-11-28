/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: UCAPDispathcherServlet .java
 * @Package com.ucap.cloud.builder.servlet
 */
package com.ucap.cloud.builder.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;

/**
 * @author yxk
 *         <p>
 *         重新spring加载器目的为在系统启动的同时将spring环境备份一份进而为webservice服务提供spring环境支持
 *         </p>
 */
@SuppressWarnings("serial")
public class UCAPDispathcherServlet extends GenericServlet {

	/**
	 * 
	 */
	public UCAPDispathcherServlet() {
		// TODO Auto-generated constructor stub
	}

	private static String MAINCONTEXTPATH = "/com/ucap/cloud/builder/config/applicationContext_all.xml";

	static public WebApplicationContext SPRINGCONTEXT;
	
	public void init()
	{
		ServletContext context = this.getServletContext();
		SPRINGCONTEXT = (WebApplicationContext) context.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC");
		System.out.println(SPRINGCONTEXT);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		// super.init(config);
//		// ServletContext context = config.getServletContext();
//		// SPRINGCONTEXT = (ApplicationContext)
//		// context.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC");
//		// // org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC
//
//		this.getAllContextPath(config);
//		StringBuilder sb = new StringBuilder("");
//		for (String s : this.loader) {
//			sb.append(this.contextmap.get(s)).append(",");
//		}
//		sb.append(this.getClass().getClassLoader().getResource(MAINCONTEXTPATH)
//				.getFile());
//		if (this.loader.length == 0) {
//			SPRINGCONTEXT = new FileSystemXmlApplicationContext(sb.toString()
//					.split(MAINCONTEXTPATH));
//		} else {
//			SPRINGCONTEXT = new FileSystemXmlApplicationContext(sb.toString()
//					.split(","));
//		}
//		config
//				.getServletContext()
//				.setAttribute(
//						"org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC",
//						SPRINGCONTEXT);
//		// System.out.println("------------"+(ApplicationContext)
//		// config.getServletContext().getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC"));
//	}
//
//	private Map<String, String> contextmap = new HashMap<String, String>();
//
//	private String[] loader = new String[0];
//
//	private void getAllContextPath(ServletConfig config) {
//		String xmlpath = this.getClass().getClassLoader().getResource(
//				config.getInitParameter("contextConfigLocation")).getFile();
//
//		SAXReader reader = new SAXReader();
//		try {
//			Document doc = reader.read(new File((xmlpath)));
//
//			List<Element> spring = doc.getRootElement().element(
//					"springcontexts").elements();
//			String loaderstr = doc.getRootElement().element("loader").element(
//					"springcontext").attributeValue("ref");
//			if (null != loaderstr && !("".equals(loaderstr))) {
//				loader = loaderstr.split(",");
//			}
//			for (Element e : spring) {
//				String kpath = e.attributeValue("path");
//				String key = e.attributeValue("id");
//				String contextpath = this.getClass().getClassLoader()
//						.getResource(kpath).getFile();
//				this.contextmap.put(key, contextpath);
//			}
//
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
