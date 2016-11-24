/*
 * Copyright 2016 Pigumer Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.pigumer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDaoTest {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    private UserDao sut;

    @Test
    public void test() throws Exception {
        User user = new User();
        user.id = "1";
        user.name = "FOO";
        int ret = sut.insert(user);
        assertThat(ret, is(1));
        
        user = new User();
        user.id = "2";
        user.name = "BAR";
        ret = sut.insert(user);
        assertThat(ret, is(1));
        
        user.id = "1";
        user.name = "TEST";
        ret = sut.update(user);
        assertThat(ret, is(1));
        
        user = sut.selectById("1");
        assertThat(user.name, is("TEST"));
        
        long len = sut.select(stream -> { 
            return stream.map(u -> {
                System.out.println(String.format("%s: %s", u.id, u.name));
                return u;
            }).count();
        });
        assertThat(len, is(2L));
        
        ret = sut.delete(user);
        assertThat(ret, is(1));
    }

}
