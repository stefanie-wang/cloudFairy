/**  
 * @Project: cloudFairy
 * @Title: UntilGetRoles.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until
 * @Description: TODO
 * @authorshenyanghong ahong2011@gmail.com
 * @date 2012-10-11 下午04:36:42
 * @Copyright: 2012 
 * @version V1.0  
 */

package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.ucap.cloud.business.formserver.data.model.RoleModel;
import com.ucap.cloud.business.formserver.data.model.RolesControlsModel;
import com.ucap.cloud.business.formserver.data.model.RolesPagesModel;

/**
 * @ClassName UntilGetRoles
 * @Description 解析idf表单中的角色信息
 * @author sunjq
 * @date 2012-10-11
 */

public class UntilGetRoles {

	/** 
	 * <p>Title: UntilGetRoles</p>
	 * <p>Description: 解析表单中的roles节点信息</p> 
	 */

	public UntilGetRoles() {
		// TODO Auto-generated constructor stub
	}

	public Map<String,RoleModel> getRoles(Element controlsson){
		Map<String,RoleModel> maproles = new HashMap<String, RoleModel>();
		List<Element> roles = controlsson.elements("role");//查找role节点
		if(null!=roles && roles.size()>0){//判断是否用role几点
			for(Element role:roles){//循环处理每个role节点

				RoleModel roleModel = new RoleModel();//创建一个角色模型
				String id = role.attributeValue("id");//获取节点id属性
				String name = role.attributeValue("name");//获取节点name属性
				roleModel.setId(id);
				roleModel.setName(name);//完成赋值
				List<Element> pages = role.elements("page");//查找page节点，对应的是表单的分页
				if(null!=pages && pages.size()>0){
					for(Element page:pages ){//循环处理每个page

						RolesPagesModel rolesPagesModel = new RolesPagesModel();//创建page节点对应的模型
						String pageName = page.attributeValue("name");//解析属性
						String pageType = page.attributeValue("type");
						String pageReadOnly = page.attributeValue("readOnly");
						String pageHidden = page.attributeValue("hidden");
						String pagePrintable = page.attributeValue("printable");
						String pageForbidden = page.attributeValue("forbidden");
						rolesPagesModel.setName(pageName);
						rolesPagesModel.setType(pageType);
						rolesPagesModel.setForbidden(pageForbidden);
						rolesPagesModel.setHidden(pageHidden);
						rolesPagesModel.setReadOnly(pageReadOnly);
						rolesPagesModel.setPrintable(pagePrintable);//完成赋值
						
						List<Element> controls = page.elements("control");//查找control节点，代表这一页上面的控件
						if(null!=controls && controls.size()>0){
							for(Element control:controls){

								RolesControlsModel roleControlModel = new RolesControlsModel();//创建control节点对应的模型
								String controlName = control.attributeValue("name");//解析属性
								String controlType = control.attributeValue("type");
								String controlReadOnly = control.attributeValue("readOnly");
								String controlHidden = control.attributeValue("hidden");
								String controlPrintable = control.attributeValue("printable");
								String controlForbidden = control.attributeValue("forbidden");
								roleControlModel.setForbidden(controlForbidden);
								roleControlModel.setHidden(controlHidden);
								roleControlModel.setName(controlName);
								roleControlModel.setPrintable(controlPrintable);
								roleControlModel.setReadOnly(controlReadOnly);
								roleControlModel.setType(controlType);//完成赋值
								roleModel.setControlRole(controlName, roleControlModel);
								if(controlType.equals("repeatUnit")||controlType.equals("table")){
									List<Element> instControl = control.elements();
									if(instControl!=null&&instControl.size()>0){
										for(Element el:instControl){
											RolesControlsModel instcm = new RolesControlsModel();
											String elName = el.attributeValue("name");//解析属性
											String elType = el.attributeValue("type");
											String elReadOnly = el.attributeValue("readOnly");
											String elHidden = el.attributeValue("hidden");
											String elPrintable = el.attributeValue("printable");
											String elForbidden = el.attributeValue("forbidden");
											instcm.setForbidden(elForbidden);
											instcm.setHidden(elHidden);
											instcm.setName(elName);
											instcm.setPrintable(elPrintable);
											instcm.setReadOnly(elReadOnly);
											instcm.setType(elType);
											roleModel.setControlRole(elName, instcm);
										}
									}
								}
							}
							roleModel.setPageRoles(pageName, rolesPagesModel);//
						}
					}
				}
				maproles.put(roleModel.getName(), roleModel);
			}
		}
		return maproles;
	}

}
