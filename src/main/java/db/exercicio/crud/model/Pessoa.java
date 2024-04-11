package db.exercicio.crud.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa" , initialValue = 1, allocationSize = 1)

public class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @Column(name = "pessoa_id")
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Campo não pode está vazio!")
    private String nome;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_nascimento")
    private LocalDateTime dataNascimento;

    @Column(name = "cpf", unique = true, nullable = false)
    @NotBlank(message = "Campo não pode está vazio!")
    private String cpf;

    @ManyToMany(mappedBy = "pessoas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEndereco(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
