package ftest;

/**
 * 메뉴 화면을 관리하는 클래스입니다.
 */
import javax.swing.*;
import java.awt.*;

public class MenuScreen {
    /**
     * 메뉴 화면을 표시하기 위한 프레임입니다.
     */
    private JFrame frame;

    /**
     * 현재 로그인된 사용자의 학번입니다.
     */
    private String userId;

    /**
     * MenuScreen 생성자입니다.
     * 
     * @param userId 로그인된 사용자의 학번
     */
    public MenuScreen(String userId) {
        this.userId = userId;
    }

    /**
     * 메뉴 화면을 초기화하고 표시합니다.
     */
    public void show() {
        frame = new JFrame("메뉴 화면");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /**
         * 시간표 보기 버튼입니다.
         */
        JButton timetableButton = new JButton("시간표 보기");
        timetableButton.setFont(new Font("돋움", Font.BOLD, 14));
        panel.add(timetableButton);

        /**
         * 공지사항 보기 버튼입니다.
         */
        JButton noticeButton = new JButton("공지사항");
        noticeButton.setFont(new Font("돋움", Font.BOLD, 14));
        panel.add(noticeButton);

        /**
         * 학생 게시판 보기 버튼입니다.
         */
        JButton boardButton = new JButton("학생 게시판");
        boardButton.setFont(new Font("돋움", Font.BOLD, 14));
        panel.add(boardButton);

        frame.add(panel, BorderLayout.CENTER);

        timetableButton.addActionListener(e -> {
            frame.dispose();
            TimetableScreen timetableScreen = new TimetableScreen();
            timetableScreen.show();
        });

        noticeButton.addActionListener(e -> {
            frame.dispose();
            NoticeScreen noticeScreen = new NoticeScreen();
            noticeScreen.show();
        });

        boardButton.addActionListener(e -> {
            frame.dispose();
            BoardScreen boardScreen = new BoardScreen(userId);
            boardScreen.show();
        });

        frame.setVisible(true);
    }
}