/**<br>
 *  webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: UpLoadZipUtil .java
 * @Package com.ucap.cloud.builder.loader
 */
package com.ucap.cloud.builder.loader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;
import org.apache.tools.*;
/**
 * @author sunjq
 *<P>处理上传文件的工具类</P>
 */
@SuppressWarnings("unused")
public class UpLoadZipUtil {
	private org.apache.tools.zip.ZipFile zipFile;
	private ZipOutputStream zipOut; // 压缩Zip
	private ZipEntry zipEntry;
	private static int bufSize = 512; // size of bytes
	private byte[] buf = new byte [512];
	private int readedBytes = 512;

	private static Logger log = Logger.getLogger(UpLoadZipUtil.class);
	@SuppressWarnings("unchecked")
	public void upzip(String zipFileName, String outputDir) throws IOException {

	    try {

	        BufferedOutputStream bos = null;
	        // 创建输入字节流
	        FileInputStream fis = new FileInputStream(zipFileName);
        	// 根据输入字节流创建输入字符流
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        // 根据字符流，创建ZIP文件输入流
	        ZipInputStream zis = new ZipInputStream(bis);
	         // zip文件条目，表示zip文件
	        ZipEntry entry ;
	        ZipFile zfile=new ZipFile(zipFileName);
	        Enumeration zList=zfile.entries();
	       // 循环读取文件条目，只要不为空，就进行处理

	        while (zList.hasMoreElements()  ) {
	        	entry=(ZipEntry)zList.nextElement();
	        	
	        	
	            int count;
	            byte date[] = new byte[2048];
	            // 如果条目是文件目录，则继续执行
	            if(entry.isDirectory()){
	            	log.info("Dir: "+entry.getName()+"这是目录");	            	
	            	continue;
	            	
	            }else
	             if(entry.getName().endsWith("idf")) {
		            
		            
	                int begin = zipFileName.lastIndexOf("\\") + 1;

	                int end = zipFileName.lastIndexOf(".") + 1;
                     //获取上传的文件路径
	               /* String zipRealName = zipFileName.substring(begin, end);
                    log.info(zipRealName);*/
	                bos = new BufferedOutputStream(new FileOutputStream(this

	                      .getRealFileName(outputDir ,entry.getName())));	                     
	                while ((count = zis.read(date)) != -1) {

	                      bos.write(date, 0, count);
	                }	               
	            }

	       }
	        bos.flush();

            bos.close();
            zis.close();
	        
	    } catch (Exception e) {

	    e.printStackTrace();

	    }

	}
    private File getRealFileName(String zippath, String absFileName) {
	    String[] dirs = absFileName.split("/", absFileName.length());
	    // 创建文件对象
	    File file = new File(zippath);
	    if (dirs.length > 1) {
	        for (int i = 0; i < dirs.length - 1; i++) {
	         // 根据file抽象路径和dir路径字符串创建一个新的file对象，路径为文件的上一个目录
	        file = new File(file, dirs[i]);
	        }
	    }
	if (!file.exists()) {
	    file.mkdirs();
	}
	file = new File(file, dirs[dirs.length - 1]);
	return file;
	}
	@SuppressWarnings("unchecked")
	public String unZip(String unZipfileName) throws IOException {// unZipfileName需要解压的zip文件名
		String returnfilename = "";
		String unzipidfname = unZipfileName.substring(0,unZipfileName.lastIndexOf("/"));
		System.out.println(unzipidfname);
		//判断是否以zip结尾
		if(unZipfileName.indexOf("zip")==-1){
			FileInputStream   fis   =   new   FileInputStream(unZipfileName); 
			unZipfileName = unZipfileName+".zip";
			FileOutputStream   fos   =   new   FileOutputStream( unZipfileName); 
			byte[]   buff   =   new   byte[1024]; 
			int   readed   =   -1; 
			while((readed   =   fis.read(buff))   >   0) 
			fos.write(buff,   0,   readed); 
			fis.close(); 
			fos.close(); 
		}
		int index = unZipfileName.lastIndexOf(File.separator);
		String path = unZipfileName.substring(0, index);
		FileOutputStream fileOut;
		File file;
		InputStream inputStream;
		try {
			org.apache.tools.zip.ZipFile zf = new org.apache.tools.zip.ZipFile(unZipfileName,"GBK");
			this.zipFile = zf;
			
			for (Enumeration entries = zf.getEntries(); entries
					.hasMoreElements();) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String ent = entry.getName();
				
			    ent = new String(ent.getBytes("utf-8"),"UTF-8");
				file = new File(path + File.separator + ent);
				returnfilename = path + File.separator + ent;
				if (entry.isDirectory()) {
					file.mkdirs();
				} else {
					// 如果指定文件的目录不存在,则创建之.
					File parent = file.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}
					inputStream = zipFile.getInputStream((org.apache.tools.zip.ZipEntry) entry);
					fileOut = new FileOutputStream(file);
					while ((this.readedBytes = inputStream.read(this.buf)) > 0) {
						fileOut.write(this.buf, 0, this.readedBytes);
					}
					fileOut.close();
					inputStream.close();
				}
			}
			this.zipFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	      return	returnfilename;
	}
	public String upzip1(String zippath,String idfpath){
		UpZip up = new UpZip();
		String name = "";
		try {
			 name =up.unzip(zippath, idfpath);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

}
