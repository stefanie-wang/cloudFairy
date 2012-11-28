/**
 * 
 */
package com.ucap.cloud.builder.loader;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;


/**
 * @ClassName RarUtil
 * @Description TODO
 * @author 
 * @date 2012-8-10
 */
public class RarUtil {

	static private Logger log = Logger.getLogger(RarUtil.class);
	/**
	 * 
	 */
	public RarUtil() {
		// TODO Auto-generated constructor stub
	}
	public void uprar(String rarFileName, String outputDir) throws IOException {

	    try {

	        BufferedOutputStream bos = null;
	        // 创建输入字节流
	        FileInputStream fis = new FileInputStream(rarFileName);
        	// 根据输入字节流创建输入字符流
	        //BufferedInputStream bis = new BufferedInputStream(fis);
	        // 根据字符流，创建ZIP文件输入流
	       
	         // zip文件条目，表示zip文件
	        ZipEntry entry ;
	        ZipFile zfile=new ZipFile(rarFileName);
	        Enumeration<?> zList=zfile.entries();
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
		            
		            
	                @SuppressWarnings("unused")
					int begin = rarFileName.lastIndexOf("\\") + 1;

	                @SuppressWarnings("unused")
					int end = rarFileName.lastIndexOf(".") + 1;
                     //获取上传的文件路径
	               /* String zipRealName = zipFileName.substring(begin, end);
                    log.info(zipRealName);*/
	                bos = new BufferedOutputStream(new FileOutputStream(this

	                      .getRealFileName(outputDir ,entry.getName())));	                     
	                while ((count = fis.read(date)) != -1) {

	                      bos.write(date, 0, count);
	                }	               
	            }

	       }
	        bos.flush();

            bos.close();
            fis.close();
	        
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

}
