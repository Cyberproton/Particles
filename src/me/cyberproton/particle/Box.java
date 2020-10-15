package me.cyberproton.particle;

import java.util.ArrayList;
import java.util.Random;

public class Box {
    private static Box instance;
    private static Random random = new Random();

    private ArrayList<Particle> particles = new ArrayList<>();
    private int width;
    private int height;

    private Box() { }

    public static Box getInstance() {
        if (instance == null) {
            instance = new Box();
        }
        return instance;
    }

    public void run() {
        for (int i = -1; i < height + 2; i++) {
            for (int j = -1; j < width + 2; j++) {
                if (i == -1 || i == height + 1 || j == -1 || j == width + 1) {
                    System.out.print('x');
                }
                else {
                    boolean hasParticle = false;

                    for (Particle particle : particles) {
                        if (particle.getY() == i && particle.getX() == j) {
                            hasParticle = true;
                            break;
                        }
                    }

                    // If the draw position match any particles' position, then draw it out
                    // Else draw empty cell
                    if (hasParticle) {
                        System.out.print('.');
                    }
                    else {
                        System.out.print(' ');
                    }
                }

                if (j == width + 1) {
                    System.out.println("");
                }
            }
        }
        System.out.println("");

        for (Particle particle : particles) {
            moveParticle(particle);
        }


        for (int i = 0; i < particles.size(); i++) {
            for (int j = i; j < particles.size(); j++) {
                // Avoid checking itself
                if (j == i) {
                    continue;
                }

                Particle p1 = particles.get(i);
                Particle p2 = particles.get(j);

                if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
                    addParticle();
                }
            }
        }
    }

    public void moveParticle(Particle particle) {
        int nextX = particle.getX() + particle.getDirection().getX();
        int nextY = particle.getY() + particle.getDirection().getY();

        if (nextX < 0 || nextX > width || nextY < 0 || nextY > height) {
            Direction opposite = Direction.getOpposite(particle.getDirection());
            particle.setDirection(opposite);
        }
        else {
            particle.setX(nextX);
            particle.setY(nextY);
        }
    }

    public void addParticle() {
        Particle particle = new Particle();

        particle.setX(random.nextInt(width));
        particle.setY(random.nextInt(height));

        Direction[] directions = Direction.values();
        Direction direction = directions[random.nextInt(directions.length)];

        particle.setDirection(direction);

        particles.add(particle);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
