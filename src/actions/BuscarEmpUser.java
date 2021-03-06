package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import persistencia.Empresa;
import persistencia.EmpresaDAO;
import persistencia.Usuario;

import com.opensymphony.xwork2.ActionSupport;

public class BuscarEmpUser extends ActionSupport implements SessionAware {
	
	private Map session;
	
	public String execute(){
		Usuario user = (Usuario) session.get("User");
		EmpresaDAO eDAO = new EmpresaDAO();
		Empresa emp = eDAO.findByRUT(user.getRut());
		session.put("empresa", emp);
		
		
		return SUCCESS;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

}
