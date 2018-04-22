package controleur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;
import ressources.Civilite;
import ressources.Service;

@ManagedBean(name = "abo")
@RequestScoped
public class ControleurAbonne {
	
	private final String REST_URI = "http://tomcatserviceinscription:8080/service-abonnement-newslette";
	private String nom;
	private String prenom;
	private String courriel;
	private Civilite civilite;
	private Service service;
	private Civilite[] civilites = Civilite.values();
	private Service[] services = Service.values();
	
	public String controler() {
		
		AbonneDTO envoi = new AbonneDTO(civilite.getAbreviation(), nom, prenom, courriel, service.name(), "envoi");
		
		Client client = ClientBuilder.newClient();
		AbonneDTO retour = client
		 .target(REST_URI)
		 .path("abonnement")
		 .path("dto")
		 .request(MediaType.APPLICATION_XML)
		 .post(Entity.entity(envoi, MediaType.APPLICATION_XML), AbonneDTO.class);
		
		System.out.println(retour);
		
		return "formulaire";
	}
	
	public ControleurAbonne() {
		super();
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

	public Civilite[] getCivilites() {
		return civilites;
	}

	public void setCivilites(Civilite[] civilites) {
		this.civilites = civilites;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Service[] getServices() {
		return services;
	}

	public void setServices(Service[] services) {
		this.services = services;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}