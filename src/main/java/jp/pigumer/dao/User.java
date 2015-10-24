package jp.pigumer.dao;

import org.seasar.doma.Entity;
import static org.seasar.doma.jdbc.entity.NamingType.*;

@Entity(naming = LENIENT_SNAKE_UPPER_CASE)
public class User {
    
    String id;
    
    String name;
    
}
