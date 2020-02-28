package com.inotenaz.firstproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insertobj(@RequestBody PhilanthropicOrganization obj){
		obj = phiService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody PhilanthropicOrganization obj, @PathVariable Integer id) {
		
			obj.setId(id);
			obj = phiService.update(obj);
			return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

			phiService.delete(id);
			return ResponseEntity.noContent().build();

	}
}
