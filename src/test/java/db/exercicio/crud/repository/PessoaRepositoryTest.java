package db.exercicio.crud.repository;

import db.exercicio.crud.model.Endereco;
import db.exercicio.crud.model.Pessoa;
import db.exercicio.crud.repository.PessoaRepository;
import db.exercicio.crud.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testCadastrarPessoa() {
        Pessoa pessoa = criarPessoa();

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa pessoaCadastrada = pessoaService.cadastrarPessoa(pessoa);

        assertEquals(pessoa.getNome(), pessoaCadastrada.getNome());
        assertEquals(pessoa.getCpf(), pessoaCadastrada.getCpf());
        assertEquals(pessoa.getDataNascimento(), pessoaCadastrada.getDataNascimento());
    }

    @Test
    void testListarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(criarPessoa());

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> pessoasListadas = pessoaService.listarPessoas();

        assertEquals(1, pessoasListadas.size());
    }

    @Test
    void testAtualizarPessoa() {
        Pessoa pessoaAtual = criarPessoa();
        Pessoa pessoaNova = criarPessoa();
        pessoaNova.setNome("santos");

        when(pessoaRepository.findByCpf(anyString())).thenReturn(pessoaAtual);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoaNova);

        pessoaService.atualizarPessoa(pessoaAtual.getCpf(), pessoaNova);

        assertEquals("santos", pessoaAtual.getNome());
    }

    @Test
    void testRemoverPessoa() {
        Pessoa pessoa = criarPessoa();

        when(pessoaRepository.findByCpf(anyString())).thenReturn(pessoa);

        pessoaService.removerPessoa(pessoa.getCpf());

        verify(pessoaRepository, times(1)).delete(any(Pessoa.class));
    }

    @Test
    void testMostrarIdade() {
        Pessoa pessoa = criarPessoa();

        when(pessoaRepository.findByCpf(anyString())).thenReturn(pessoa);

        int idade = pessoaService.mostrarIdade(pessoa.getCpf());

        assertEquals(33, idade);
    }

    private Pessoa criarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("francis");
        pessoa.setCpf("123456789");
        pessoa.setDataNascimento(LocalDateTime.of(1991,12,8,11,8));
        pessoa.setEndereco(new ArrayList<>());
        return pessoa;
    }
}
