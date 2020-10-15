package me.cyberproton.particle;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Box box = Box.getInstance();

        box.setWidth(10);
        box.setHeight(5);

        box.addParticle();
        box.addParticle();
        box.addParticle();

        while (true) {
            Thread.sleep(1000);
            box.run();
        }
    }
}
