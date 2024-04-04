package db.exercicio.crud.service;


import db.exercicio.crud.model.Endereco;
import db.exercicio.crud.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarEnderecoId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return enderecoRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }


    public Endereco buscarEnderecoPorCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }

    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

}
