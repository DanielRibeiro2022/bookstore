package br.daniel.bookstore.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import br.daniel.bookstore.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instanciaBaseDeDados() {
		if(strategy.equals("create")) {
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}
}
