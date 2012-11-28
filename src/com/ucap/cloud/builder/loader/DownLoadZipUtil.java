/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DownLoadZipUtil .java
 * @Package om.ucap.cloud.builder.loader
 */
package com.ucap.cloud.builder.loader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * @author sunjq
 *<P>处理文件下载的工具类</P>
 */
public class DownLoadZipUtil {

	@SuppressWarnings("unused")
	private static Logger  log = Logger.getLogger(DownLoadZipUtil.class);
	/**
	 * 选择多个文件的时候打包下载IDF文件的工具类
	 */
	public DownLoadZipUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 打包的下载的文件名
	 */
	String tmpFileName;
	/**
	 * 定义的原始目录
	 */
	String FilePath;
	/**
	 * 响应请求的response
	 */
	HttpServletResponse response;
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setTmpFileName(String tmpFileName) {
		this.tmpFileName = tmpFileName;
	}

	public void setFilePath(String filePath) {
		FilePath = filePath;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 
	* @Title: getZip 
	* @Description: TODO
	* <p>处理文件下载</p>
	* @param @param files 要下载的文件集合
	* @param @return 
	* @param @throws IOException     
	* @return   
	* @throws
	 */
	public void getZip(File[] files ) throws IOException{
		 
        byte[] buffer = new byte[1024*8];
        //设置下载文件的路径
        String strZipPath = FilePath + tmpFileName;   
        try {   
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(   
                    strZipPath));                                         
            for (int i = 0; i < files.length; i++) {  //循环处理没个文件 
                FileInputStream fis = new FileInputStream(files[i]);   
                out.putNextEntry(new ZipEntry(files[i].getName()));   
                	                 
                int len;   
                // 读入需要下载的文件的内容，打包到zip文件   
                while ((len = fis.read(buffer)) > 0) {   
                    out.write(buffer, 0, len);   
                }   
                out.closeEntry(); //将内容输出  
                fis.close();   //关闭流
            }   
            out.close();   
            this.downFile( tmpFileName);   
        } catch (Exception e) {   
               
        }		   
        
    }   
       		       	  
    /**  
     * 下载打包文件  		      
     * @param str 压缩文件名 
     */  
    public void downFile( String str) {   
        try { 
        	String downLoadName = java.net.URLEncoder.encode(str, "UTF-8");
            String path = FilePath  +str;
            
            File file = new File(path);              
			if (file.exists()) {
				
                InputStream ins = new FileInputStream(path);   
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面   
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流   
                BufferedOutputStream bouts = new BufferedOutputStream(outs);   
                response.setContentType("application/x-download");// 设置response内容的类型 
                response.setHeader("Content-disposition", "attachment;filename="+ downLoadName );  // 设置头部信息  
                int bytesRead = 0;   
                byte[] buffer = new byte[8192];   
               // 开始向网络传输文件流   
               while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {   
                    bouts.write(buffer, 0, bytesRead);   
                }   
                bouts.flush();// 
                ins.close();   
                bins.close();   
                outs.close();   
                bouts.close(); 
                file.delete();
            } else {   
               
            }   
        } catch (IOException e) {   
              
        }   

	}
    /**  
     * 下载单独文件	      
     * @param str 文件名 
     */ 
    public void downFilesim( String str) {   
        try { 
        	String downLoadName = java.net.URLEncoder.encode(str, "UTF-8");
            String path = FilePath+"/"+str;
            
            File file = new File(path);              
			if (file.exists()) {
				
                InputStream ins = new FileInputStream(path);   
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面   
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流   
                BufferedOutputStream bouts = new BufferedOutputStream(outs);   
                response.setContentType("application/x-download");// 设置response内容的类型 
                response.setHeader("Content-disposition", "attachment;filename="+ downLoadName );  // 设置头部信息  
                int bytesRead = 0;   
                byte[] buffer = new byte[8192];   
               // 开始向网络传输文件流   
               while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {   
                    bouts.write(buffer, 0, bytesRead);   
                }   
                bouts.flush();// 
                ins.close();   
                bins.close();   
                outs.close();   
                bouts.close(); 
                
            } 
        } catch (IOException e) {   
              
        }   

	}

}
