package ressources;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="civilite")
@XmlEnum
public enum Civilite {

	MADAME("Mme"),
	MONSIEUR("M.");
	
	private final String abreviation;

	private Civilite(String abreviation) {
		this.abreviation = abreviation;
	}

	public String getAbreviation() {
		return abreviation;
	}	
}