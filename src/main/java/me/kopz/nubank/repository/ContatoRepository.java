package me.kopz.nubank.repository;

import me.kopz.nubank.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

  List<Contato> findAllByClientId(Long clientId);
}