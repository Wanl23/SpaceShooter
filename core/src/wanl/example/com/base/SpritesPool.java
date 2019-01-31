package wanl.example.com.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public abstract class SpritesPool<T extends Sprite> {

    protected List<T> activeObjects = new ArrayList<T>();
    protected List<T> freeObjects = new ArrayList<T>();

    protected abstract T newObject();

    public T obtain() {
        T objects;
        if (freeObjects.isEmpty()) {
            objects = newObject();
        } else {
            objects = freeObjects.remove(freeObjects.size() - 1);
        }
        activeObjects.add(objects);
        return objects;
    }

    public void updateActiveSprites(float delta) {
        for (int i = 0; i < activeObjects.size(); i++) {
            T sprite = activeObjects.get(i);
            sprite.update(delta);
        }
    }

    public void drawActiveSprites(SpriteBatch batch) {
        for (int i = 0; i < activeObjects.size(); i++) {
            T sprite = activeObjects.get(i);
            sprite.draw(batch);
        }
    }

    public void freeDestroyesActiveSprites() {
        for (int i = 0; i < activeObjects.size(); i++) {
            T sprite = activeObjects.get(i);
            if (sprite.isDestroyed()){
                free(sprite);
                i--;
            }
        }
    }

    public void free(T object) {
        activeObjects.remove(object);
        freeObjects.add(object);
        object.flushDestroy();
    }

    public List<T> getActiveObjects() {
        return activeObjects;
    }

    public void dispose() {
        activeObjects.clear();
        freeObjects.clear();
    }
}
