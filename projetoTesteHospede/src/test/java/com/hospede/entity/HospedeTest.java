package com.hospede.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {

	private Hospede hospede;

	@BeforeEach
	void setUp() {
// Arrange
		hospede = new Hospede(1L, "Luis fernando", "luis@gmail.com", "(00)000000");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
// Act
		hospede.setId(2L);
// Assert
		Assertions.assertEquals(2L, hospede.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
// Act
		hospede.setNome("fausto");
// Assert
		Assertions.assertEquals("fausto", hospede.getNome());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
// Act
		hospede.setEmail("fausto@gmail.com");
// Assert
		Assertions.assertEquals("fausto@gmail.com", hospede.getEmail());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
// Act
		hospede.setTelefone("(15)996677425");
// Assert
		Assertions.assertEquals("(15)996677425", hospede.getTelefone());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
// Act
		Hospede novoHospede = new Hospede(3L, "carlos", "carlos@gmail.com", "(15)998745217");
// Assertion
		Assertions.assertAll("novoHospede", () -> Assertions.assertEquals(3L, novoHospede.getId()),
				() -> Assertions.assertEquals("carlos", novoHospede.getNome()),
				() -> Assertions.assertEquals("carlos@gmail.com", novoHospede.getEmail()),
				() -> Assertions.assertEquals("(15)998745217", novoHospede.getTelefone()));

	}
}
