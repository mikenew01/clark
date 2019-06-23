# CLARK

Project clark aims to provide a library for parallel data processing.


## How to use ?
To use the framework it is necessary that you have configured version 3 of maven and java 7 in the project.

### Example of use:
````maven
  <dependencies>
      <dependency>
          <groupId>com.github.maikoncanuto</groupId>
          <artifactId>clark</artifactId>
          <version>1.0.1</version>
      </dependency>
  </dependencies>
````

````java
//hidden imports 

//Class responsible for containing processing logic
public class ExampleProcessor implements Processor<String, Integer> {

    @Override
    public Result<String> run(final List<Integer> list) {
        Result<String> result = new Result<String>();

        for (Integer i : list) {
            result.getProcessedElements().add(i + " - Test");
        }

        return result;
    }
}

//Class responsible for performing the processing
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Result<String> result = ProcessorHandler
                        .getProcessor(Type.ASYNCHRONOUS)
                        .run(new Data<>(numbers), new ExampleProcessor());

        System.out.println(result.getProcessedElements().size());
    }
}

````

