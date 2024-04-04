package db.exercicio.crud.controller;

import db.exercicio.crud.model.Endereco;
import db.exercicio.crud.model.Pessoa;
import db.exercicio.crud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/pessoas"})
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa cadastrarPessoa = pessoaService.cadastrarPessoa(pessoa);
        return new ResponseEntity<>(cadastrarPessoa, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

   @PutMapping(path = "/atualizar-pessoas/{cpf}")
   public ResponseEntity<Void> atualizarPessoa(@PathVariable String cpf, @RequestBody Pessoa pessoa) {
        pessoaService.atualizarPessoa(cpf,pessoa);
        return ResponseEntity.noContent().build();
   }

   @DeleteMapping(path = "/{cpf}")
   public ResponseEntity<Void> removerPessoa(@PathVariable String cpf) {
        pessoaService.removerPessoa(cpf);
        return ResponseEntity.noContent().build();
   }

   @GetMapping(path = "/{cpf}/idade")
   public ResponseEntity<String> mostrarIdade(@PathVariable String cpf) {
        String idade = String.valueOf(pessoaService.mostrarIdade(cpf));
        return ResponseEntity.ok(idade);
   }

    @GetMapping(path = "/vinculaEnderecoPessoa/{cpf}")
    public Pessoa vinculaEnderecoPessoa(@PathVariable String cpf) {
        System.out.println("BODY CONTROLLER ###################### " + cpf);
        System.out.println("BODY CONTROLLER ENDERECO ###################### ");

        return pessoaService.vinculaEnderecoPessoa(cpf);
    }


}
