package com.inotenaz.firstproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.inotenaz.firstproject.domain.PhilanthropicOrganization;
import com.inotenaz.firstproject.repositories.PhilanthropicOrganizationsRepository;
import com.inotenaz.firstproject.services.exceptions.DataIntegrityException;
import com.inotenaz.firstproject.services.exceptions.ObjectNotFoundException;

@Service
public class PhilanthropicOrganizationsService {
	
	@Autowired
	private PhilanthropicOrganizationsRepository phiRepo;

	public PhilanthropicOrganization find(Integer id) {
							
		Optional<PhilanthropicOrganization> obj = phiRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PhilanthropicOrganization.class.getName()));
		
	}
		
	public List<PhilanthropicOrganization> findAll() {
			
		List<PhilanthropicOrganization> obj = phiRepo.findAll();
		if (obj != null)
			return obj;
		return null;	
	}
	
	public PhilanthropicOrganization insert(PhilanthropicOrganization obj) {
		obj.setId(null);
		return phiRepo.save(obj);
	}
	
	public PhilanthropicOrganization update(PhilanthropicOrganization obj) {
		find(obj.getId());
		return phiRepo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			phiRepo.deleteById(id);		
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possivel excluir uma entidade que possua Açoes Sociais existentes");
			
		}	
	}
}
