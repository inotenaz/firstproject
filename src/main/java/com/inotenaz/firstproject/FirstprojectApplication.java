package com.inotenaz.firstproject;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inotenaz.firstproject.domain.PhilanthropicOrganization;
import com.inotenaz.firstproject.domain.SocialAction;
import com.inotenaz.firstproject.repositories.PhilanthropicOrganizationsRepository;
import com.inotenaz.firstproject.repositories.SocialActionRepository;

@SpringBootApplication
public class FirstprojectApplication implements CommandLineRunner {
	
	@Autowired
	private PhilanthropicOrganizationsRepository phirepo;
	
	@Autowired
	private SocialActionRepository sarepo;

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		PhilanthropicOrganization phi1 = new PhilanthropicOrganization(null, "caibar", "descricao de caibar");
		PhilanthropicOrganization phi2 = new PhilanthropicOrganization(null, "alan kardec", "descricao de alan kardec");
		
		phirepo.saveAll(Arrays.asList(phi1,phi2));
		
		SocialAction sa1 = new SocialAction(null,"barraca da felicidade", "doces em geral", null, phi1);
		SocialAction sa2 = new SocialAction(null,"barraca da muita felicidade", "salgados em geral", null, phi1);
		SocialAction sa3 = new SocialAction(null,"campanha alimetos", "alimentos em geral", null, phi2);
		SocialAction sa4 = new SocialAction(null,"campanha vestuario", "vestuario em geral", null, phi2);
		
		sarepo.saveAll(Arrays.asList(sa1,sa2,sa3,sa4));
		
		
	}

	
}
