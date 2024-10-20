import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    @Test
    public void testDatabaseConnection() {
        try (Connection conn = ConnectionPool.getConnection()) {
            assertNotNull(conn);
            assertTrue(conn.isValid(1));
        } catch (SQLException e) {
            fail("Database connection failed: " + e.getMessage());
        }
    }
}