package ProtokollManagerView.StefanEske.Spring;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity (name = "protokolldb")
@Component
//TODO component checken
public class ProtokollV {
//Generierte, eindeutige ID	
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
private long id;
//Attribute und Spalten
@Column (name = "termin", length = 5000)
private String termin;
		//TODO Umändern in Datum des Termins
		//TODO Datum verwenden mit Funktion und so
@Column (name = "betreff", length = 5000)
private String betreff;
@Column (name = "ort", length = 5000)
private String ort;
	
//Referenz-Objekte der Klasse ProtokollPosition in einer Liste
@OneToMany (mappedBy = "protokollRef")
private List<ProtokollPosition> protokollPositionenListe = new ArrayList<ProtokollPosition>();

//Konstruktoren
public ProtokollV () {};

public ProtokollV (String a, String b, String c) {
	this.termin = a;
	this.betreff = b;
	this.ort = c;
}

//Methoden für die Referenz-Objekte-Liste
public void addProtokollPosition (ProtokollPosition protPos) {
	protokollPositionenListe.add(protPos);
	protPos.setProtokollRef(this);
}

public void addProtokollPosition (String titel, String beschreibung) {
	ProtokollPosition protPos = new ProtokollPosition (titel, beschreibung);
	protokollPositionenListe.add(protPos);
	protPos.setProtokollRef(this);
}



//Getter & Setter
public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}

public String getTermin() {
	return termin;
}

public void setTermin(String termin) {
	this.termin = termin;
}

public String getBetreff() {
	return betreff;
}

public void setBetreff(String betreff) {
	this.betreff = betreff;
}

public String getOrt() {
	return ort;
}

public void setOrt(String ort) {
	this.ort = ort;
}

public List<ProtokollPosition> getProtokollPositionenListe() {
	return protokollPositionenListe;
}

public void setProtokollPositionenListe(List<ProtokollPosition> protokollPositionenListe) {
	this.protokollPositionenListe = protokollPositionenListe;
}


@Override
public String toString() {
	return "ProtokollV [termin=" + termin + ", betreff=" + betreff + ", ort=" + ort + "]";
}


}
