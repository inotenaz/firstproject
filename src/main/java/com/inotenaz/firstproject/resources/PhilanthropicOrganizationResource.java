package com.inotenaz.firstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inotenaz.firstproject.domain.PhilanthropicOrganization;
import com.inotenaz.firstproject.services.PhilanthropicOrganizationsService;

@RestController
@RequestMapping(value="/phos")
public class PhilanthropicOrganizationResource {
	
	@Autowired
	private PhilanthropicOrganizationsService phiService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PhilanthropicOrganization> find(@PathVariable Integer id) {

			PhilanthropicOrganization obj = phiService.find(id);
			return ResponseEntity.ok().body(obj);

	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PhilanthropicOrganization>> findAll() {
		
		List<PhilanthropicOrganization> obj = phiService.findAll();
		return ResponseEntity.ok().body(obj);
		
	}

}
