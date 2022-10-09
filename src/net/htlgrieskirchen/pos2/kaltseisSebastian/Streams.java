package net.htlgrieskirchen.pos2.kaltseisSebastian;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Streams {

    private int[]numbers = new int[10000];

    private String[]strings = new String[10];

    int obergrenze = 100;
    public void fillArray()
    {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random()*obergrenze);
        }


        for (int i = 0; i < strings.length; i++) {
            strings[i]= String.valueOf(UUID.randomUUID());
        }



    }


    public double average(int[] numbers) {

        return Arrays.stream(numbers)
                .average().orElse(Double.NaN);

    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map((String::toUpperCase)).collect(Collectors.toList());

    }

    public Weapons findWeaponWithLowestDamage(List<Weapons> weapons) {
        return weapons.stream()
                .min(Comparator.comparing(Weapons::getDamage))
                .orElse(null);
    }

    public Weapons findWeaponWithHighestStrength(List<Weapons> weapons) {
        return weapons.stream()
                .sorted((w1, w2) -> Integer.compare(w2.getMinStrength(), w1.getMinStrength()))
                .min(Comparator.comparing(Weapons::getStrength))
                .orElse(null);
    }

    public List<Weapons> collectMissileWeapons(List<Weapons> weapons) {
        weapons = weapons.stream().filter(weapons1 -> weapons1.getDamageType().equals(DamageType.MISSILE)).collect(Collectors.toList());
        return weapons ;
    }

    public Weapons findWeaponWithLongestName(List<Weapons> weapons) {

        weapons = weapons.stream().filter(weapons1 -> weapons1.getName().length()==17).collect(Collectors.toList());
        return (Weapons) weapons;


    }

   public List<String> toNameList(List<Weapons> weapons) {

       return weapons.stream()
               .map(Weapons::getName)
               .collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapons> weapons) {
        return weapons.stream()
                .mapToInt(Weapons::getSpeed)
                .toArray();
    }

    public int sumUpValues(List<Weapons> weapons) {
        return (int) weapons.stream().mapToDouble(Weapons::getValue).sum();
    }

    public long sumUpHashCodes(List<Weapons> weapons) {
        return weapons.stream()
                .map(Weapons::hashCode)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<Weapons> removeDuplicates(List<Weapons> weapons) {
        return weapons.stream().distinct().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapons> weapons) {
        weapons.forEach(w -> w.setValue((int) (w.getValue() * 1.1D)));
    }


}
