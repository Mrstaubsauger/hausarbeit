package ProtokollManagerView.StefanEske.Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProtoStorage {

private List<ProtokollV> protoList;

public ProtoStorage() {
	this.protoList = new ArrayList<ProtokollV>();
}
@Bean 
public List<ProtokollV> getProtoList () {
	return protoList;
}
}
