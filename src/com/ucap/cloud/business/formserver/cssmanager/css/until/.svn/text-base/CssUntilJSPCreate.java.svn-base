/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssUntilJSPCreate.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until
 */
package com.ucap.cloud.business.formserver.cssmanager.css.until;

/**
 * 
 */


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @ClassName CssUntilJSPCreate
 * @Description TODO 通过xslt与Idf文件生成jsp
 * @author yxk
 * @date 2012-8-10
 */
public class CssUntilJSPCreate {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 
	 */
	public CssUntilJSPCreate() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @Title: creatJsp 
	 * @Description: TODO
	 * @param @param xsltpath XSLT文件的路径
	 * @param @param xmlpath  改表单文件的路径
	 * @param @param jsppath  生成JSP的路径
	 * @return String   返回JSP页面的内容
	 * @throws 
	 */
	static public String creatJsp(String xsltpath, String xmlpath, String jsppath) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		String str = null;
		if(null!=xsltpath && null!=xmlpath  && null!=jsppath  ){


			try {
				// 得到 DocumentBuilder 对象
				DocumentBuilder db = dbf.newDocumentBuilder();
				// 加载 test.xml，并将其转换为 Document 对象"WebRoot/xml/usermessage.xml"
				ByteArrayInputStream in = new ByteArrayInputStream(xmlpath.getBytes("UTF-8"));
				Document doc = db.parse(new InputSource(in));
				// 实例 DOMSource 对象
				DOMSource source = new DOMSource(doc);
				// 输出结果，并定义结果输出路径"WebRoot/jsp/userMessage.jsp"
				//			StreamResult result = new StreamResult(new File(jsppath));
				// 加载 xsl 文件"WebRoot/xml/userMessage.xsl"
				StreamSource ss = new StreamSource(new File(xsltpath));
				// 实例化 TransformerFactory 对象
				TransformerFactory tff = TransformerFactory.newInstance();
				Transformer tf = tff.newTransformer(ss);
				// 定义写个字符串
				StringWriter sw = new StringWriter();
				Result resulted = new StreamResult(sw);
				// 设定字符编码方式
				tf.setOutputProperty("encoding", "UTF-8");
				// 将定义好的 .xsl 格式 转换
				//			tf.transform(source, result);

				tf.transform(source, resulted);

				// 将结果写为一个字符串，然后打印在控制台上
				str = "<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"UTF-8\"%>"
					+ "<%@ taglib uri=\"form_pro\"  prefix=\"ucap\"%>"
					+ sw.toString();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
			return str;
		}else{
			str = "<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"UTF-8\"%>"
					+ "<%@ taglib uri=\"form_pro\"  prefix=\"ucap\"%>";
			return str;
		}
	}
	static public String creattableJsp(String xsltpath, String xmlpath, String jsppath) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		String str = null;
		if(null!=xsltpath && null!=xmlpath  && null!=jsppath  ){


			try {
				// 得到 DocumentBuilder 对象
				DocumentBuilder db = dbf.newDocumentBuilder();
				// 加载 test.xml，并将其转换为 Document 对象"WebRoot/xml/usermessage.xml"
				ByteArrayInputStream in = new ByteArrayInputStream(xmlpath.getBytes("UTF-8"));
				Document doc = db.parse(new InputSource(in));
				// 实例 DOMSource 对象
				DOMSource source = new DOMSource(doc);
				// 输出结果，并定义结果输出路径"WebRoot/jsp/userMessage.jsp"
				//			StreamResult result = new StreamResult(new File(jsppath));
				// 加载 xsl 文件"WebRoot/xml/userMessage.xsl"
				StreamSource ss = new StreamSource(new File(xsltpath));
				// 实例化 TransformerFactory 对象
				TransformerFactory tff = TransformerFactory.newInstance();
				Transformer tf = tff.newTransformer(ss);
				// 定义写个字符串
				StringWriter sw = new StringWriter();
				Result resulted = new StreamResult(sw);
				// 设定字符编码方式
				tf.setOutputProperty("encoding", "UTF-8");
				// 将定义好的 .xsl 格式 转换
				//			tf.transform(source, result);
				tf.transform(source, resulted);

				// 将结果写为一个字符串，然后打印在控制台上
				str = "<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"utf-8\"%>"
					+ "<%@ taglib uri=\"form_pro\"  prefix=\"ucap\"%>"
					+ sw.toString();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
			return str;
		}else{
			str = "<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"utf-8\"%>"
					+ "<%@ taglib uri=\"form_pro\"  prefix=\"ucap\"%>";
			return str;
		}
	}




}
