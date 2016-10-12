package br.com.teste.concreteste;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.teste.concrete.TesteConcrete;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TesteConcrete.class)
@WebAppConfiguration
public class TesteConcreteTests {

	@Test
	public void contextLoads() {
	}

}
