package com.dyan.lavarunner;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
Esta clase representa a la aplicacion que corre, el objeto esta vivo durante toda la aplicacion
Autor: Norma P Iturbide
*/

public class Juego extends Game {
	SpriteBatch batch;
	Texture img;

	@Override
	public void create() {
		//Muestra la primera pantalla
		setScreen(new PantallaMenu(this));
	} //Esta es la primera pantalla visible

	//Este es un comentario de amauri 
}
