import java.util.Stack;

class Invoker {
    private Stack<Command> history = new Stack<>();
    private Stack<Command> future = new Stack<>();

    void invoke(Command command) {
        if (this.future.size() != 0) {
            this.future = new Stack<>();
        }

        command.execute();
        this.history.push(command);
    }

    void undo() {
        if (this.history.size() == 0) {
            return;
        }

        Command command = this.history.pop();
        command.unexecute();
        this.future.push(command);
    }

    void redo() {
        if (this.future.size() == 0) {
            return;
        }

        Command command = this.future.pop();
        command.execute();
        this.history.push(command);
    }
}
