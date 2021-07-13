package br.ufrn.imd.model; 
  
public class Empresa {
  
	private String razaoSocial;
	  
	private String cnpj;
	  
	public String getRazaoSocial() { 
		return razaoSocial; 
	} 
	  
	public void setRazaoSocial(String razaoSocial) { 
		this.razaoSocial = razaoSocial; 
	} 
	  
	public String getCnpj() { 
		return cnpj; 
	} 
	  
	public void setCnpj(String cnpj) { 
		this.cnpj = cnpj; 
	} 
	  
	@Override 
	public String toString() { 
		return razaoSocial; 
	} 

} 