package app.reserve;

import app.reserve.service.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ReserveApplicationTests {

    @MockBean
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        // Testy
    }
}