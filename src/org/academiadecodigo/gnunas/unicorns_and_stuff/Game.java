package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Handler;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.Map;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.GameObject;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.StuffFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.StuffType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Projectile;
import org.academiadecodigo.gnunas.unicorns_and_stuff.sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.*;

public class Game {

    private Map map;

    private static Player[] players;

    private static List<GameObject> stuffList;

    public static final int WIDTH = 1024;

    public static final int HEIGHT = 610;

    public static final int PADDING = 10;

    private final Timer timer;

    public Game(MapType mapType) {

        map = MapFactory.makeMap(mapType);

        stuffList = new LinkedList<>();

        players = new Player[2];

        Picture playerOnePicture = new Picture(900, 300, "resources/Unicorn/unicornLeft.png");
        Picture playerTwoPicture = new Picture(50, 300, "resources/Nazicorn/nazicornRight.png");

        String[] playerOneImagePaths = {
                "resources/Unicorn/unicornLeft.png",
                "resources/Unicorn/unicornRight.png"
        };

        String[] playerTwoImagePaths = {
                "resources/Nazicorn/nazicornLeft.png",
                "resources/Nazicorn/nazicornRight.png"
        };

        players[0] = new Player("Unicorn", Handler.getPlayerOneMovement(), playerOnePicture, playerOneImagePaths, Handler.getPlayerOneShooting());
        players[1] = new Player("Nazicorn", Handler.getPlayerTwoMovement(), playerTwoPicture, playerTwoImagePaths, Handler.getPlayerTwoShooting());

        timer = new Timer();
        timer.schedule(new StuffFactory(), 1000, 1000);

        drawScreen();

        process();

    }

    private void drawScreen() {
        Rectangle screen = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        screen.draw();
    }

    private void process() {
        final int FRAMES_PER_SECOND = 240;
        final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;

        long nextGameTick = System.currentTimeMillis();

        long sleepTime = 0;

        boolean gameRunning = true;

        while (gameRunning) {
            updateGame();
            render();

            nextGameTick += SKIP_TICKS;
            sleepTime = nextGameTick - System.currentTimeMillis();
            if (sleepTime >= 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void updateGame() {
        for (Player player : players) {
            player.move();
            player.shoot();

            Iterator<Projectile> iterator = player.getProjectilesList().iterator();

            while (iterator.hasNext()) {
                Projectile projectile = iterator.next();
                projectile.move();
                if(projectile.isDestroyed()) {
                    iterator.remove();
                }
            }

            if (player.isDead()){
                player.getCurrentSprite().load("resources/grave.png");
            }
        }
    }

    private void render() {

    }

    public static Player[] getPlayers() {
        return players;
    }

    public static List<GameObject> getStuffList() {
        return stuffList;
    }
}