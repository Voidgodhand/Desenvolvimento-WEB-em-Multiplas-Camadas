package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void adicionarMensagemSucesso(String _msg)
	{
		//severity - tipo da mensagem (info, warning, error, fatal)
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO!", _msg);
		
		//Pega a área de memoria temporaria
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		contexto.addMessage(null, msg);
	}
	
	public static void adicionarMensagemErro(String _msg)
	{
		//severity - tipo da mensagem (info, warning, error, fatal)
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!!!", _msg);
		
		//Pega a área de memoria temporaria
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		contexto.addMessage(null, msg);
	}
}
