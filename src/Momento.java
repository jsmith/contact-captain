import java.io.Serializable;

class Momento<S> {
    private S state;

    Momento(S state) {
        this.state = state;
    }

    S getState() {
        return this.state;
    }
}
