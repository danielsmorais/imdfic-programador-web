package br.ufrn.imd.controllers; 
  
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.ufrn.imd.dominio.Pessoa;
 
/**
	* MBean para realização do cadastro da pessoa. 
	* @author itamir.filho 
*/
@ManagedBean 
@SessionScoped 
public class CadastroMBean {
 
	//atributo pessoa
	Pessoa pessoa;
	
	/** 
		* Construtor 
	*/ 
	public CadastroMBean() { 
		pessoa = new Pessoa(); 
	} 
	  
	public Pessoa getPessoa() { 
		return pessoa; 
	} 
	  
	public void setPessoa(Pessoa pessoa) { 
		this.pessoa = pessoa; 
	} 
	  
	/** 
		* Método para realização do cadastro. 
		* @return 
	*/ 

	public String cadastrar() { 
		//validando se a pessoa já existe no banco de dados
		Pessoa pessoaBanco = dao.findPessoa(pessoa.getCpf());
		if(pessoaBanco != null) {
	   		FacesMessage msg = new FacesMessage("Essa pessoa já existe no banco de dados.");
	    	msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	    	FacesContext.getCurrentInstance().addMessage("", msg);
	    	return "/cadastro.jsf";
	    }
		return "/continue.jsf";
	}
	
	public void meuMetodo(FacesContext context, UIComponent component, java.lang.Object value){ 
		
	}
	
	public void validarPessoa(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	    String cpf = (String) value;
	    Pessoa pessoaBanco = dao.findPessoa(pessoa.getCpf());
	    if(pessoaBanco != null) {
	        String msg = "Essa pessoa já existe no banco de dados.";
	        throw new ValidatorException
	       (new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	    }
	}
}