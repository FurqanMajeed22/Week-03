package stringbuffer.performancemeasure;

public class PerformanceTest {
    public static void main(String[] args) {
        long startTime,endTime;
        //perfomance of Stirng buffer
        StringBuffer sb=new StringBuffer();
        startTime=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append("Hello");
        }
        endTime=System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");
        // Testing StringBuilder Performance
        startTime = System.nanoTime();
        StringBuilder sbb = new StringBuilder("Java");
        for (int i = 0; i < 100000; i++) {
            sbb.append(" Performance Test");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");




    }
}
