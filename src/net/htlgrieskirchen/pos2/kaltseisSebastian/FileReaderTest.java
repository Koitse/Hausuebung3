package net.htlgrieskirchen.pos2.kaltseisSebastian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void comperator() {
        FileReader fileReader = new FileReader();
        Weapons weapons = new Weapons("AUG",CombatType.MELEE,DamageType.BLUNT,20000,300,200,40);
        Weapons weapons1 = new Weapons("AUG",CombatType.MELEE,DamageType.BLUNT,200,300,200,40);

    }
}