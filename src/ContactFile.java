import java.util.List;

public interface ContactFile {
    Momento<List<SimpleContact>> load();
    void save(Momento<List<SimpleContact>> memento);
}
