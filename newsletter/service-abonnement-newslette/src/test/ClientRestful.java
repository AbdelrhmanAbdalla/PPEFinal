package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;

public class ClientRestful {

	public static void main(String[] args) {
		
		final String REST_URI = "http://172.17.0.4:8080/service-abonnement-newsletter";

		AbonneDTO envoi = new AbonneDTO("M.", "DUPONT", "Pierre", "dupont.pierre@open&software.com", "INFORMATIQUE", "envoi");
		
		Client client = ClientBuilder.newClient();
		AbonneDTO retour = client
		 .target(REST_URI)
		 .path("abonnement")
		 .path("dto")
		 .request(MediaType.APPLICATION_XML)
		 .post(Entity.entity(envoi, MediaType.APPLICATION_XML), AbonneDTO.class);		
		
		System.out.println(retour.getMessage());
	}

}