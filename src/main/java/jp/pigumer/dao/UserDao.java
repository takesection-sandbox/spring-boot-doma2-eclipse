package jp.pigumer.dao;

import javax.inject.Inject;
import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import static org.seasar.doma.AnnotationTarget.*;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.springframework.stereotype.Component;

@AnnotateWith(annotations = {
    @Annotation(target = CLASS, type=Component.class),
    @Annotation(target = CONSTRUCTOR, type=Inject.class)})
@Dao
public interface UserDao {
   
    @Select
    User selectById(String id);
}
