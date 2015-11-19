package jp.pigumer.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface UserDao {
   
    @Select
    User selectById(String id);
    
    @Insert
    int insert(User user);
    
    @Update
    int update(User user);
    
    @Delete
    int delete(User user);
}
