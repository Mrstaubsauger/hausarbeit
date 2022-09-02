package ProtokollManagerView.StefanEske.Spring;
//GITHUB TEST
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//TODO TRY und CATCH informieren, Fehlerseite implementieren die abfängt
//TODO Null Werte in Datenbank abfangen
// TRY and Catch für alle Funktionen einbauen
@Controller
public class ProtokollController {
//@Autowired
//private ProtoStorage protokollListe;
@Autowired
private ProtokollInterface repo;

@RequestMapping("/a")
public String indexPage () {
	return "index";
}


@RequestMapping ("/index")
public String showIndex () {
	return "index";
}

@RequestMapping ("/showProtokolle")
public String showProtokolle (Model m) {
	m.addAttribute("protokollListe", repo.findAll());
	return "showProtokolle";
}


@RequestMapping ("/newProtokollForm")
public String createProtokollForm (Model m) {
	m.addAttribute("newProtokoll", new ProtokollV());
	
	return "createForm";
}

@RequestMapping ("/createProtokoll")
public String createNewProtokoll (@ModelAttribute ProtokollV newProtokoll, Model m, Model n) {
	ProtokollV protokollWithId = this.repo.save(newProtokoll);	
	m.addAttribute( protokollWithId);
	n.addAttribute("protokollPosition", new ProtokollPosition());
	
	//TODO Alert in HTML schreiben, ob es erfolgreichen war oder nicht
	//protokollListe.getProtoList().add(newProtokoll);
	//m.addAttribute("protokollListe", protokollListe.getProtoList());
	return "/addPosition";
}

@RequestMapping ("/addPosition")
public String addPositionZuProtokoll (@ModelAttribute ProtokollPosition protokollPosition,@ModelAttribute ProtokollV protokollWithId, Model m) {
	protokollWithId.addProtokollPosition(protokollPosition);
	this.repo.save(protokollWithId);
	
	m.addAttribute("protokollListe", repo.findAll());
	return "showProtokolle";
}

@RequestMapping ("/changeForm")
public String changeProtokollForm (Model m) {
	m.addAttribute("changeProtokoll", new ProtokollV());
	return "changeProtokoll";
}

@RequestMapping ("/changeProtokoll")
public String changeProtokoll (@ModelAttribute ProtokollV changeProtokoll, Model m) {
	
	//TODO Kontrollstruktur: Ist das zu ändernde Protokoll überhaupt vorhanden? Nach der ID schauen
	this.repo.save(changeProtokoll);
	m.addAttribute("protokollListe", repo.findAll());
	return "showProtokolle";
	
	//TODO Alert in HTML schreiben, ob es erfolgreichen war oder nicht
	//Optional<ProtokollV> changingProtokollOptional = repo.findById(changeProtokoll.getId());
	//ProtokollV changingProtokoll = changingProtokollOptional.get();
}


@RequestMapping ("/deleteProtokollForm")
public String deleteProtokollForm (Model m) {
	m.addAttribute("deleteProtokoll", new ProtokollV());
	return "deleteForm";
}

@RequestMapping ("/deleteProtokoll")
public String deleteProtokoll (@ModelAttribute ProtokollV deleteProtokoll, Model m) {
	this.repo.delete(deleteProtokoll);
	m.addAttribute("protokollListe", repo.findAll());
	return "showProtokolle";
	//TODO Alert in HTML schreiben, ob es erfolgreichen war oder nicht
}

}
