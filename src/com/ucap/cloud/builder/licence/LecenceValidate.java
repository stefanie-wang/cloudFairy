/**
 * 
 */
package com.ucap.cloud.builder.licence;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PublicKey;
import java.security.Signature;
import java.text.DateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author yxk
 *
 */
public class LecenceValidate {

	/**
	 * 
	 */
	public LecenceValidate() {
		// TODO Auto-generated constructor stub
	}

	
	private LecenceMsg msg = new LecenceMsg();
	
	/**
	 * <P>验证lecence文件是否有效不验证信息</P>
	 * @param publicpath
	 * @param lecencpath 许可证
	 * @return
	 * @throws Exception
	 */
	public boolean validate(String publicpath,String lecencpath)throws Exception
	{
		boolean b = false;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(publicpath));
		PublicKey  publickey = (PublicKey) in.readObject();
		in.close();
		in = new ObjectInputStream(new FileInputStream(lecencpath));
		String info = (String) in.readObject();
		
		ByteArrayInputStream inx = new ByteArrayInputStream(info.getBytes("UTF-8"));
		SAXReader reader = new SAXReader();
		Document document = reader.read(inx);
		Element root = document.getRootElement();
		String company = root.elementText("company");
		String server_ip = root.elementText("server-ip");
		String server_mac = root.elementText("server-mac");
		String begin_time = root.elementText("begin-time");
		String timeleng = root.elementText("time-leng");
		String usernumber = root.elementText("user-number");
		DateFormat df = DateFormat.getDateInstance(2);		
		this.msg.setCompany(company);
		this.msg.setBegintime(df.parse(begin_time));
		this.msg.setServerip(server_ip);
		this.msg.setServermac(server_mac);
		this.msg.setTimeleng(Integer.valueOf(timeleng));
		this.msg.setUsernumber(Integer.valueOf(usernumber));
		byte[] sign = (byte[]) in.readObject();
		in.close();
		Signature signcheck = Signature.getInstance("DSA");
		signcheck.initVerify(publickey);
		signcheck.update(info.getBytes());
		if(!signcheck.verify(sign))
		{
			b = true;
		}else
		{
			b = false;
		}
		
		return b;
	}
	/**
	 * ip地址是否有效
	 * @param ip
	 * @return
	 */
	public boolean isip(String ip)
	{
		if(null==this.msg.getServerip()||"".equals(this.msg.getServerip()))
		{
			return false;
		}
		return this.msg.getServerip().equals(ip);
	}
	
	
	/**
	 * 确定mac地址是否有效
	 * @param mac
	 * @return
	 */
	public boolean ismac(String mac)
	{
		if(null==this.msg.getServermac()||"".equals(this.msg.getServermac()))
		{
			return false;
		}
		return this.msg.getServermac().equals(mac);
	}
	
	/**
	 * 确定有效期
	 * @return
	 */
	public boolean islasttime()
	{
		long time = new Date().getTime();
		long last = this.msg.getBegintime().getTime()+(Long.valueOf(""+this.msg.getTimeleng())*30*24*60*60*1000);
		if(time-last>0)
		{
			return false;
		}else
		{
			return true;
		}
	}
	
	

	public LecenceMsg getMsg() {
		return msg;
	}

	public void setMsg(LecenceMsg msg) {
		this.msg = msg;
	}
	
//	static public void main(String arg[])
//	{
//		LecenceValidate lv = new LecenceValidate();
//		try {
//			lv.validate("D:\\osgiproject\\testjar\\src\\com\\bat\\yxk_public.bat", "D:\\osgiproject\\testjar\\src\\com\\bat\\publicbat\\yxk.bat");
//			System.out.println(lv.getMsg())	;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
