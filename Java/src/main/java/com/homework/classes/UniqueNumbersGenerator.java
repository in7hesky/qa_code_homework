package com.homework.classes;


import java.util.ArrayList;
import java.util.Collections;

//MEDICAL CARDS NUMS TRACKER
public class UniqueNumbersGenerator {

    private static final int LOWER_BOUND = 15;
    private static final int UPPER_BOUND = 35;

    private static final ArrayList<Integer> numbersPool = new ArrayList<>();

    static {
        for (int i = LOWER_BOUND; i < UPPER_BOUND; i++) {
            numbersPool.add(i);
        }
        Collections.shuffle(numbersPool);
    }

    public static int getUniqueInt() {
        int randomInt = numbersPool.get(0);
        numbersPool.remove(0);
        return randomInt;
    }
}
