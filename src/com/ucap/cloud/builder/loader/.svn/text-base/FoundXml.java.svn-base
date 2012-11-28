/**
 * 
 */
package com.ucap.cloud.builder.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipException;

/**
 * @author sunjq
 *
 */
@SuppressWarnings("unchecked")
public class FoundXml {

	/**
	 * 
	 */
	public FoundXml() {
		// TODO Auto-generated constructor stub
	}
	
	ArrayList filelist = new ArrayList();
	String strFileName;
	List<String> filesName=new ArrayList();
    List<File> refiles=new ArrayList<File>();
	
	public List<File> found(String strPath) throws ZipException, IOException{
		File dir = new File(strPath);												
		File[] files = dir.listFiles();
		for(int i=0;i<files.length;i++){
			if(files[i].isDirectory()){
				found(files[i].getAbsolutePath());				
			}else{
				strFileName = files[i].getAbsolutePath();
				if(strFileName.endsWith("xml")){
				filesName.add(strFileName);
				refiles.add(files[i]);										
				}
			}
		}		        
		return  refiles;
	}

}
