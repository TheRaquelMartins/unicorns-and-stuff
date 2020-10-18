package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

import java.util.List;

public class Projectile {
    private Ellipse projectileSprite;
    private int damageAmount;
    private Direction direction;
    private int projectileSpeed;

    private Player player;

    public Projectile(int x, int y, int damageAmount, Direction direction, Player player) {
        this.damageAmount = damageAmount;
        this.direction = direction;
        projectileSprite = new Ellipse(x, y, 17, 17);
        projectileSpeed = 4;
        this.player = player;
        projectileSprite.fill();
    }

    public void move() {
        if (hitsX()) {
            remove(player.getProjectilesList());
        }

        if (hitsY()) {
            remove(player.getProjectilesList());
        }

        switch (direction) {
            case UP:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(0, -1);
                }
                break;
            case DOWN:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(0, 1);
                }
                break;
            case LEFT:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(-1, 0);
                }
                break;
            case RIGHT:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(1, 0);
                }

        }
    }

    // TODO Erase from memory
    public void remove(List<Projectile> projectiles) {
        projectileSprite.delete();
        projectiles.remove(this);
    }

    public int getX() {
        return projectileSprite.getX();
    }

    public int getY() {
        return projectileSprite.getY();
    }

    public int getWidth() {
        return projectileSprite.getWidth();
    }

    public int getHeight() {
        return projectileSprite.getHeight();
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    private boolean hitsY() {
       return getY() + getHeight() >= Game.HEIGHT || getY() <= Game.PADDING;
    }

    private boolean hitsX() {
       return getX() + getWidth() >= Game.WIDTH || getX() <= Game.PADDING;
    }
}
