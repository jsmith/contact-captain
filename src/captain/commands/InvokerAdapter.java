package captain.commands;

public class InvokerAdapter extends InvokerInterface {
    private ConcreteInvoker invoker = new ConcreteInvoker();

    @Override
    public void invoke(Command command) {
        this.invoker.invokeCommand(command);
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
