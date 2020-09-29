package test;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingLoginExample {
    public static void main(String[] args){
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Login Example");
        // 设置 frame 的宽高
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建面板,类似 HTML 的 div 标签
        JPanel panel = new JPanel();

        // 添加面板
        frame.add(panel);

        // 调用用户定义的方法并添加组件到面板
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel){
        // 设置布局为 null
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("User: ");

        /**
         * setBounds(x, y, width, height)
         * x 和 y 指定做上机角的新位置,由 width 和 height 指定新的大小
         */
        userLabel.setBounds(350, 300, 80, 25);
        panel.add(userLabel);

        // 创建文本域用于用户输入
        JTextField userText = new JTextField(20);
        userText.setBounds(450, 300, 165, 25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(350, 350, 80, 25);
        panel.add(passwordLabel);

        // 类似输入的文本域
        // 输入的信息会以点号代替, 用于包含密码的安全性
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(450, 350, 165, 25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(535, 400, 80, 25);
        panel.add(loginButton);


    }
}
