package synchronized02;

class A{
    public synchronized static void sayA(){
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
