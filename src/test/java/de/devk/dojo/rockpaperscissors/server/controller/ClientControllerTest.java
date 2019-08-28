package de.devk.dojo.rockpaperscissors.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.devk.dojo.rockpaperscissors.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created based with this tutorial:
 * https://medium.com/@sheikarbaz5/spring-boot-with-tdd-test-driven-development-part-i-be1b90da51e
 *
 * @author hv11156
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ClientService gameService;

    @Test
    void registerNewClient() throws Exception {

        Client client = new Client("normal Client", 123456789L);
        when(gameService.saveClient(any(Client.class))).thenReturn(client);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(client);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/registernewclient")
                .contentType(MediaType.APPLICATION_JSON).content(json));
        result.andExpect(status().isCreated()).andExpect(jsonPath("$.name").value(client.getName()))
                .andExpect(jsonPath("$.registrationCode").value(client.getRegistrationCode()));
    }
}
