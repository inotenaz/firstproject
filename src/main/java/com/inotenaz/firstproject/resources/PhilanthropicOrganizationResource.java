package com.inotenaz.firstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inotenaz.firstproject.domain.PhilanthropicOrganization;

@RestController
@RequestMapping(value="/phos")
public class PhilanthropicOrganizationResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<PhilanthropicOrganization> listar() {
		
		PhilanthropicOrganization pho1 = new PhilanthropicOrganization(1, "AllanKArdec", "a declarar");
		PhilanthropicOrganization pho2 = new PhilanthropicOrganization(2, "CaibarShutel", "a declarar");
		
		List<PhilanthropicOrganization> list = new ArrayList<>();
		list.add(pho1);
		list.add(pho2);
		
		return list;
		
	
	}

}
