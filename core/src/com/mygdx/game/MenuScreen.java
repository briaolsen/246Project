package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuScreen extends ScreenAdapter {

    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    MyGdxGame game;
    Texture background;

    public MenuScreen(MyGdxGame game) {
        this.game = game;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        button = new TextButton("Button1", textButtonStyle);
        button.setPosition(Gdx.graphics.getWidth() /2,Gdx.graphics.getHeight()/2);
        stage.addActor(button);
    }

    @Override
    public void show() {
        background = new Texture("background.png");


    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, 0,0, Gdx.graphics.getWidth() * 2,Gdx.graphics.getHeight());
        game.batch.end();
        stage.draw();
    }

}
