package db.exercicio.crud.service;

import db.exercicio.crud.model.Endereco;
import db.exercicio.crud.model.Pessoa;
import db.exercicio.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    //Cadastrar Pessoa
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        for (Endereco endereco : pessoa.getEnderecos()) {
            endereco.getPessoas().add(pessoa);
        }
        return pessoaRepository.save(pessoa);
    }

    //Listar Pessoa
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }


    //Atualizar Pessoa
    public void atualizarPessoa(String cpf, Pessoa pessoaNova) {
        Pessoa pessoaAtual = pessoaRepository.findByCpf(cpf);
        if (pessoaAtual != null) {
           pessoaAtual.setCpf(pessoaNova.getCpf());
           pessoaAtual.setNome(pessoaNova.getNome());
           pessoaAtual.setEndereco(pessoaNova.getEnderecos());
           pessoaAtual.setDataNascimento(pessoaNova.getDataNascimento());
           pessoaRepository.save(pessoaAtual);
        }
    }

    //Excluir Pessoa
    public void removerPessoa(String cpf) {
        Pessoa pessoaDelete = pessoaRepository.findByCpf(cpf);
        pessoaRepository.delete(pessoaDelete);
    }

    //Mostrar idade Pessoa
    public int mostrarIdade(String cpf) {
        Pessoa idadePessoa = pessoaRepository.findByCpf(cpf);
        Date dataNascimento = idadePessoa.getDataNascimento();
        int idade = calcularIdade(dataNascimento);
        return idade;
    }

    public int calcularIdade(Date dataNascimento) {
        Calendar calendar = Calendar.getInstance();
        Calendar hoje = Calendar.getInstance();
        calendar.setTime(dataNascimento);
        int idade = hoje.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        return idade;
    }


    public Pessoa vinculaEnderecoPessoa(String cpf) {
             Pessoa pessoa = pessoaRepository.findByCpf(cpf);
             System.out.println("PESSSOA ################## " + pessoa);
             return pessoa;
    }



//    public Pessoa vinculaEnderecoPessoa(@RequestBody String cpf, Endereco endereco) {
//        System.out.println("CPF: #############################" +cpf);
//        System.out.println("ENDERECO: ########################"+endereco);
//        Optional<Pessoa> optionalPessoa = Optional.ofNullable(pessoaRepository.findByCpf(cpf));
//        System.out.println("optionalPessoa: #################" + optionalPessoa);
//            Pessoa pessoa = optionalPessoa.get();
//            System.out.println("PESSOA: #################" + pessoa);
//            pessoa.getEnderecos().add(endereco);
//            endereco.setPessoas((Set<Pessoa>) pessoa);
//            return pessoaRepository.save(pessoa);
//    }
}
