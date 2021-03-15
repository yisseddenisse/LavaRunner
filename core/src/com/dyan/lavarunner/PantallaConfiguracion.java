package com.dyan.lavarunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

/*
 * Autor: C.Daniel Alvarez C.
 * */
public class PantallaConfiguracion extends Pantalla{
    //Referencia al juego principal
    private Juego juego;
    //Fondo
    private Texture texturaFondo;
    //Escena
    private Stage escenaMenu;

    //titulo
    private Sprite tituloConfig;



    public PantallaConfiguracion(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void show() {
        crearConfig();

    }
    private void crearConfig() {

        escenaMenu=new Stage(vista);


        texturaFondo=new Texture("configuracion/fondoConfiguracion.jpg");

        Button btnRegresar=crearBoton("configuracion/btn_regresar.png");
        btnRegresar.setPosition(ANCHO/5,ALTO/5, Align.center);
        escenaMenu.addActor(btnRegresar);
        //Registrar el evento de click para el boton
        btnRegresar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Cambiar pantalla
                juego.setScreen(new PantallaMenu(juego));
            }
        });

        Button btnMute=crearBoton("configuracion/btnMute.png");
        btnMute.setPosition(ANCHO/2,ALTO/1.8f, Align.center);
        escenaMenu.addActor(btnMute);
        //Registrar el evento de click para el boton
        btnMute.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Cambiar pantalla
                //juego.setScreen(new PantallaMenu(juego));
            }
        });
        //ESCENA SE ENCARGA DE ATENDER LOS EVENTOS DE ENTRADA
        Gdx.input.setInputProcessor(escenaMenu);
    }

    private Button crearBoton(String archivo) {
        Texture texturaBoton=new Texture(archivo);
        TextureRegionDrawable trdBtn=new TextureRegionDrawable(texturaBoton);

        return new Button(trdBtn);
    }

    @Override
    public void render(float delta) {
        borrarPantalla(1,0,1);
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        batch.draw(texturaFondo,0,0);

        batch.end();

        //Escena despues del FONDO
        escenaMenu.draw();

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
