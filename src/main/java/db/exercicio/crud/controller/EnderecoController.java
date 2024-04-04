package db.exercicio.crud.controller;

import db.exercicio.crud.model.Endereco;
import db.exercicio.crud.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/enderecos"})
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco>listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @GetMapping(path = {"/{id}"})
    public Endereco buscarEnderecoId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Endereco endereco = enderecoService.buscarEnderecoId(id);
        return ResponseEntity.ok().body(endereco).getBody();
    }

    @GetMapping("/cep/{cep}")
    public Endereco buscarEnderecoPorCep(@PathVariable String cep) {
        return enderecoService.buscarEnderecoPorCep(cep);
    }

    @PostMapping
    public Endereco cadastrarEndereco(@RequestBody Endereco novoEndereco) {
        return enderecoService.criarEndereco(novoEndereco);
    }

}
