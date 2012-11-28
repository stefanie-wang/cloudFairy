/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssUntilFileOut
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilFileOut
 */
package com.ucap.cloud.business.formserver.cssmanager.css.until;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CssUntilFileOut
 * @Description TODO 将解析出来的css样式生成样式文件
 * @author pzg
 * @date 2012-8-10
 */
public class CssUntilFileOut implements Runnable {

	
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param list 
	*/
	public CssUntilFileOut(List<Map<String, String>> list) {
		super();
		this.list = list;
	}

	/**
	 * map :key
	 *      value
	 */
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.iswrite(this.list);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  
	/** 
	* @Title: iswrite 
	* @Description: TODO
	* @param list 要处理的文件总和
	* @return boolean     是否生成文件
	* @throws UnsupportedEncodingException  
	*/
	@SuppressWarnings("unchecked")
	public boolean iswrite(List<Map<String,String>> list) throws UnsupportedEncodingException {
		boolean b = true;
		for(int i=0;i<list.size();i++){
			Map<String,String> map = list.get(i);
			Iterator it = map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry = (Map.Entry) it.next();
				String css = (String) entry.getKey();
			
				String patch = map.get(css).trim();
				String filename =  patch.substring(patch.lastIndexOf("\\")+1, patch.length());
				byte[] bar = css.getBytes("UTF-8");
				try {
					FileOutputStream fileout  = null;
					if(filename!=null&&filename.indexOf("jsp")!=-1){
						 fileout = new FileOutputStream(patch);
					}else{
						fileout = new FileOutputStream(patch);
					}
					fileout.write(bar);
					fileout.flush();
					fileout.close();
				} catch (Exception e) {
					 b = false;
					e.printStackTrace();
					
				}
			}
		}
		return b;
	}

}
