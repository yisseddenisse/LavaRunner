package com.dyan.lavarunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class PantallaMenu extends Pantalla {

    // Referencia al juego principal
    private Juego juego;

    //Textura
    private Texture texturaFondo;

    //Escena
    private Stage escenaMenu;

   public PantallaMenu(Juego juego) {this.juego = juego;}

    @Override
    public void show() {
        crearMenu();
    }

    private void crearMenu() {
        texturaFondo = new Texture("menuPrincipal/fondo.png");

        // MENU necesitamos una escena
        escenaMenu = new Stage(vista);

        //Boton Jugar
        Button btnJugar = crearBoton("menuPrincipal/button_jugar.png", "menuPrincipal/button_jugar-2.png");
        btnJugar.setPosition(2*ANCHO/3, ALTO/2, Align.center);
        escenaMenu.addActor(btnJugar);
        // REGISTRAR el evento de click para el boton
        btnJugar.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Cambiar a pantalla (Seleccionar Nivel)
                juego.setScreen(new PantallaSeleccionarNivel(juego));
            }

        });

        //Boton Acerca de
        Button btnAcerca = crearBoton("menuPrincipal/button_acerca-de.png", "menuPrincipal/button_acerca-de-2.png");
        btnAcerca.setPosition(ANCHO/4, 3*ALTO/4, Align.center);
        escenaMenu.addActor(btnAcerca);
        btnAcerca.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaAcerca(juego));
            }

        });

        //Boton Ayuda
        Button btnAyuda = crearBoton("menuPrincipal/button_ayuda.png", "menuPrincipal/button_ayuda-2.png");
        btnAyuda.setPosition(ANCHO/4, (3*ALTO/4)-120, Align.center);
        escenaMenu.addActor(btnAyuda);
        btnAyuda.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaAyuda(juego));
            }

        });

        //Boton Configuracion
        Button btnConfiguracion = crearBoton("menuPrincipal/button_configuracion.png", "menuPrincipal/button_configuracion-2.png");
        btnConfiguracion.setPosition(ANCHO/4, (3*ALTO/4)-240, Align.center);
        escenaMenu.addActor(btnConfiguracion);
        btnConfiguracion.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                juego.setScreen(new PantallaConfiguracion(juego));
            }

        });

        //Boton Salir
        Button btnSalir = crearBoton("menuPrincipal/button_salir.png", "menuPrincipal/button_salir-2.png");
        btnSalir.setPosition(ANCHO/4, (3*ALTO/4)-360, Align.center);
        escenaMenu.addActor(btnSalir);

        // LA ESCENA SE ENCARGA DE LOS EVENTOS DE ENTRADA
        Gdx.input.setInputProcessor(escenaMenu);
    }

    private Button crearBoton(String archivo, String archivoInverso) {
        Texture texturaBoton = new Texture(archivo);
        TextureRegionDrawable trdBtnMario = new TextureRegionDrawable(texturaBoton);
        // inverso
        Texture texturaInverso = new Texture(archivoInverso);
        TextureRegionDrawable trdBtnInverso = new TextureRegionDrawable(texturaInverso);

        return new Button(trdBtnMario,trdBtnInverso);
    }

    @Override
    public void render(float delta) {
        borrarPantalla(0,1,1);
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        batch.draw(texturaFondo,0,0);
        batch.end();

        // Escena (DESPUES DEL FONDO)
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
