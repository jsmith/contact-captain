import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        //creating instance of JFrame
        JFrame frame = new JFrame("Contact Captain");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating instance of JButton
        JButton button = new JButton("click");

        // x axis, y axis, width, height
        button.setBounds(130,100,100, 40);

        // adding button in JFrame
        frame.add(button);

        frame.setContentPane(new ContactCaptain().getComponent());

        // 400 width and 500 height
        frame.setSize(260,200);

        // making the frame visible
        frame.setVisible(true);
    }
}
