package com.hospede.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {

	private Quarto quarto;

	@BeforeEach
	void setUp() {
// Arrange
		quarto = new Quarto();
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
// Act
		quarto.setId(2L);
// Assert
		Assertions.assertEquals(2L, quarto.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo num")
	void testNum() {
// Act
		quarto.setNum("72");
// Assert
		Assertions.assertEquals("72", quarto.getNum());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo tipo")
	void testTipo() {
// Act
		quarto.setTipo("quarto d/ casal");
// Assert
		Assertions.assertEquals("quarto d/ casal", quarto.getTipo());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
// Act
		Quarto novoQuarto = new Quarto(3L,"114","quarto casal");
// Assertion
		Assertions.assertAll("novoQuarto", () -> Assertions.assertEquals (3L, novoQuarto.getId()),
				() -> Assertions.assertEquals("101", novoQuarto.getNum()),
				() -> Assertions.assertEquals("quarto de solteiro", novoQuarto.getTipo()));

	}
}

