package captain.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Invocation {
    private Method method;

    Invocation(Method method) {
        this.method = method;
    }

    void invoke(Object object) {
        try {
            this.method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException ignored) {}
    }
}
