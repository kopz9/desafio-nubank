package me.kopz.nubank.entities.DTOs;

import me.kopz.nubank.entities.Contato;

import java.util.List;

public record ClienteDTO(String name, List<Contato> contatos) {
}
