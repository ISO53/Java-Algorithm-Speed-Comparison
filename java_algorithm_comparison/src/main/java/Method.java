public class Method {

    public interface IMethod {
        void execute(Object ...parameters);
    }

    String name;
    IMethod methodReference;

    public Method(String name, IMethod methodReference) {
        this.name = name;
        this.methodReference = methodReference;
    }

    public String getName() {
        return name;
    }

    public IMethod getMethodReference() {
        return methodReference;
    }

    public void execute(Object ...parameters) {
        methodReference.execute(parameters);
    }
}


