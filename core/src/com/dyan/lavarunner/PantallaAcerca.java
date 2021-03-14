package com.dyan.lavarunner;

import com.badlogic.gdx.Screen;

public class PantallaAcerca extends Pantalla {

    private Juego juego;

    public PantallaAcerca(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        borrarPantalla(1,0,0);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
