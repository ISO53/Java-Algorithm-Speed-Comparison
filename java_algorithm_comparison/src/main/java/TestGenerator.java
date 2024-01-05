import java.util.ArrayList;
import java.util.List;

public class TestGenerator {

    private List<Method> methods;
    private Results results;

    private TestGenerator() {
        this.methods = new ArrayList<>();
        results = new Results();
    }

    // Method to run all stored methods
    public void run() {
        for (Method method : methods) {
            method.execute();
        }
    }

    // Builder pattern for TestGenerator
    public static class Builder {

        private TestGenerator testGenerator;

        public Builder() {
            this.testGenerator = new TestGenerator();
        }

        // Add a method to the builder
        public Builder addMethod(String name, IMethod methodReference) {
            testGenerator.methods.add(new Method(name, methodReference));
            return this;
        }

        // Build the TestGenerator instance
        public TestGenerator build() {
            return testGenerator;
        }
    }
}
