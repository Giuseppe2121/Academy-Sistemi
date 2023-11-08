package com.sistemi.service;

import com.sistemi.entity.Bancomat;
import com.sistemi.entity.Person;

public interface PersonService {
	
	public void saveOrUpdatePerson (Person person);
	
	public void removePerson (String fiscalCode);
	
	public void findPersonByBancomat (Bancomat bancomate);
	

}
