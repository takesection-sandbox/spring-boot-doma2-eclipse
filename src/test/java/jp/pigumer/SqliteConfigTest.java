package jp.pigumer;

import java.sql.Connection;
import java.sql.Statement;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RootApplication.class)
public class SqliteConfigTest {
    
    @Inject
    private SqliteConfig config;
    
    @Test
    public void test() throws Exception {
       try (Connection con = config.getDataSource().getConnection();
               Statement stmt = con.createStatement()) {
           stmt.execute("CREATE TABLE IF NOT EXISTS USER (ID CHAR(13), NAME VARCHAR(32))");
       }
    }
}
