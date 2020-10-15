package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Handler;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class UnicornsTest {
    public static void main(String[] args) {

        //TODO siga pessoal

        new Game(MapType.STANDARD);

        /*Rectangle rectangle = new Rectangle(0, 0, 1500, 500);
        rectangle.draw();
        Picture picture = new Picture(1200, 0, "resources/unicorn.png");
        picture.draw();
        Picture picture2 = new Picture(0, 0, "resources/unicorn2.png");
        picture2.draw();*/

        Handler keyBindings = new Handler();
        Keyboard keyboard = new Keyboard(keyBindings);

        KeyboardEvent goUp = new KeyboardEvent();
        KeyboardEvent goDown = new KeyboardEvent();
        KeyboardEvent goLeft = new KeyboardEvent();
        KeyboardEvent goRight = new KeyboardEvent();

        KeyboardEvent goUpW = new KeyboardEvent();
        KeyboardEvent goDownS = new KeyboardEvent();
        KeyboardEvent goLeftA = new KeyboardEvent();
        KeyboardEvent goRightD = new KeyboardEvent();

        //Player One
        goUp.setKey(KeyboardEvent.KEY_UP);
        goUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goUp);
        goDown.setKey(KeyboardEvent.KEY_DOWN);
        goDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goDown);
        goLeft.setKey(KeyboardEvent.KEY_LEFT);
        goLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goLeft);
        goRight.setKey(KeyboardEvent.KEY_RIGHT);
        goRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goRight);

        //Player Two
        goUpW.setKey(KeyboardEvent.KEY_W);
        goUpW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goUpW);
        goDownS.setKey(KeyboardEvent.KEY_S);
        goDownS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goDownS);
        goLeftA.setKey(KeyboardEvent.KEY_A);
        goLeftA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goLeftA);
        goRightD.setKey(KeyboardEvent.KEY_D);
        goRightD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goRightD);

    }
}