package de.devk.dojo.rockpaperscissors.server.controller;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.devk.dojo.rockpaperscissors.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
