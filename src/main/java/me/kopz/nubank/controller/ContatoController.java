package me.kopz.nubank.controller;

import me.kopz.nubank.entities.DTOs.ContatoDTO;
import me.kopz.nubank.repository.ContatoRepository;
import me.kopz.nubank.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

  private final ContatoService contatoService;

  public ContatoController(ContatoService contatoService){
    this.contatoService = contatoService;
  }

  @PostMapping
  public ResponseEntity<ContatoDTO> createContato(@RequestBody ContatoDTO contatoDTO){
    ContatoDTO contato = contatoService.createContato(contatoDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(contato);
  }
}