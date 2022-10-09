package net.htlgrieskirchen.pos2.kaltseisSebastian;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Zahlen {

    final Predicate<Integer> isEven = integer -> integer % 2 == 0;
    final Predicate<Integer> isPositive = integer -> integer >= 0;
    final Predicate<Integer> isNull = integer -> integer == 0;
    final Predicate<Integer> isnull = Objects::isNull;
    final Predicate<String> isShortWord = s -> s.length()<=4;

}
