package EntityReBsp.StefanEske.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BspController {
@Autowired
private BspInterface repo;
@RequestMapping ("/b")
public String getStarted() {
	
	Kunde kunde = new Kunde();
	kunde.setName("name1");
	Adresse adr1 = new Adresse();
	adr1.setAdresse("Adresse 1A");
	
	
	Adresse adr2 = new Adresse();
	adr2.setAdresse("Adresse 1B");
	
	
	
	kunde.addAdr(adr1);
	kunde.addAdr(adr2);
	repo.save(kunde);
	
	Kunde kunde2 = new Kunde();
	kunde2.setName("name2");
	Adresse adr3 = new Adresse();
	adr3.setAdresse("adresse 2A");
	Adresse adr4 = new Adresse();
	adr4.setAdresse("Adresse 2B");
	kunde2.addAdr(adr3);
	kunde2.addAdr(adr4);
	
	repo.save(kunde2);
	
	return "index";
}
}
