package service;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;
import modele.Abonne;
import persistance.FournisseurDeGerantDePersistance;

@Path("/abonnement")
public class ServiceAbonnement {

	@POST
	@Path("/dto")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public AbonneDTO methode(AbonneDTO entree) {

		System.out.println(entree);
		
		AbonneDTO retour = new AbonneDTO();

		if (enregistrer(constructeurAbonne(entree))) {
			
			retour.setCivilite(entree.getCivilite());
			retour.setNom(entree.getNom());
			retour.setPrenom(entree.getPrenom());
			retour.setService(entree.getService());
			retour.setMessage("Votre abonnement à la newsletter est confirmée [Open&Free Software Inc.]");
			
		} else {
			retour.setMessage("Un incident rend votre abonnement impossible [Open&Free Software Inc.]");
		}

		return retour;
	}

	private boolean enregistrer(Abonne nouveau) {
		System.out.println(nouveau);
		EntityManager em = null;
		try {
			em = FournisseurDeGerantDePersistance.getInstance().fournir();
			em.getTransaction().begin();
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			em.persist(nouveau);
			System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			em.close();
		}
	}

	private Abonne constructeurAbonne(AbonneDTO entree) {
		return new Abonne(entree.getCivilite(), entree.getNom(), entree.getPrenom(), entree.getCourriel(),
				entree.getService());
	}
}