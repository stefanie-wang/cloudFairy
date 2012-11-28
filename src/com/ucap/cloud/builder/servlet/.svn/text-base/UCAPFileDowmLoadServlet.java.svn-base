/**<br>
 *  webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: UCAPFileDowmLoadServlet .java
 * @Package com.ucap.cloud.builder.servlet
 */
package com.ucap.cloud.builder.servlet;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.loader.DownLoadZipUtil;

/**
 * @author sunjq
 * <P>处理文件下载的Servlet</P>
 */
@SuppressWarnings({ "serial" })
public class UCAPFileDowmLoadServlet extends HttpServlet {


	private static Logger log = Logger.getLogger(UCAPFileDowmLoadServlet.class);
	
	public UCAPFileDowmLoadServlet() {
		// TODO Auto-generated constructor stub
	}
	

	// String FilePath="D:\\tomcat6\\webapps\\cloudFairy\\testidffoold";
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String FilePath = this.getServletContext().getRealPath("")
				+ "/testidffoold/";
		String type = request.getParameter("type");
		if(type!=null&&type.equals("userfile")){
			FilePath = this.getServletContext().getRealPath("")
				+ "/datafile/uploadfiles";
		}
		response.setContentType("text/html;charset=UTF-8");

		// 获得被选中的文件名
		String deffname = "ucaptemp";
		String[] ss = request.getParameterValues("checkbox");
		List<String> list=new ArrayList<String>();
		if(ss!=null&&ss.length>0){
			for (int i = 0; i < ss.length; i++){
				if(ss[i].equals("全选")){
					continue;
				}else{
				list.add(ss[i]);
				}
			}
			log.info(FilePath);
			File[] file4 = new File[list.size()];
			// 得到需要打包的文件数组
			for (int i = 0; i < list.size(); i++) {
				File file2 = new File(FilePath + "/" + list.get(i));
				log.info(file2.getName());
				file4[i] = file2;
			}
			DownLoadZipUtil down=(DownLoadZipUtil)SPRINGCONTEXT.getBean("downutil");
			//DownLoadZipUtil down = new DownLoadZipUtil();
			down.setResponse(response);
			down.setFilePath(FilePath);
			down.setTmpFileName(deffname + ".zip");
			// 如果只选中一个文件不需要打包，直接下载
			if (file4.length == 1) {
				down.downFilesim(file4[0].getName());
				log.info("========" + file4[0].getName() + "===========");
			} else {
				down.getZip(file4);
			}
		}else{
				RequestDispatcher rd = getServletContext()
				.getRequestDispatcher("/listIdf.jsp");
		        rd.forward(request, response);
		}
		
	}


	/* (非 Javadoc) 
	* <p>Title: doGet</p> 
	* <p>Description: </p> 
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException 
	* @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//下载帮助文档
		String name=request.getParameter("name");
		if("helps".equals(name)){
			DownLoadZipUtil down=(DownLoadZipUtil)SPRINGCONTEXT.getBean("downutil");
			String FilePath = this.getServletContext().getRealPath("")+ "/helps/";
			File file=new File(FilePath);
			down.setResponse(response);
			down.setFilePath(file.getPath());
			down.downFilesim("表单产品新版本用户手册.pdf");
		}
	}

}
