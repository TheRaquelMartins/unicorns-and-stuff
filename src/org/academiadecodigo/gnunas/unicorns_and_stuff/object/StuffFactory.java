package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

import java.awt.*;
import java.util.TimerTask;

public class StuffFactory {

    public static GameObject createNewStuff(StuffType stuffType, int x, int y) {
        switch (stuffType) {
            case TRAP:
                return new TrapStuff(x, y, "resources/Objects/trap.png");
            case SHIT:
                return new ShitStuff(x, y, "resources/Objects/shit.png");
            case METEORS:
                return new MeteorStuff(x, y, "resources/Objects/meteor.png");
        }
        return null;
    }
}
