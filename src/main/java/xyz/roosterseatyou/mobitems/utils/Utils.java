package xyz.roosterseatyou.mobitems.utils;

import java.util.ArrayList;
import java.util.Random;

public class Utils {
    public static Object randomFromList(ArrayList<Object> list){
        int rIndex = MathUtils.randomIntegerFromRange(0, list.size());
        return list.get(rIndex);
    }
}
