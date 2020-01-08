package com.inotenaz.firstproject;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inotenaz.firstproject.domain.Action;
import com.inotenaz.firstproject.domain.PhilanthropicOrganization;
import com.inotenaz.firstproject.domain.SocialAction;
import com.inotenaz.firstproject.domain.Volunteer;
import com.inotenaz.firstproject.repositories.ActionRepository;
import com.inotenaz.firstproject.repositories.PhilanthropicOrganizationsRepository;
import com.inotenaz.firstproject.repositories.SocialActionRepository;
import com.inotenaz.firstproject.repositories.VolunteerRepository;

@SpringBootApplication
public class FirstprojectApplication implements CommandLineRunner {
	
	@Autowired
	private PhilanthropicOrganizationsRepository phirepo;
	
	@Autowired
	private SocialActionRepository sarepo;
	
	@Autowired
	private VolunteerRepository vrepo;
	
	@Autowired
	private ActionRepository actionrepo;

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		PhilanthropicOrganization phi1 = new PhilanthropicOrganization(null, "caibar", "descricao de caibar");
		PhilanthropicOrganization phi2 = new PhilanthropicOrganization(null, "alan kardec", "descricao de alan kardec");
		
		phirepo.saveAll(Arrays.asList(phi1,phi2));
		
		SocialAction sa1 = new SocialAction(null,"barraca da felicidade","doces em geral", null, phi1);
		SocialAction sa2 = new SocialAction(null,"barraca da muita felicidade", "salgados em geral", null, phi1);
		SocialAction sa3 = new SocialAction(null,"campanha alimetos", "alimentos em geral", null, phi2);
		SocialAction sa4 = new SocialAction(null,"campanha vestuario", "vestuario em geral", null, phi2);
		
		sarepo.saveAll(Arrays.asList(sa1,sa2,sa3,sa4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Volunteer v1 = new Volunteer(null, "maria da silva","maria@gmail.com", "11111111111", sdf.parse("01/01/2000 00:00"));
		Volunteer v2 = new Volunteer(null, "joao da silva","joao@gmail.com", "22222222222", sdf.parse("01/01/2001 00:00"));
		Volunteer v3 = new Volunteer(null, "mario da silva","mario@gmail.com", "33333333333", sdf.parse("01/01/2002 00:00"));
		Volunteer v4 = new Volunteer(null, "eduardo da silva","eduardo@gmail.com", "44444444444", sdf.parse("01/01/2003 00:00"));
		Volunteer v5 = new Volunteer(null, "flavio da silva","flavio@gmail.com", "55555555555", sdf.parse("01/01/2004 00:00"));
		
		v1.getTelefones().addAll(Arrays.asList("21546545","19646515"));
		v2.getTelefones().addAll(Arrays.asList("6165461","8654655"));
		v3.getTelefones().addAll(Arrays.asList("849465416","19646515"));		
		
		vrepo.saveAll(Arrays.asList(v1,v2,v3,v4,v5));
		
		Action ac1 = new Action(null,sa1,v1);
		Action ac2 = new Action(null,sa2,v1);
		Action ac3 = new Action(null,sa1,v2);
		Action ac4 = new Action(null,sa2,v2);
		
		actionrepo.saveAll(Arrays.asList(ac1,ac2,ac3,ac4));
		
		
		
	}

	
}
