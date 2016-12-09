package com.hibernate.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Endereco;
import com.hibernate.model.EstadoCivil;
import com.hibernate.model.Usuario;
import com.hibernate.model.Veiculo;

public class UsuarioTeste {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		// Endereco endereco = new Endereco();
		// Endereco enderecoComercial = new Endereco();
		usuario.setNome("Teste5");
		usuario.setDataNascimento(new Date());
		usuario.setIdade(30);
		usuario.setEstadoCivil(EstadoCivil.CASADO);
		
		Veiculo fusca = new Veiculo("Fusca", 1986);
		usuario.setVeiculo(fusca);

		/*
		 * endereco.setLogradouro("Rua alalala"); endereco.setNumero(32);
		 * endereco.setCidade("Cidade");
		 * 
		 * enderecoComercial.setLogradouro("Rua bbbb");
		 * enderecoComercial.setNumero(12);
		 * enderecoComercial.setCidade("Cidade2");
		 */
		// usuario.setEndereco(endereco);

		// usuario.getEnderecos().add(endereco);
		// usuario.getEnderecos().add(enderecoComercial);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();


		//session.save(fusca);
		session.save(usuario);
		session.getTransaction().commit();
		Usuario usuarioBanco = (Usuario) session.get(Usuario.class, 1);
		session.close();

		System.out.println("Nome :" + usuarioBanco.getNome());

	}
}
