package br.com.vinciano.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.vinciano.bookstore.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

    @Bean
    public boolean instanciaBaseDeDados() {
    	dbService.instanciaBaseDeDados();
    	return false;
    }
    
//    public CommandLineRunner instanciaBaseDeDados() {
//		return args -> {
//			this.dbService.instanciaBaseDeDados();
//			System.out.println("BD Iniciado!");
//		};
//	}
    
    

}
