package wanl.example.com;

import com.badlogic.gdx.Game;

import wanl.example.com.screen.MenuScreen;

public class Star2dGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
