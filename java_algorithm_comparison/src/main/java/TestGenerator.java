import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestGenerator {

    private List<Method> methods;
    private TestCase testCase;
    private String testName;
    private List<List<Long>> results;

    private TestGenerator() {
        this.methods = new ArrayList<>();
        this.testCase = null;
        this.results = new ArrayList<>();
        this.testName = "A Test";
    }

    public void run() {
        for (Method method : methods) {

            List<Long> result = new ArrayList<>(testCase.getParametersList().size());

            for (Object[] parameters : testCase.getParametersList()) {

                long startTime = System.nanoTime();
                method.execute(parameters);
                long endTime = System.nanoTime();

                result.add(endTime - startTime);
            }

            results.add(result);
        }
    }

    public void visualize() {
        LineChart lineChart = new LineChart(
                this.testName,
                methods.stream()
                    .map(method -> method.name)
                    .collect(Collectors.toList()),
                results);

        SwingUtilities.invokeLater(() -> {
            lineChart.setSize(800, 600);
            lineChart.setLocationRelativeTo(null);
            lineChart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            lineChart.setVisible(true);
        });
    }

    public static class Builder {

        private TestGenerator testGenerator;

        public Builder() {
            this.testGenerator = new TestGenerator();
        }

        public Builder addMethod(Method method) {
            testGenerator.methods.add(new Method(method.getName(), method.getMethodReference()));
            return this;
        }

        public Builder addTestCase(TestCase testCase) {
            testGenerator.testCase = testCase;
            return this;
        }

        public Builder setTestName(String testName) {
            testGenerator.testName = testName;
            return this;
        }

        public TestGenerator build() {
            return testGenerator;
        }
    }
}
