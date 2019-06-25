import java.awt.*;

public class Main {
    public static void main(String[] args){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++){
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e){}
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();*/

        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++){
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e){}
                }
            }
        });
        thread.start();*/

        Thread thread = new Thread(() ->{
            for(int i=0; i<5; i++){
                System.out.println("ㅇ");
                try {
                    Thread.sleep(500);
                } catch (Exception e){}
            }
        });
        thread.start();

        for(int i=0; i<5; i++){
            System.out.println("띠");
            try {
                Thread.sleep(500);
            } catch (Exception e){}
        }
    }
}