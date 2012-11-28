/**  
* @Project: cloudFairy
* @Title: UpZip.java
* @Package com.ucap.cloud.builder.loader
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-9-10 下午03:42:24
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.builder.loader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
 
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
/**
 * @ClassName UpZip
 * @Description TODO
 * <p>解压缩idf文件的工具类</p>
 * @author sunjq
 * @date 2012-9-10
 */

public class UpZip {

	/** 
	 * <p>Title: </p>
	 * <p>Description: </p> 
	 */

	public UpZip() {
		// TODO Auto-generated constructor stub
	}
	
	public  String unzip(String zipFileName, String destDir)
	   throws Exception {
		String upidfname="";
	  try {
	   ZipFile zipFile = new ZipFile(zipFileName,"GBK");
	   Enumeration<?> e = zipFile.getEntries();
	   ZipEntry zipEntry = null;
	   File fD = new File(destDir);
	   if(!fD.exists()){
	    fD.mkdir();
	   }
	   while (e.hasMoreElements()) {
	    zipEntry = (ZipEntry) e.nextElement();
	    String entryName = zipEntry.getName();
	    upidfname = destDir + "/" + entryName;
	    String names[] = entryName.split("/");
	    int length = names.length;
	    String path = destDir;
	    for (int v = 0; v < length; v++) {
	     if (v < length - 1) {
	      path += "/" + names[v];
	      new File(path).mkdir();
	     } else { 
	      if (entryName.endsWith("/")) { 
	       new File(destDir + "/" + entryName).mkdir();
	      } else {
	       InputStream in = zipFile.getInputStream(zipEntry);
	       OutputStream os = new FileOutputStream(new File(
	         destDir + "/" + entryName));
	       byte[] buf = new byte[1024];
	       int len;
	       while ((len = in.read(buf)) > 0) {
	        os.write(buf, 0, len);
	       }
	       in.close();
	       os.close();
	      }
	     }
	    }
	   }
	   zipFile.close();
	 
	  } catch (Exception ex) {
	   ex.printStackTrace();
	  }
	  return upidfname;
	 }

}
