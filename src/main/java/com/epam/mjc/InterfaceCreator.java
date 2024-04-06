package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return sourceList -> {
            boolean actualResult = true;
            for (String value : sourceList) {
                char[] charValue = value.toCharArray();
                int valueFirstLetter = charValue[0];
                if (!Character.isUpperCase(valueFirstLetter)) {
                    actualResult = false;
                    break;
                }

            }
            return actualResult;
        };
    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {

        return sourceList -> {
            List<Integer> resultList = new ArrayList<>();
            resultList.clear();

            for (int value : sourceList) {
                if (value % 2 == 0) {
                    resultList.add(value);
                }

            }
            sourceList.addAll(resultList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> result = new ArrayList<>();
        {
            return () -> {
                for (String value : values) {
                    if (Character.isUpperCase(value.charAt(0)) && value.endsWith(".") && value.length() > 3) {
                        result.add(value);
                    }

                }
                return result;

            };
        }
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {

        return sourceKeys -> {
            Map<String, Integer> resultMap = new HashMap<>();
            for (String key : sourceKeys) {
                Integer value = key.length();
                resultMap.put(key, value);
            }
            return resultMap;
        };
    }



    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {


        return (sourceList1, sourceList2) -> {
            List<Integer> resultList = new ArrayList<>();
            resultList.addAll(sourceList1);
            resultList.addAll(sourceList2);
            return resultList;
        };
    }
}