package com.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        class Quest {
            public void main(String[] args) {
                final Collection<String> c = new HashSet<>();
                c.add("s1");
                c.add("s2");
                c.add("s3");
                Iterator i = c.iterator();
                i.remove();
                System.out.println(c);
            }
        }
        assertTrue( true );
    }
}
