package me.kopz.nubank.service;

import me.kopz.nubank.entities.Cliente;
import me.kopz.nubank.entities.DTOs.ClienteDTO;
import me.kopz.nubank.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public ClienteService(ClienteRepository clienteRepository){
    this.clienteRepository = clienteRepository;
  }

  public ClienteDTO createCliente(ClienteDTO clienteDTO){
    Cliente cliente = new Cliente();

    cliente.setName(clienteDTO.name());
    cliente.setContatos(clienteDTO.contatos());

    Cliente novoCliente = clienteRepository.save(cliente);
    return new ClienteDTO(novoCliente.getName(), novoCliente.getContatos());
  }

  public List<ClienteDTO> getAllUsers(){
    List<Cliente> clientes = clienteRepository.findAll();
    return clientes.stream().map(cliente -> new ClienteDTO(cliente.getName(), cliente.getContatos())).collect(Collectors.toList());
  }
}