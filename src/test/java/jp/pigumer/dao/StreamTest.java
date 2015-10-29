package jp.pigumer.dao;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StreamTest {

    @Test
    public void test() {
       TestQuery tq = new TestQuery();
       long count = tq.testQuery(stream -> {
           return stream.count();
       });
       assertThat(count, is(Long.valueOf(3)));
    }
}
