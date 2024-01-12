package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> sizes = new AList<>();
        sizes.addLast(1000);
        sizes.addLast(2000);
        sizes.addLast(4000);
        sizes.addLast(16000);
        sizes.addLast(32000);
        sizes.addLast(64000);
        sizes.addLast(128000);
        AList<Integer> ops = sizes;
        AList<Double> times = new AList<>();

        for(int i = 0; i < sizes.size(); i ++) {
            Integer size = sizes.get(i);
            AList<Integer> tmp = new AList<>();
            Stopwatch sw = new Stopwatch();
            //with size
            for(int j = 0; j < size; j ++) {
                tmp.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        printTimingTable(sizes, times, ops);
    }
}
