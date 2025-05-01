package me.kopz.nubank.controller;

import me.kopz.nubank.entities.Contato;
import me.kopz.nubank.entities.DTOs.ClienteDTO;
import me.kopz.nubank.entities.DTOs.ContatoDTO;
import me.kopz.nubank.repository.ClienteRepository;
import me.kopz.nubank.service.ClienteService;
import me.kopz.nubank.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

  private final ClienteService clienteService;
  private final ContatoService contatoService;

  public ClienteController(ClienteService clienteService, ContatoService contatoService){
    this.clienteService = clienteService;
    this.contatoService = contatoService;
  }

  @PostMapping
  public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO){
    ClienteDTO cliente = clienteService.createCliente(clienteDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
  }

  @GetMapping("/{id}/contatos")
  public ResponseEntity<List<ContatoDTO>> getContactsById(@PathVariable("id") Long id){
    List<ContatoDTO> contatos = contatoService.findAllByClientId(id);
    return ResponseEntity.ok().body(contatos);
  }

  @GetMapping
  public List<ClienteDTO> getAllUsers(){
    return clienteService.getAllUsers();
  }
}
