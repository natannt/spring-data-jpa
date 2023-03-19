package projeto.spring.data.aula;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("java@gmail.com");
		usuarioSpringData.setIdade(32);
		usuarioSpringData.setLogin("java");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Maria");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
	}
	
	@Test
	public void testeConsulta() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);
		
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getId());
	}

}