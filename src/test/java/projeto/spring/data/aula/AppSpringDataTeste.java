package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.dao.InterfaceTelefone;
import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTeste {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;

	@Test
	public void testeInsert() {

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("java@gmail.com");
		usuarioSpringData.setIdade(32);
		usuarioSpringData.setLogin("java");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Natan Dadalt");

		interfaceSpringDataUser.save(usuarioSpringData);

	}

	@Test
	public void testeConsulta() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);

		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getId());
		
		for (Telefone telefone : usuarioSpringData.get().getTelefones()) {
			
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			System.out.println(telefone.getId());
			System.out.println(telefone.getUsuarioSpringData().getNome());
			
		}
	}

	@Test
	public void testeConsultaTodos() {

		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("----------------------------------------------------");

		}
	}

	@Test
	public void testeUpdate() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);

		UsuarioSpringData data = usuarioSpringData.get();

		data.setNome("Natan Dadalt Update Spring Data");
		data.setIdade(33);

		interfaceSpringDataUser.save(data);
	}

	@Test
	public void testeDelete() {

		// interfaceSpringDataUser.deleteById(3L);

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

		interfaceSpringDataUser.delete(usuarioSpringData.get());

	}

	@Test
	public void testeConsultaNome() {

		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Natan");

		for (UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("----------------------------------------------------");

		}
	}

	@Test
	public void testeConsultaNomeParam() {

		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("JAVA");

		System.out.println(usuarioSpringData.getEmail());
		System.out.println(usuarioSpringData.getNome());
		System.out.println(usuarioSpringData.getIdade());
		System.out.println(usuarioSpringData.getLogin());
		System.out.println(usuarioSpringData.getSenha());
		System.out.println(usuarioSpringData.getId());
		System.out.println("----------------------------------------------------");

	}
	
	@Test
	public void testeDeleteporNome() {
		interfaceSpringDataUser.deletePorNome("Maria");
	}
	
	@Test
	public void testeUpdateEmailPorNome() {
		interfaceSpringDataUser.updateEmailPorNome("testeupdate@gmail.com", "Pedro");
	}
	
	
	@Test
	public void testeInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(8L);
		
		Telefone telefone = new Telefone();
		telefone.setTipo("Casa");
		telefone.setNumero("2131212412411");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		
		interfaceTelefone.save(telefone);
	}
}
