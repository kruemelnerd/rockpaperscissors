package de.devk.dojo.rockpaperscissors.server.controller;

import de.devk.dojo.rockpaperscissors.model.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientRepository clientRepository;

    @AfterEach
    void tearDown() {
        clientRepository.deleteAll();
    }

    @Test
    void saveAClient() {
        ClientService service = new ClientService(clientRepository);
        Client client = new Client("Client Name", 123L);
        service.saveClient(client);
        assertThat(clientRepository.count(), is(1L));
    }
}
