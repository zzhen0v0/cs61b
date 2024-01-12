package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> sizes = new AList<>();
        sizes.addLast(1000);
        sizes.addLast(2000);
        sizes.addLast(4000);
        sizes.addLast(16000);
        sizes.addLast(32000);
        sizes.addLast(64000);
        sizes.addLast(128000);
        AList<Integer> ops = new AList<>();
        for(int i = 0; i < 7; i ++) {
            ops.addLast(10000);
        }

        AList<Double> times = new AList<>();

        for(int i = 0; i < sizes.size(); i ++) {
            Integer size = sizes.get(i);
            Integer op = ops.get(i);
            SLList<Integer> tmpSList = new SLList<>();
            for(int j = 0; j < size; j ++) {
                tmpSList.addFirst(j);
            }

            Stopwatch sw = new Stopwatch();
            for(int j = 0; j < op; j ++) {
                Integer tmp = tmpSList.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        printTimingTable(sizes, times, ops);
    }
}
