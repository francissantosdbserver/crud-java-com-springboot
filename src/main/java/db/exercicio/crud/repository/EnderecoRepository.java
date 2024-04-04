package db.exercicio.crud.repository;

import db.exercicio.crud.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findByCep(String cep);
}
