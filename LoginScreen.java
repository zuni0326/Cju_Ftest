package ftest;

/**
 * 로그인 화면을 관리하는 클래스입니다.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    /**
     * 로그인 화면을 표시하기 위한 프레임입니다.
     */
    private JFrame frame;

    /**
     * 로그인 화면을 초기화하고 표시합니다.
     */
    public void show() {
        frame = new JFrame("로그인 화면");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        /**
         * 사용자 ID(학번)를 입력받는 텍스트 필드입니다.
         */
        JLabel userLabel = new JLabel("학번", SwingConstants.CENTER);
        userLabel.setFont(new Font("돋움", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        JTextField userText = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        /**
         * 사용자 비밀번호를 입력받는 텍스트 필드입니다.
         */
        JLabel passwordLabel = new JLabel("비밀번호", SwingConstants.CENTER);
        passwordLabel.setFont(new Font("돋움", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordText, gbc);

        /**
         * 로그인 버튼입니다. 클릭 시 로그인 검증을 수행합니다.
         */
        JButton loginButton = new JButton("로그인");
        loginButton.setFont(new Font("돋움", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        /**
         * 로그인 상태를 표시하는 레이블입니다.
         */
        JLabel statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(Color.RED);
        statusLabel.setFont(new Font("돋움", Font.PLAIN, 12));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(statusLabel, gbc);

        frame.add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userText.getText();
                String password = new String(passwordText.getPassword());

                if (DataManager.validateUser(userId, password)) {
                    frame.dispose();
                    MenuScreen menuScreen = new MenuScreen(userId);
                    menuScreen.show();
                } else {
                    statusLabel.setText("로그인 실패: 학번 또는 비밀번호를 확인하세요.");
                }
            }
        });

        frame.setVisible(true);
    }
}