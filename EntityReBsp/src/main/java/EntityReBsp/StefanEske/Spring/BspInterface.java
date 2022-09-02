package EntityReBsp.StefanEske.Spring;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

public interface BspInterface extends CrudRepository<Kunde, Long>{
	//int findById(Id id);

}
