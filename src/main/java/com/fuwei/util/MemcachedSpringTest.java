package com.fuwei.util;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ${MIND-ZR} on 2017/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:memcachedContext.xml")
public class MemcachedSpringTest {


    @Test
    public void testMemcached() {
        MemcachedUtil.put("hello", "word", 60);
        String hello = (String) MemcachedUtil.get("hello");
        TestCase.assertEquals("word", hello);

        /*for (int i = 0; i < 100; i++) {
            UserBean userBean = new UserBean("Jason" + i, "123456-" + i,"123456-" + i,"123456-" + i);
            MemcachedUtil.put("user" + i, userBean, 60);
            Object obj = MemcachedUtil.get("user" + i);
            TestCase.assertEquals(userBean, obj);
            System.out.println(userBean);

        }*/
    }

}