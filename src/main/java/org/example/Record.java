package org.example;

import java.util.ArrayList;


public class Record {
    enum Type{
        Relevant,
        Irrelevant,
        RelevantNotFound
    }
    public static void fillRecord() {
        int n = 10;
        int m = 15;
        ArrayList<Type> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double j = Math.random();
            if (j > 0.5) {
                result.add(Type.Relevant);
            } else {
                result.add(Type.Irrelevant);
            }
        }
        for (int i = n; i < m; i++) {
            result.add(Type.RelevantNotFound);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(i + 1 + " " + result.get(i));
        }
    }
}
