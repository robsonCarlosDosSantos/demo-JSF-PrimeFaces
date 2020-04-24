package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	
	public static void msgSuccess(String msg) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,"Success",msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, fm);
	}
	
	public static void msgError(String msg) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, fm);
	}

}
