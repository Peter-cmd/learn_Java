package sequence.print;

public class SequencePrint {
    private static String[] INFOS = {"A", "B", "C", "D"};
    private static int INDEX;
    public static void main(String[] args){
        for (int i = 0; i < INFOS.length; i++){
            new Thread(new PrintTask(i)).start();
        }
    }

    private static class PrintTask implements Runnable{
        //当前线程需要的索引
        private int index;

        public PrintTask(int index){
            this.index = index;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (INFOS) {
                        while (INDEX != index){
                            INFOS.wait();
                        }
                        System.out.print(INFOS[index]);
                        if (index == INFOS.length - 1){
                            System.out.println(" === " + i);
                        }

                        INDEX = (INDEX + 1) % INFOS.length;

                        INFOS.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
