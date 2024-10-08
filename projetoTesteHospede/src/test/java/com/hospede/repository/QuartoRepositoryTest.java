package com.hospede.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hospede.entity.Quarto;

@DataJpaTest
class QuartoRepositoryTest {

     @Autowired
		private QuartoRepository quartoRepository;
		
		@DisplayName("Testando o Save")
		@Test
		void testSalvarRepository() {
			
			Quarto quarto1 = new Quarto(null, "72",
					                             "quarto d/ casal"
					                             );
			
			Quarto saveQuarto = quartoRepository.save(quarto1);
			
			Assertions.assertNotNull(saveQuarto);
			Assertions.assertTrue(saveQuarto.getId() > 0);
		}
		
		@DisplayName("Testando Get para todos os quartos")
		@Test
		void testGetAllRepository() {
			
			Quarto quarto1 = new Quarto(null, "72",
					                             "quarto d/ casal");
			
			Quarto quarto2 = new Quarto(null, "12",
	                "Quarto de solteiro");
			
			quartoRepository.save(quarto1);
			quartoRepository.save(quarto2);
			
			List<Quarto> quartoList = quartoRepository.findAll();
			
			Assertions.assertNotNull(quartoList);
			Assertions.assertEquals(2, quartoList.size());
		}
		@DisplayName("Testando GET By ID")
		@Test
		void testGetById() {
			
			Quarto quarto1 = new Quarto(null, "12",
	                "quarto de solteiro");
			
			quartoRepository.save(quarto1);
			
			Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();
			
			Assertions.assertNotNull(saveQuarto);
			Assertions.assertEquals(quarto1.getId(), saveQuarto.getId());


	}
	    @DisplayName("Testando UPDATE")	
		@Test
		void testUpdateQuarto() {
			
			Quarto quarto1 = new Quarto(null, "72",
					                             "quarto d/ casal");
			
			quartoRepository.save(quarto1);
			
			Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();
			quarto1.setNum("12");
			quarto1.setTipo("Master");
			
			Quarto updateQuarto = quartoRepository.save(saveQuarto);
			
			Assertions.assertNotNull(updateQuarto);
			Assertions.assertEquals("12",updateQuarto.getNum());
			Assertions.assertEquals("Master", updateQuarto.getTipo());

	}
	    @DisplayName("Testando Delete")	
	   	@Test
	   	void testDeleteQuarto() {
	   		
	   		Quarto quarto1 = new Quarto(null, "72",
	   				                             "quarto d/ casal");
	   		
	   		quartoRepository.save(quarto1);
	   		
	   		quartoRepository.deleteById(quarto1.getId());
	   		
	   		
	   		Optional<Quarto> quartoOptional = quartoRepository.findById(quarto1.getId());
	   		Assertions.assertTrue(quartoOptional.isEmpty());


	   }
	}
