package ProtokollManagerView.StefanEske.Spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class ProtokollPosition {
	
//Generierte, eindeutige ID
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private long id;


//Attribute & Spalten
@Column (name = "titel")
private String titel;

@Column (name = "beschreibung")
private String beschreibung;

//Referenz-Objekt der Klasse ProtokollV
@ManyToOne
private ProtokollV protokollRef;



//Konstruktoren
public ProtokollPosition() {};
public ProtokollPosition (String titel, String beschreibung) {
	this.titel = titel;
	this.beschreibung = beschreibung;
}

//Getter & Setter
public ProtokollV getProtokollRef() {
	return protokollRef;
}

public void setProtokollRef(ProtokollV protokollRef) {
	this.protokollRef = protokollRef;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitel() {
	return titel;
}
public void setTitel(String titel) {
	this.titel = titel;
}
public String getBeschreibung() {
	return beschreibung;
}
public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
}



}
