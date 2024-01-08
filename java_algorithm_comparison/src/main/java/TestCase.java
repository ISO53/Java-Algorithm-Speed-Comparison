import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private int testCount;
    private int parameterCount;
    private int currParam;
    private List<Object[]> parametersList;

    private TestCase() {
        this.parametersList = new ArrayList<>();
        this.testCount = 0;
        this.parameterCount = 0;
        this.currParam = 0;
    }

    public List<Object[]> getParametersList() {
        return parametersList;
    }

    public static class Builder {

        private final TestCase testCase;

        public Builder() {
            this.testCase = new TestCase();
        }

        public Builder setTestCount(int testCount) {
            testCase.testCount = testCount;
            for (int i = 0; i < testCount; i++) {
                testCase.parametersList.add(new Object[testCase.parameterCount]);
            }
            return this;
        }

        public Builder setParameterCount(int parameterCount) {
            testCase.parameterCount= parameterCount;
            return this;
        }

        public Builder addParameter(Object[] arr) {
            for (int i = 0; i < testCase.testCount; i++) {
                testCase.parametersList.get(i)[testCase.currParam] = arr[i];
            }
            testCase.currParam++;
            return this;
        }

        public Builder addParameter(Object obj) {
            for (int i = 0; i < testCase.testCount; i++) {
                testCase.parametersList.get(i)[testCase.currParam] = obj;
            }
            testCase.currParam++;
            return this;
        }

        // Build the TestCase instance
        public TestCase build() {
            return testCase;
        }
    }
}