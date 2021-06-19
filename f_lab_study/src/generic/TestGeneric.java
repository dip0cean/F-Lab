package generic;

public class TestGeneric<T extends Number> {
    public T t;
    public String message;

    public TestGeneric(T t) {
        if (t instanceof Integer) {
            this.message = "this Integer";
        }
        if (t instanceof Long) {
            this.message = "this Long";
        }
        this.t = t;
        Generic<String> generic = new Generic<>("Hello");
    }
    public class Generic<Type> {
        public Type type;

        public Generic(Type type) {
            this.type = type;
        }
    }
}
