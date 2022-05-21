import java.util.Random;

public class PiEstimator {
    public static void main(String[] args) throws InterruptedException {
        float dos = 1_000_000_000f;

        TotalWithin t1 = new TotalWithin((int) (dos/4),1);
        TotalWithin t2 = new TotalWithin((int) (dos/4),2);
        TotalWithin t3 = new TotalWithin((int) (dos/4),3);
        TotalWithin t4 = new TotalWithin((int) (dos/4),4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(t1.getWithin() + t2.getWithin() + t3.getWithin() +t4.getWithin());

        int sum = t1.getWithin() + t2.getWithin() + t3.getWithin() +t4.getWithin();

        //estimate pi by getting proportion of darts in the quarter circle and multiplying by 4.
        double estimate = (double)sum/dos*4;
        System.out.println(estimate);

    }
}


