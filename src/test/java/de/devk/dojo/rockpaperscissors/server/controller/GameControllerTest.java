package de.devk.dojo.rockpaperscissors.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.devk.dojo.rockpaperscissors.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
/**
 * Created based with this tutorial:
 * https://medium.com/@sheikarbaz5/spring-boot-with-tdd-test-driven-development-part-i-be1b90da51e
 * @author hv11156
 *
 */
public class GameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Test
    void getAllPlayers() throws Exception {
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player("Philipp"));
        playerList.add(new Player("OtherPlayer"));


        when(gameService.findAllPlayers()).thenReturn(playerList);

        mockMvc.perform(MockMvcRequestBuilders.get("/players").contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$", hasSize(2))) //
                .andDo(print());
    }


    @Test
    void sucessfullyCreateANewPlayer() throws Exception {
        Player player = new Player("Philipp");
        when(gameService.savePlayer(any(Player.class))).thenReturn(player);


        ObjectMapper objectMapper = new ObjectMapper();
        String playerJSON = objectMapper.writeValueAsString(player);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(playerJSON));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Philipp"));
    }
}
