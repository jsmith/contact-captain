package commands;

public abstract class InvokerInterface {
    abstract public void invoke(Command command);
    abstract public void undo();
    abstract public void redo();
}
