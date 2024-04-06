package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(str -> Character.isUpperCase(str.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
       return list -> {
           for (int i = 0; i < list.size(); i++) {
               if (list.get(i) % 2 == 0) {
                   list.add(list.get(i));
               }
           }
       };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(str -> Character.isUpperCase(str.charAt(0)))
                .filter(str->str.endsWith("."))
                .filter(str->str.split(" ").length>3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream()
                .collect(Collectors.toMap(str -> str, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
       return (list1,list2) -> {
           List<Integer> result = new ArrayList<>(list1);
           result.addAll(list2);
           return result;
       };
    }
}
