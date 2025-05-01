package me.kopz.nubank.service;

import jakarta.transaction.Transactional;
import me.kopz.nubank.entities.Cliente;
import me.kopz.nubank.entities.Contato;
import me.kopz.nubank.entities.DTOs.ContatoDTO;
import me.kopz.nubank.repository.ClienteRepository;
import me.kopz.nubank.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

  private final ContatoRepository contatoRepository;
  private final ClienteRepository clienteRepository;

  public ContatoService(ContatoRepository contatoRepository, ClienteRepository clienteRepository){
    this.contatoRepository = contatoRepository;
    this.clienteRepository = clienteRepository;
  }

  @Transactional
  public ContatoDTO createContato(ContatoDTO contatoDTO){
    Cliente cliente = clienteRepository.findById(contatoDTO.clientId()).orElseThrow(() -> new RuntimeException("EROOO"));
    Contato contato = new Contato();

    contato.setName(contatoDTO.name());
    contato.setNumber(contatoDTO.number());
    contato.setClient(cliente);

    Contato newContato = contatoRepository.save(contato);
    return new ContatoDTO(newContato.getName(), newContato.getNumber(), newContato.getClient().getId());
  }

  public List<ContatoDTO> findAllByClientId(Long clientId){
    List<Contato> contatos = contatoRepository.findAllByClientId(clientId);

    return contatos.stream()
        .map(contato -> new ContatoDTO(contato.getName(),  contato.getNumber(), contato.getClient().getId()))
        .collect(Collectors.toList());
  }
}