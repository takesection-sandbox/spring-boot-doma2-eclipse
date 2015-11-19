package jp.pigumer.dao;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import static org.seasar.doma.jdbc.entity.NamingType.*;

@Entity(naming = SNAKE_UPPER_CASE)
public class User {
    
    @Id
    String id;
    
    String name;
    
}
