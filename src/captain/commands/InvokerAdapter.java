package captain.commands;

public class InvokerAdapter extends InvokerInterface {
    private InvokerInterface invoker = new ConcreteInvoker();

    @Override
    public void invoke(Command command) {
        this.invoker.invoke(command);
    }

    @Override
    public void undo() {
        this.invoker.undo();
    }

    @Override
    public void redo() {
        this.invoker.redo();
    }
}
