package persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FournisseurDeGerantDePersistance {

	private static FournisseurDeGerantDePersistance instance = null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("abo");
	
	private FournisseurDeGerantDePersistance() {
		super();
	}
	
	public static FournisseurDeGerantDePersistance getInstance() {
		if(instance == null)
			instance = new FournisseurDeGerantDePersistance();
		
		return instance;
	}
	
	public EntityManager fournir() {
		return emf.createEntityManager();
	}
	
}