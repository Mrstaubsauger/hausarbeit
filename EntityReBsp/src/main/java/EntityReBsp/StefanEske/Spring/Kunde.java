package EntityReBsp.StefanEske.Spring;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity (name = "Kunde")
public class Kunde implements java.io.Serializable {


@Id
@GeneratedValue (strategy = GenerationType.SEQUENCE)
private int id; 


//@JoinColumn (name = "jc")

@OneToMany (mappedBy = "kunderef", cascade=CascadeType.ALL)
//@JoinColumn (name ="kunderef_id")
private List<Adresse> adrList = new ArrayList<Adresse>();

@Column (name = "name")
private String name;



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public List<Adresse> getAdrList() {
	return adrList;
}
public void setAdrList(List<Adresse> adrList) {
	this.adrList = adrList;
}

public void addAdr (Adresse adr) {
	adrList.add(adr);
	adr.setKunderef(this);
}



}
