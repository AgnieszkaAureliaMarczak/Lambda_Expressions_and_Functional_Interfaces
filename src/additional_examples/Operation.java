package additional_examples;

@FunctionalInterface // recommended to include this annotation
public interface Operation<T> {
    T operate(T value1, T value2);
}
