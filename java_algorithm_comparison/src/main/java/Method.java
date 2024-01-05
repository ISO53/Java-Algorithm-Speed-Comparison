public class Method {

    String name;
    IMethod methodReference;

    public Method(String name, IMethod methodReference) {
        this.name = name;
        this.methodReference = methodReference;
    }

    public void execute() {
        methodReference.execute();
    }
}
