# Java Algorithm Speed Comparison

This Java project aims to compare algorithm speeds by running tests and visualizing the results using a line chart. The project consists of several classes that work together to facilitate the comparison process.

## Table of Contents

-   [Classes](#classes)
-   [How to Use](#how-to-use)
    -   [Create Method Instance](#create-method-instance)
    -   [Create Parameters](#create-parameters)
    -   [Create Test Cases](#create-test-cases)
    -   [Create Test Generator](#create-test-generator)
    -   [Run the Test](#run-the-test)
    -   [Visualize the Results](#visualize-the-results)
-   [Dependencies](#dependencies)
    -   [Running Locally](#running-locally)
-   [Contributing](#contributing)
-   [License](#license)

## Classes

-   **Method:**
    The Method class represents a method or algorithm to be tested. It includes an interface IMethod and allows the execution of a method with parameters.
-   **TestCase:**
    The TestCase class facilitates the creation of test cases with varying parameters. It is designed using the builder pattern.
-   **TestGenerator:**
    The TestGenerator class orchestrates the testing process, running specified methods with different test cases and collecting execution times. It also provides a method to visualize the results using a line chart.
-   **LineChart:**
    The LineChart class utilizes JFreeChart to create a line chart for visualizing the execution times of different methods across multiple test runs.

## How to Use

Let's say we want to compare two methods that checks whether a string is palindrome or not.

### Create Method Instance

Create instances of the Method class to represent the algorithms you want to compare. You can create a method instance like this:

```Java
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
```

> [!NOTE]
> Keep in mind that these functions does not return a values as they solely focuses on comparing the speed difference and does not check the correctness of the answer.

### Create Parameters

Create parameters to pass to the methods you just create.

```Java
int testLength = 1024;
String[] palindromeArr = new String[testLength];
// Rest of the code for creating arrays full of palindrome strings.
// Preferably strings with increasing length.
```

### Create Test Cases

Use the TestCase.Builder to define test cases with specific parameters.

```Java
TestCase tc = new TestCase
            .Builder()
            .setParameterCount(1)         // you need to add this first
            .setTestCount(testLength)     // and add this second
            .addParameter(palindromeArr)  // you can add as much parameter as you want
            .build();
```

### Create Test Generator

Utilize the TestGenerator.Builder to set up the testing environment by adding methods and test cases.

```Java
TestGenerator tg = new TestGenerator
            .Builder()
            .setTestName("'IsPalindrome' Algorithm Speed Comparison") // optional
            .addMethod(method1) // you must add at least one method
            .addMethod(method2) // you can add as much method as you want
            .addTestCase(tc)    // you must add only one test case.
                                // if you add more than one the last one will be used
            .build();
```

### Run the Test

Invoke the run() method of the TestGenerator to execute the tests.

```Java
// run the test
tg.run();
```

### Visualize the Results

Call the visualize() method of the TestGenerator to display a line chart showing the execution times of each method across different test cases.

```Java
// visualize the test on a line chart. (thx to jFreeChart)
tg.visualize();
```

## Contributing

Your contributions are valued! We appreciate your cooperation in making our project better.

## License

This project is licensed under the [GNU General Public License v3.0](LICENSE). Feel free to modify the content and structure based on your preferences and project specifics.

[![Follow me on GitHub](https://img.shields.io/github/followers/iso53?label=Follow%20%40iso53&style=social)](https://github.com/iso53)
