/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.pigumer.dao;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * @author take
 */
public class TestQuery {
 
    public Long testQuery(Function<Stream<String>, Long> function)
    {
        return function.apply(Stream.of("aaa", "bbb", "ccc"));
    }
}
