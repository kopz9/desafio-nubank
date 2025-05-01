package me.kopz.nubank.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
  private List<Contato> contatos;

  public Cliente(){}

  public Cliente(Long id, String name, List<Contato> contatos) {
    this.id = id;
    this.name = name;
    this.contatos = contatos;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Contato> getContatos() {
    return contatos;
  }

  public void setContatos(List<Contato> contatos) {
    this.contatos = contatos;
  }
}
