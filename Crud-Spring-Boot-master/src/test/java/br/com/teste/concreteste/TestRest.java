package br.com.teste.concreteste;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.teste.concrete.TesteConcrete;
import br.com.teste.concrete.entity.Phones;
import br.com.teste.concrete.entity.Usuario;

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { TesteConcrete.class })
@WebAppConfiguration
public class TestRest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testCadastro() throws Exception {

		String nome = "kolarik";
		String email = "teste@teste.com.br";
		String password = "123";
		ArrayList<Phones> phone = new ArrayList<Phones>();

		Usuario vo = new Usuario();
		vo.setEmail(email);
		vo.setLast_login(Calendar.getInstance());
		vo.setModified(Calendar.getInstance());
		vo.setModified(Calendar.getInstance());
		vo.setNome(nome);
		vo.setPassword(password);
		vo.setPhones(phone);

		Gson gson = new Gson();
		String json = gson.toJson(vo);

		this.mockMvc.perform(get("/api/cadastro").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

	@Test
	public void testLogin() throws Exception {

		String nome = "kolarik";
		String email = "teste@teste.com.br";

		Usuario vo = new Usuario();
		vo.setEmail(email);
		vo.setLast_login(Calendar.getInstance());
		vo.setModified(Calendar.getInstance());
		vo.setModified(Calendar.getInstance());
		vo.setNome(nome);

		Gson gson = new Gson();
		String json = gson.toJson(vo);

		this.mockMvc.perform(get("/api/login").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}
}
