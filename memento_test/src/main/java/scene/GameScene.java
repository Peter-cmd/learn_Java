package scene;

public class GameScene {
    private String name;
    private Long lifeValue;
    private String scene;

    public GameScene(String name, Long lifeValue, String scene) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.scene = scene;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLifeValue(Long lifeValue) {
        this.lifeValue = lifeValue;
    }

    public Long getLifeValue() {
        return this.lifeValue;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getScene() {
        return this.scene;
    }


    public void restore(SceneMemento m) {
        this.name = m.getName();
        this.lifeValue = m.getLifeValue();
        this.scene = m.getScene();
    }

    public SceneMemento store() {
        return new SceneMemento(this.name, this.lifeValue, this.scene);
    }

    public void display() {
        System.out.println(this.name + "当前位于" + this.scene);
        System.out.println(this.name + "当前的生命值为" + this.lifeValue);
    }
}
