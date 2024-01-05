import java.util.ArrayList;

public class Results {

    private String testName;
    ArrayList<Result> results;

    private class Result {

        private String[] names;
        private long[] times;
        private long[] memories;

        public Result(String... args) {
            this.times = new long[args.length];
            this.memories = new long[args.length];
            this.names = new String[args.length];
            System.arraycopy(args, 0, names, 0, args.length);
        }

        public void save()
    }

}
