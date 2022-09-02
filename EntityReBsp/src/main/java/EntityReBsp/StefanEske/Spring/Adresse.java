package EntityReBsp.StefanEske.Spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity (name = "Adresse")
public class Adresse implements java.io.Serializable{

@Id
@GeneratedValue
private int id;


@ManyToOne (fetch = FetchType.LAZY)
private Kunde kunderef;


@Column (name = "adresse")
private String adresse;
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public Kunde getKunderef() {
	return kunderef;
}
public void setKunderef(Kunde kunderef) {
	this.kunderef = kunderef;
}


}
