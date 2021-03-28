package com.gisela.tddbdd.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.gisela.tddbdd.validadorCpf.models.Cliente;


@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("50933912048");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("50933912011");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("5093391204");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComFormatacao() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("509.339.120-48");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComFormatacao() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("509.339.120-11");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("509.339.120-11");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("509.339.120-48   ");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("   509.339.120-48");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspaco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("509.   339.120-48");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComLetra() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jane Doe");
		cliente.setCpf("5o9.339.120-48");
		assertEquals(false, cliente.validarCPF());
	}

}
