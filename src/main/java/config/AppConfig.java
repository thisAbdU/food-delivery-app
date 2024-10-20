import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool();
    }

    // Add more beans as needed
}