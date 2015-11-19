package jp.pigumer.dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import jp.pigumer.RootApplication;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.jdbc.Config;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RootApplication.class)
public class UserDaoTest {

    @Inject
    private Config config;

    @Inject
    private UserDao sut;

    @PostConstruct
    void afterPropertiesSet() throws Exception {
        try (Connection con = config.getDataSource().getConnection();
                Statement stmt = con.createStatement()) {
            stmt.execute("DROP TABLE USER");
            stmt.execute("CREATE TABLE USER (ID CHAR(13) PRIMARY KEY, NAME VARCHAR(32))");
        }
    }

    @Test
    public void test() throws Exception {
        User user = new User();
        user.id = "1";
        user.name = "FOO";
        int ret = sut.insert(user);
        assertThat(ret, is(1));
        
        user.name = "TEST";
        ret = sut.update(user);
        assertThat(ret, is(1));
        
        user = sut.selectById("1");
        assertThat(user.name, is("TEST"));
        
        ret = sut.delete(user);
        assertThat(ret, is(1));
    }

}
