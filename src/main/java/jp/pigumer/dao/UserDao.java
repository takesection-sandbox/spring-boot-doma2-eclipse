package jp.pigumer.dao;

import java.util.function.Function;
import java.util.stream.Stream;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface UserDao {
   
    @Select
    User selectById(String id);
    
    @Select(strategy=SelectType.STREAM)
    Long select(Function<Stream<User>, Long> mapper);
    
    @Insert
    int insert(User user);
    
    @Update
    int update(User user);
    
    @Delete
    int delete(User user);
}
