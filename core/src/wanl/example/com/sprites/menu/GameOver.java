package wanl.example.com.sprites.menu;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import wanl.example.com.base.Sprite;

public class GameOver extends Sprite {

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(0.07f);
        setBottom(0.009f);
    }
}
