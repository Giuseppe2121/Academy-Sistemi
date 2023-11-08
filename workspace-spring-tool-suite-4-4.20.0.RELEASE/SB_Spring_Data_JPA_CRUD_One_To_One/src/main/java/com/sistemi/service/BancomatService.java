package com.sistemi.service;

import com.sistemi.entity.Bancomat;

public interface BancomatService {
	
	public void saveOrUpdateBancomat(Bancomat bancomat);
	
	public void removeBancomat(String codeNumber);

}
