package jp.pigumer;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.SqliteDialect;
import org.springframework.stereotype.Component;
import org.sqlite.JDBC;

@Component
public class SqliteConfig implements Config {

    @Override
    public DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(JDBC.class.getName());
        ds.setUrl("jdbc:sqlite:database.db");
        return ds;
    }

    @Override
    public Dialect getDialect() {
        return new SqliteDialect();
    }
    
}
