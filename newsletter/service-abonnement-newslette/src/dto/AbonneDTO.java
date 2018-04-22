package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AbonneDTO {

	private String civilite;
	private String nom;
	private String prenom;
	private String courriel;
	private String service;
	private String message;

	public AbonneDTO() {
		super();
	}

	public AbonneDTO(String civilite, String nom, String prenom, String courriel, String service, String message) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.service = service;
		this.message = message;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AbonneDTO [civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", courriel=" + courriel
				+ ", service=" + service + ", message=" + message + "]";
	}

}