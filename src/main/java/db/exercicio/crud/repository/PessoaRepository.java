package db.exercicio.crud.repository;

import db.exercicio.crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

   Pessoa findByCpf(String cpf);

}
