package net.htlgrieskirchen.pos2.kaltseisSebastian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public List<Weapons> weaponsList;

    public void readFile() {
        Printable printable = new Printable() {
            @Override
            public void print(List<Weapons> weapons) {
                weapons.forEach(weapons1 -> System.out.println(weapons));
            }
        };
        try {
            weaponsList = Files.lines(Path.of("weapons.csv")).skip(1).map(a -> a.split(";")).map(a -> new Weapons(a[0], CombatType.valueOf(a[1]), DamageType.valueOf(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]), Integer.parseInt(a[5]), Integer.parseInt(a[6]))).collect(Collectors.toList());
            weaponsList.sort(Comparator.comparingInt(Weapons::getDamage));
            weaponsList.sort(Comparator.comparing(Weapons::getCombatType));
            weaponsList.sort(Comparator.comparing(Weapons::getDamageType));
            weaponsList.sort(Comparator.comparing(Weapons::getName));


            System.out.println("Printable:");
            printable.print(weaponsList);



        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}



