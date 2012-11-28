/**
 * 
 */
package com.ucap.cloud.builder.servlet;



import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;
import java.io.IOException;
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

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ucap.cloud.builder.cache.util.CreateCaches;
import com.ucap.cloud.business.formserver.compute.ComputerImpl;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.IdfMessage;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.IdfUserModel;
import com.ucap.cloud.business.formserver.data.initdata.InitUserData;
import com.ucap.cloud.business.formserver.data.model.DataModel;



/**
 * @author sunjq
 *
 */
@SuppressWarnings("serial")
public class UserDataUpLoard extends HttpServlet {

	/**
	 * 上传数据文件
	 */
	public UserDataUpLoard() {
		// TODO Auto-generated constructor stub
	}
	
	 private String upDir;
		
	    public void setUpDir(String upDir) {
			this.upDir = upDir;
		}

		@SuppressWarnings("unchecked")
		public void doPost(HttpServletRequest request,HttpServletResponse response)
		
		    throws ServletException,IOException{
			
			response.setContentType("text/html;charset=UTF-8");
			this.setUpDir("/datafile");
			//定义接收上传的目录
			String uploadDir=getServletContext().getRealPath(upDir);
			
			String datafilepath="";
			
			DiskFileItemFactory factory=new  DiskFileItemFactory();
			ServletFileUpload fu=new ServletFileUpload(factory);		
			//最大上传20M数据
			fu.setSizeMax(1024*1024*20);			
			fu.setHeaderEncoding("UTF-8");
			List fileItems = null;
			//String fieldName="";
			//解析request				
				try {
					fileItems=fu.parseRequest(request);
				} catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	  
				// TODO Auto-generated catch block			
			    for(int i=0;i<fileItems.size();i++){		    			    	
				    FileItem fi=(FileItem)fileItems.get(i);
				    
				    //获得上传文件的完整路径
				    String strpath=fi.getName();				   
					int start=strpath.lastIndexOf("\\");
					        //获取上传文件名
					String filename=strpath.substring(start+1);
					
					datafilepath=uploadDir+"\\"+filename;
					       
					File pathDest=new File(uploadDir,filename);
					        //写入文件 
					        try {
						    fi.write(pathDest);
					        } catch (Exception e) {
						    // TODO Auto-generated catch block
						    e.printStackTrace();
					        }					        					      					      			      
			     }
			    /*
			     * 上传完毕
			     * 开始处理数据解析绑定	     
			    */
			    
			    
			   /* SAXReader reader = new SAXReader();
			    try {
			    	//解析上传的数据文件
					Document doc = reader.read(new File(datafilepath));
					//得到对应的数据节点
					List<Element> es  =(List<Element>) doc.selectNodes("//data/TBL_OS_ITEM/date");
					
					System.out.println(es.toString());
					//得到用户名
					String userid = (String)request.getSession().getAttribute("useid");
					
					CreateCaches cc = (CreateCaches)SPRINGCONTEXT.getBean("ucapcache");
					
					String idfname= "userdata";
					*//**
					 * 根据用户名和idfname得到用户的IdfUserModel
					 *//*
					IdfUserModel usermsg = (IdfUserModel) cc.getVluae(userid+idfname);
					//根据idfname得到对应的IdfMessage
					IdfMessage idfmsg=usermsg.getIdfmessage(idfname);
					
					DataModel dm = idfmsg.getDm();
					
					System.out.println(dm.getInputs());
					
					InitUserData inu=new InitUserData(dm);
					//将Dm与数据文件初始化
					dm=inu.initdm(es);
					
					ComputerImpl comp=new ComputerImpl();
					
					comp.setDm(dm);
					//计算
					dm=comp.computer();
					
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			  
			    
			    RequestDispatcher rd=getServletContext().getRequestDispatcher("/selectdata.jsp");
				 rd.forward(request, response); 
			 
		}

}
