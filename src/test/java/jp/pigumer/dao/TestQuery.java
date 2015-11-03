package jp.pigumer.dao;

import java.util.function.Function;
import java.util.stream.Stream;

public class TestQuery {
 
    public Long testQuery(Function<Stream<String>, Long> function)
    {
        return function.apply(Stream.of("aaa", "bbb", "ccc"));
    }
}
