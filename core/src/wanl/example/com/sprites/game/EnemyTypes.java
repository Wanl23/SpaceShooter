package wanl.example.com.sprites.game;

public enum EnemyTypes {
    enemy0("enemy0"),
    enemy1("enemy1"),
    enemy2("enemy2");

    private String atalasName;

    EnemyTypes(String atalasName) {
        this.atalasName = atalasName;
    }

    public String getAtalasName() {
        return atalasName;
    }
}
