package demo0002;

public class ObjectTool<T> {
    private T object;

    private T getObject(){
        return object;
    }

    private void setObject(T object){
        this.object = object;
    }


    public <T> void show(T t){
        System.out.println(t);
    }


    public static void main(String[] args){
        ObjectTool<String> demo01 = new ObjectTool<>();
        demo01.setObject("你好");
        System.out.println(demo01.getObject());

        ObjectTool<Integer> demo02 = new ObjectTool<>();
        demo02.setObject(2);
        System.out.println(demo02.getObject());

        demo01.show("你好");
        demo01.show(1);
    }
}
