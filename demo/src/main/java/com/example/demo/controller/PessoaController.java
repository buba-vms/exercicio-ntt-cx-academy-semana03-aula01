package com.example.demo.controller;


import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public List<Pessoa> listarTodasAsPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> retornarPessoaPeloId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping
    public ResponseEntity<Pessoa> inserirPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoaPeloId(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Optional<Pessoa> pessoaAtualizada = pessoaRepository.findById(id).map(p -> {
            if (pessoa.getNome() != null) {
                p.setNome(pessoa.getNome());
            }
            if (pessoa.getCpf() != null) {
                p.setCpf(pessoa.getCpf());
            }
            if (pessoa.getRg() != null) {
                p.setRg(pessoa.getRg());
            }
            if (pessoa.getDataDeNascimento() != null) {
                p.setDataDeNascimento(pessoa.getDataDeNascimento());
            }
            if (pessoa.getEstadoCivil() != null) {
                p.setEstadoCivil(pessoa.getEstadoCivil());
            }
            if (pessoa.getTelefone() != null) {
                p.setTelefone(pessoa.getTelefone());
            }
            if (pessoa.getEmail() != null) {
                p.setEmail(pessoa.getEmail());
            }
            return pessoaRepository.save(p);
        });
        return pessoaAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}