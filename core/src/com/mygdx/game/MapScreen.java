package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class MapScreen extends ScreenAdapter {

    Texture background;
    Texture[] man;
    Texture[] manIdle;
    int manState = 0;
    int idleState = 0;
    int pause1 = 0;
    int pause2 = 0;
    Texture[] redMonster;
    int monsterX;
    int bgX = 0;

    MyGdxGame game;

    public MapScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        background = new Texture("background.png");

        man = new Texture[5];
        man[0] = new Texture("frame1.png");
        man[1] = new Texture("frame2.png");
        man[2] = new Texture("frame3.png");
        man[3] = new Texture("frame4.png");
        man[4] = new Texture("frame5.png");

        manIdle = new Texture[2];
        manIdle[0] = new Texture("standing1.png");
        manIdle[1] = new Texture("standing2.png");

        redMonster = new Texture[2];
        redMonster[0] = new Texture("redidle1.png");
        redMonster[1] = new Texture("redidle2.png");
        monsterX = Gdx.graphics.getWidth();

        Gdx.input.setInputProcessor(new InputAdapter() {

        });
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, bgX, 0,Gdx.graphics.getWidth() * 2,Gdx.graphics.getHeight());

        if (pause1 < 5) {
            pause1++;
        } else {
            if (manState < 4) {
                manState++;
            } else {
                manState = 0;
            }
            pause1 = 0;
        }

        if (pause2 < 10) {
            pause2++;
        } else {
            if(idleState < 1) {
                idleState++;
            } else {
                idleState = 0;
            }
            pause2 = 0;
        }

        if (monsterX > Gdx.graphics.getWidth()/2) {
            monsterX -= 4;
            bgX -= 4;
            game.batch.draw(man[manState],Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/8);
        } else {
            game.batch.draw(manIdle[idleState],Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/8);
        }

        game.batch.draw(redMonster[idleState], monsterX, Gdx.graphics.getHeight()/8);
        game.batch.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

}
