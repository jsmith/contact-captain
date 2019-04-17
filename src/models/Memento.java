package models;

public class Memento<S> {
    private S state;

    public Memento(S state) {
        this.state = state;
    }

    public S getState() {
        return this.state;
    }
}
