package ProtokollManagerView.StefanEske.Spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProtokollInterface extends CrudRepository<ProtokollV, Long> {
	List<ProtokollV> findAll();

}
