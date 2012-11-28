/**
 * 
 */
package com.ucap.cloud.builder.servlet.Filter;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucap.cloud.builder.licence.LecenceMsg;
import com.ucap.cloud.builder.licence.LecenceValidate;
import com.ucap.cloud.business.formserver.idf.model.UserModel;

/**
 * @author yxk
 * 
 */
public class UCAPFilter_encoder implements Filter {

	/**
	 * 
	 */
	public UCAPFilter_encoder() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	static public Map<String, String> alreadyuser = new HashMap<String, String>();

	static public String getUser() {
		StringBuilder sb = new StringBuilder();
		for (String key : alreadyuser.keySet()) {
			sb.append("<option value=\"" + key + "\">");
			sb.append(alreadyuser.get(key));
			sb.append("</option>");
		}
		return sb.toString();
	}

	private String encoder = "UTF-8";

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding(this.encoder);
		response.setCharacterEncoding(this.encoder);
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		UserModel um = new UserModel();
		um.setPassword(password);
		um.setUsername(username);
		if(null!=username&&username.equals("a")){
			um.setRoles("a");
		}
		String requestpath = request.getRequestURI();
//		LecenceMsg isLicence = (LecenceMsg) request.getSession().getServletContext().getAttribute("License");
//		LecenceValidate lv = new LecenceValidate();
//		lv.setMsg(isLicence);
//		if(null!=isLicence&&lv.islasttime())
//		{
//		request.getSession().setAttribute("lecence", "lecence的有效期还有："+isLicence.getTimeleng()+"月");
	
		String s3=request.getContextPath();
		
		if (null == username || null == password) {
			um = (UserModel) request.getSession().getAttribute("userid");
			if (null == um) {
				arg2.doFilter(request, response);
			} else {
				arg2.doFilter(request, response);
			}
		} else if(requestpath.equals(s3+"/login.form")){
			alreadyuser.put(username, username);
			request.getSession().setAttribute("userid", um);
			request.getRequestDispatcher("/welcome.jsp").forward(request,
					response);
		}else
		{
			request.getSession().setAttribute("userid", um);
			arg2.doFilter(request, response);
		}
//		}else
//		{
//			
//			request.getRequestDispatcher("/formjsp/nolecence.jsp").forward(request,
//					response);
//		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		String en = arg0.getInitParameter("encoder");
		if (null != en && "".equals(en)) {
			this.encoder = en;
		}
	}

}
