/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: UCAPFileUpLoadServlet .java
 * @Package com.ucap.cloud.builder.servlet
 */
package com.ucap.cloud.builder.servlet;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.ucap.cloud.builder.loader.DownLoadZipUtil;
import com.ucap.cloud.builder.loader.RarUtil;
import com.ucap.cloud.builder.loader.UpLoadZipUtil;
import com.ucap.cloud.business.formserver.cssmanager.css.until.CreatJsp;

/**
 * @author sunjq
 *         <P>
 *         处理文件上传的Servlet
 *         </P>
 */
@SuppressWarnings({ "serial", "unused" })
public class UCAPFileUpLoadServlet extends HttpServlet {

	static private Logger log = Logger.getLogger(UCAPFileUpLoadServlet.class);

	public UCAPFileUpLoadServlet() {
		// TODO Auto-generated constructor stub
	}

	// 指定接收上传文件的目录
	private String upDir;

	public void setUpDir(String upDir) {
		this.upDir = upDir;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 设置编码格式
		response.setContentType("text/html;charset=UTF-8");
		this.setUpDir("/testidffoold");
		// 定义接收上传的目录
		String uploadDir = getServletContext().getRealPath(upDir);
		String realpath = getServletContext().getRealPath("");
		request.setAttribute("realpath", realpath);
		String radio = "";  //记录页面单选框选择表单类型
		String idfType = ""; //记录发布表单的类型
		
		List<String> zdusers = new ArrayList<String>();//记录指定的用户集合
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fu = new ServletFileUpload(factory);
		
		// 最大上传20M数据
		fu.setSizeMax(1024 * 1024 * 20);
		fu.setHeaderEncoding("UTF-8");
		List fileItems = null;
		String fieldName = "";
		String[] xmlpaths = new String[1];
		// 解析request
		try {
			fileItems = fu.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (null != fileItems && fileItems.size() > 0) {

			// TODO Auto-generated catch block
			for (int i = 0; i < fileItems.size(); i++) {
				FileItem fi = (FileItem) fileItems.get(i);
                if(fi.isFormField()){//判断页面数据是否为上传文件
                	if(fi.getFieldName().toString().equals("DropList1_ucap")){//判断是否为多选下拉框列表，代表选择的用户
                		String listUser = fi.getString();
                		String[] ss = listUser.split(";");
                		for(String s:ss){
                			if(!s.equals("")){
                				zdusers.add(s);
                			}
                		}
                	}
                    if(fi.getFieldName().toString().equals("RadioGroup1")){//判断是否为单选框，表示表单类型
                    	radio = fi.getString();//获取单选框的值
                	    if(radio.equals("1")){//依据单选框的值判断发布表单的类型
                	    	idfType = "zhiding";
                	    }else{
                	    	idfType = "niming";
                	    }
                	}
                }else{
                	// 获得上传文件的完整路径
    				String strpath = fi.getName();
    				if (null != strpath && !"".equals(strpath)) {

    					log.info(strpath);
    					int start = strpath.lastIndexOf("\\");
    					// 获取上传文件名
    					String filename = strpath.substring(start + 1);

    					File pathDest = new File(uploadDir, filename);
    					request.setAttribute("filename", uploadDir + "/"
    							+ filename);
    					// 写入文件
    					try {
    						fi.write(pathDest);
    					} catch (Exception e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    					
    					// by piao  判断文件类型
    					FileType ft = new FileType();
    					File f = new File(uploadDir + "/"
    							+ filename);
    					// 获取文件类型
    				    String fileType = ft.getFileByFile(f); 
    				    // end piao
    					// 如果为zip就解压
    					if (fileType.equals("zip")) {
    						UpLoadZipUtil zipu = (UpLoadZipUtil) SPRINGCONTEXT
    								.getBean("uputil");
    						String afterzip = zipu.upzip1(pathDest.getAbsolutePath(),uploadDir);
    						request.setAttribute("filename", afterzip);
    					}
    					if (fileType.equals("rar")) {
    						RarUtil raru = new RarUtil();
    						raru.uprar(pathDest.getAbsolutePath(), uploadDir);
    						log.info("=====================Rar成功i++++++++++++++++++");
    					}
    					// 上传文件完成，开始解析IDF文件
        				CreatJsp creatjsp = new CreatJsp();
        				creatjsp.setIdfType(idfType);//将表单类型带入解析工具
        				creatjsp.setZdusers(zdusers);//将指定用户列表带入解析工具
        				creatjsp.doGet(request, response);
    				} else{
    					RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/listIdf.jsp");
				        rd.forward(request, response);
    				}
    				
                }
				
			}
			
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req,resp);
	}
	
	

}
