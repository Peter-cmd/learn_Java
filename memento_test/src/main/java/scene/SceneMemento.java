package scene;

public class SceneMemento {
    private String name;
    private Long lifeValue;
    private String scene;

    public SceneMemento(String name, Long lifeValue, String scene) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.scene = scene;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setLifeValue(Long lifeValue) {
        this.lifeValue = lifeValue;
    }

    Long getLifeValue() {
        return this.lifeValue;
    }

    void setScene(String scene) {
        this.scene = scene;
    }

    String getScene() {
        return this.scene;
    }
}
