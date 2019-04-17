package captain.events;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.Map;

public class EventBus {
    private Map<String, List<Consumer<ActionEvent>>> invocations = new ConcurrentHashMap<>();

    public void on(String event, Consumer<ActionEvent> consumer) {
        if (!invocations.containsKey(event)) {
            invocations.put(event, new ArrayList<>());
        }

        invocations.get(event).add(consumer);
    }

    public void off(String event, Consumer<ActionEvent> consumer) {
        if (!invocations.containsKey(event)) {
            return;
        }

        invocations.get(event).remove(consumer);
    }

    public void emit(String event, ActionEvent e) {
        if (!invocations.containsKey(event)) {
            return;
        }

        invocations.get(event).forEach(consumer -> consumer.accept(e));
    }
}