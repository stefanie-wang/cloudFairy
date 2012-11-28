/**
 * 
 */
package com.ucap.cloud.builder.loader;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ucap.cloud.builder.model.rootConfigModel.Authority;
import com.ucap.cloud.builder.model.rootConfigModel.AuthorityConfigModel;
import com.ucap.cloud.builder.model.rootConfigModel.AuthorityModel;

/**
 * @author yxk
 * 系统加载时进行启动将权限存储到指定的文件中
 */
public class RootConfigExt extends RootConfig {

	
	private static Logger logger = Logger.getLogger(RootConfigExt.class);
	/**
	 * 
	 */
	public RootConfigExt() {
		// TODO Auto-generated constructor stub
	}
	
	private String path;
	
	private AuthorityConfigModel ac;

	/* (non-Javadoc)
	 * @see com.ucap.cloud.builder.loader.RootConfig#loaderconfig(java.lang.String)
	 */
	@Override
	public void loaderconfig() {
		// TODO Auto-generated method stub
		String fpath  = this.getClass().getClassLoader().getResource(this.path)
		.getFile();
		if(fpath.endsWith("xml"))
		{
			try {
				this.loaderconfig(fpath);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				logger.info(e);
			}
			return ;
		}
		File[] far = new File(fpath).listFiles();
		for(File s:far)
		{
			String filepath = s.getAbsolutePath();
			if(filepath.endsWith("xml"))
			{
			try {
				this.loaderconfig(s.getAbsolutePath());
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				logger.info(e);
			}
			}
		}
	}
	
	private void loaderconfig(String p) throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document  doc = reader.read(new File(p));
		Element root = doc.getRootElement();
		AuthorityModel am = new AuthorityModel();
		String username = root.elementText("user");
		String password = root.elementText("pass");
		am.setUsername(username);
		am.setPassword(password);
		List<Element> list = root.elements();
		for(Element e:list)
		{
			Authority  auth = new Authority();
			String objectid = e.elementText("classsId");
			boolean isall = Boolean.valueOf(e.elementText("isAll"));
			auth.setAll(isall);
			auth.setObjectId(objectid);
			if(!isall)
			{
				List<Element> mlist = e.elements();
				for(Element x:mlist)
				{
					String id = x.elementText("id");
					auth.setMethodlist(id);
				}
			}
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public AuthorityConfigModel getAc() {
		return ac;
	}

	public void setAc(AuthorityConfigModel ac) {
		this.ac = ac;
	}

	
}
