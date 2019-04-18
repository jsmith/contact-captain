package captain.utils;

public interface Iterator<T> {
    void initialize();
    void next();
    boolean isDone();
    T getCurrent();
}
