package client;

import scene.GameScene;
import scene.SceneMemento;
import scene.TakeCarer;

public class Client {

    public static void main(String[] args){
        GameScene scene = new GameScene("孙悟空", 999L, "火焰山");
        SceneMemento memento = scene.store();
        TakeCarer carer = new TakeCarer();
        carer.setMemento(memento);
        scene.display();
        scene.setLifeValue(100L);
        scene.setScene("芭蕉洞");
        scene.display();
        scene.restore(carer.getMemento());
        scene.display();
    }

}
