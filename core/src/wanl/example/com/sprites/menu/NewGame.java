package wanl.example.com.sprites.menu;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import wanl.example.com.screen.GameScreen;

public class NewGame extends ScaledTouchUpButton {

    private GameScreen gameScreen;

    public NewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
        setHeightProportion(0.05f);
        setTop(-0.012f);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
