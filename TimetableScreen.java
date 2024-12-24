package ftest;

/**
 * 시간표 화면을 관리하는 클래스입니다.
 */
import javax.swing.*;
import java.awt.*;

public class TimetableScreen {
    /**
     * 시간표 화면을 표시하기 위한 프레임입니다.
     */
    private JFrame frame;

    /**
     * 시간표 화면을 초기화하고 표시합니다.
     */
    public void show() {
        frame = new JFrame("시간표 화면");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        
        /**
         * 전체 시간표를 표시하는 텍스트 영역입니다.
         */
        JTextArea timetableArea = new JTextArea(DataManager.getTimetable());
        timetableArea.setEditable(false);
        timetableArea.setFont(new Font("돋움", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(timetableArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        /**
         * 메뉴로 돌아가기 버튼입니다.
         */
        JButton backButton = new JButton("돌아가기");
        backButton.setFont(new Font("돋움", Font.BOLD, 14));
        backButton.addActionListener(e -> {
            frame.dispose();
            MenuScreen menuScreen = new MenuScreen(null);
            menuScreen.show();
        });
        panel.add(backButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}