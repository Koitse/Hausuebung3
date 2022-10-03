package net.htlgrieskirchen.pos2.kaltseisSebastian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public List<Weapons> weaponsList;
    public void readFile()
    {

        try {
            weaponsList = Files.lines(Path.of("weapons.csv")).skip(1).map(a -> a.split(";")).map(a-> new Weapons(a[0],CombatType.valueOf(a[1]),DamageType.valueOf(a[2]),Integer.parseInt(a[3]),Integer.parseInt(a[4]),Integer.parseInt(a[5]),Integer.parseInt(a[6]))).skip(1).toList();

            weaponsList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
