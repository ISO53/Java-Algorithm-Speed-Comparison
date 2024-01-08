import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // ######################## CREATING METHODS ########################
        /*
         * This functions does not return a value as it solely focuses
         * on comparing the speed difference and does not check the
         * correctness of the answer.
         **/
        Method method1 = new Method("Method_1", (params) -> {
            String str = (String) params[0];
            (new StringBuilder(str).reverse().toString()).equals(str);
        });

        Method method2 = new Method("Method_2", (params) -> {
            String str = (String) params[0];
            int i = 0, j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) {
                    break;
                }
                i++;
                j--;
            }
        });

        // ######################## CREATING TEST PARAMETERS ########################
        int testLength = 200;
        String[] palindromeArr = new String[testLength];

        Random random = new Random();
        for (int i = 0; i < testLength; i++) {
            int length = (int) (10 + Math.pow(2, (double) i / 10));

            // Fill palindromeArr with palindromes of increasing length
            StringBuilder palindrome = new StringBuilder();
            for (int j = 0; j < length / 2; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a');
                palindrome.append(randomChar);
            }
            palindrome.append(new StringBuilder(palindrome).reverse());
            palindromeArr[i] = palindrome.toString();
        }

        // ######################## CREATING TEST CASES ########################
        TestCase tc = new TestCase
                .Builder()
                .setParameterCount(1)
                .setTestCount(testLength)
                .addParameter(palindromeArr)
                .build();

        // ######################## CREATING TEST GENERATORS ########################
        TestGenerator tg = new TestGenerator
                .Builder()
                .setTestName("'IsPalindrome' Algorithm Speed Comparison")
                .addMethod(method1)
                .addMethod(method2)
                .addTestCase(tc)
                .build();

        // ######################## RUN THE TESTS ########################
        tg.run();

        // ######################## VISUALIZE THE RESULTS ########################
        tg.visualize();
    }
}
