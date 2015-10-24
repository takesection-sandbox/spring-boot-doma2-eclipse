package jp.pigumer.dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import jp.pigumer.RootApplication;
import jp.pigumer.SqliteConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RootApplication.class)
public class UserDaoTest {

    @Inject
    private SqliteConfig config;

    @Inject
    private UserDao sut;

    @PostConstruct
    void afterPropertiesSet() throws Exception {
        try (Connection con = config.getDataSource().getConnection();
                Statement stmt = con.createStatement()) {
            stmt.execute("DROP TABLE USER");
            stmt.execute("CREATE TABLE USER (ID CHAR(13) PRIMARY KEY, NAME VARCHAR(32))");
            stmt.execute("INSERT OR REPLACE INTO USER VALUES('1', 'TEST')");
        }
    }

    @Test
    public void test() throws Exception {
        User user = sut.selectById("1");
        assertThat(user.name, is("TEST"));
    }

}
