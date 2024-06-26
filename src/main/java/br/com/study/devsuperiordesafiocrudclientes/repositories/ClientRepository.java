package br.com.study.devsuperiordesafiocrudclientes.repositories;

import br.com.study.devsuperiordesafiocrudclientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
