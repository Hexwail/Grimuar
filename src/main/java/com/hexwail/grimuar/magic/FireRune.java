package com.hexwail.grimuar.magic;

public class FireRune extends Rune {
    public FireRune() {
        super("Fire");
    }

    @Override
    public void activate() {
        // Логіка активації вогняної руни
        System.out.println("Fire rune activated!");
    }
}
