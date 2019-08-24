package de.devk.dojo.rockpaperscissors.server.controller;

import de.devk.dojo.rockpaperscissors.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
