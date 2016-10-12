package br.com.teste.concrete.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.teste.concrete.entity.Usuario;

@Repository
public interface CadastroRepository extends CrudRepository<Usuario, Long> {

	Usuario findByEmail(String email);

	Usuario save(Usuario user);
}
