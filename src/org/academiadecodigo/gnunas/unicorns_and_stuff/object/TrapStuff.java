package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;


public class TrapStuff extends GameObject {

    public TrapStuff(int x, int y, Player[] players) {
        super(x, y);
    }

    public void hit() {
        for (Player player : Game.getPlayers()) {
            if (isHitting(player)) {

                return;
            }
        }
    }
}
