package ressources;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="service")
@XmlEnum
public enum Service {

	COMPTABILITE,
	DIRECTION,
	INFORMATIQUE,
	MARKETING,
	PUBLICITE;
}