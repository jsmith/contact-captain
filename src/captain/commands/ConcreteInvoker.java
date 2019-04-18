package captain.commands;

import java.util.Stack;

class ConcreteInvoker {
    private Stack<Command> past = new Stack<>();
    private Stack<Command> future = new Stack<>();

    void invokeCommand(Command command) {
        if (this.future.size() != 0) {
            this.future = new Stack<>();
        }

        command.execute();
        this.past.push(command);
    }

    void undo() {
        if (this.past.size() == 0) {
            return;
        }

        Command command = this.past.pop();
        command.unexecute();
        this.future.push(command);
    }

    void redo() {
        if (this.future.size() == 0) {
            return;
        }

        Command command = this.future.pop();
        command.execute();
        this.past.push(command);
    }
}
