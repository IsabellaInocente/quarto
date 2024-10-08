package com.hospede.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hospede.entity.Hospede;

@DataJpaTest
class HospedeRepositoryTest {

	@Autowired
	private HospedeRepository hospedeRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria",
				                             "julia@gmail.com",
				                             "(00)0000-0000");
		
		Hospede saveHospede = hospedeRepository.save(hospede1);
		
		Assertions.assertNotNull(saveHospede);
		Assertions.assertTrue(saveHospede.getId() > 0);
	}
	@DisplayName("Testando Get para todos os hospedes")
	@Test
	void testGetAllRepository() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria",
				                             "julia@gmail.com",
				                             "(00)0000-0000");
		
		Hospede hospede2 = new Hospede(null, "Joao",
                "joao@gmail.com",
                "(15)0000-0000");
		
		hospedeRepository.save(hospede1);
		hospedeRepository.save(hospede2);
		
		List<Hospede> hospedeList = hospedeRepository.findAll();
		
		Assertions.assertNotNull(hospedeList);
		Assertions.assertEquals(2, hospedeList.size());
	}
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		Hospede hospede1 = new Hospede(null, "Joao",
                "joao@gmail.com",
                "(15)0000-0000");
		
		hospedeRepository.save(hospede1);
		
		Hospede saveHospede = hospedeRepository.findById(hospede1.getId()).get();
		
		Assertions.assertNotNull(saveHospede);
		Assertions.assertEquals(hospede1.getId(), saveHospede.getId());


}
    @DisplayName("Testando UPDATE")	
	@Test
	void testUpdateHospede() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria",
				                             "julia@gmail.com",
				                             "(00)0000-0000");
		
		hospedeRepository.save(hospede1);
		
		Hospede saveHospede = hospedeRepository.findById(hospede1.getId()).get();
		hospede1.setNome("Lucas");
		hospede1.setEmail("lucas@gmail.com");
		
		Hospede updateHospede = hospedeRepository.save(saveHospede);
		
		Assertions.assertNotNull(updateHospede);
		Assertions.assertEquals("Lucas",updateHospede.getNome());
		Assertions.assertEquals("lucas@gmail.com", updateHospede.getEmail());

}
    @DisplayName("Testando Delete")	
   	@Test
   	void testDeleteHospede() {
   		
   		Hospede hospede1 = new Hospede(null, "Julia Maria",
   				                             "julia@gmail.com",
   				                             "(00)0000-0000");
   		
   		hospedeRepository.save(hospede1);
   		
   		hospedeRepository.deleteById(hospede1.getId());
   		
   		
   		Optional<Hospede> hospedeOptional = hospedeRepository.findById(hospede1.getId());
   		Assertions.assertTrue(hospedeOptional.isEmpty());


   }
}