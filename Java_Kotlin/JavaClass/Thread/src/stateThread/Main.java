package stateThread;

public class Main {
    public static void main(String[] a){
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}
