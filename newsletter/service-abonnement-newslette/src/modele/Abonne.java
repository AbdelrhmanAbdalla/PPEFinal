package modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TABON")
public class Abonne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idabon;
	@Column(nullable = false)
	private String civilite;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false, unique = true)
	private String courriel;
	@Column(nullable = false)
	private String service;
	@Column(name = "DATE_ABON", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateabon;

	public Abonne() {
		super();
	}	

	public Abonne(String civilite, String nom, String prenom, String courriel, String service) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.service = service;
		this.dateabon = new Date();
	}

	public int getIdabon() {
		return idabon;
	}

	public void setIdabon(int idabon) {
		this.idabon = idabon;
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

	public Date getDateabon() {
		return dateabon;
	}

	public void setDateabon(Date dateabon) {
		this.dateabon = dateabon;
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

	@Override
	public String toString() {
		return "Abonne [idabon=" + idabon + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", courriel=" + courriel + ", service=" + service + ", dateabon=" + dateabon + "]";
	}

}