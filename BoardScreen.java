package ftest;

/**
 * 학생 게시판 화면을 관리하는 클래스입니다.
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardScreen {
    /**
     * 학생 게시판 화면을 표시하기 위한 프레임입니다.
     */
    private JFrame frame;

    /**
     * 게시글 데이터를 저장하는 리스트입니다.
     */
    private List<Post> posts = new ArrayList<>();

    /**
     * 사용자 추천 기록을 저장하는 맵입니다. 키는 사용자 ID이고 값은 추천한 게시글 인덱스 리스트입니다.
     */
    private Map<String, List<Integer>> userLikes = new HashMap<>();

    /**
     * 현재 로그인된 사용자 ID입니다.
     */
    private String userId;

    /**
     * BoardScreen 생성자입니다.
     *
     * @param userId 현재 로그인된 사용자 ID
     */
    public BoardScreen(String userId) {
        this.userId = userId;
        posts.add(new Post("오늘 점심", "청대얼큰이칼국수 쭈꾸미"));
        posts.add(new Post("학점 3.0이면", "이번 학기 망했나요?"));
    }

    /**
     * 게시판 화면을 초기화하고 표시합니다.
     */
    public void show() {
        frame = new JFrame("학생 게시판");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        /**
         * 게시판 제목을 표시하는 레이블입니다.
         */
        JLabel titleLabel = new JLabel("학생 게시판", SwingConstants.CENTER);
        titleLabel.setFont(new Font("돋움", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        /**
         * 게시글 데이터를 표시하기 위한 리스트 모델입니다.
         */
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Post post : posts) {
            listModel.addElement(post.getTitle() + " (추천수: " + post.getLikes() + ")");
        }

        /**
         * 게시글 목록을 표시하는 JList입니다.
         */
        JList<String> postList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(postList);
        panel.add(scrollPane, BorderLayout.CENTER);

        /**
         * 글쓰기 버튼입니다. 새 게시글을 추가할 수 있습니다.
         */
        JButton addPostButton = new JButton("글쓰기");
        addPostButton.setFont(new Font("돋움", Font.BOLD, 14));
        addPostButton.addActionListener(e -> {
            String newTitle = JOptionPane.showInputDialog(frame, "게시글 제목을 입력하세요:");
            if (newTitle != null && !newTitle.trim().isEmpty()) {
                String newContent = JOptionPane.showInputDialog(frame, "게시글 내용을 입력하세요:");
                if (newContent != null && !newContent.trim().isEmpty()) {
                    Post newPost = new Post(newTitle, newContent);
                    posts.add(newPost);
                    listModel.addElement(newTitle + " (추천수: 0)");
                }
            }
        });
        panel.add(addPostButton, BorderLayout.NORTH);

        postList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = postList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Post selectedPost = posts.get(selectedIndex);
                    List<Integer> likedPosts = userLikes.getOrDefault(userId, new ArrayList<>());

                    int result = JOptionPane.showOptionDialog(frame, selectedPost.getContent(), "내용",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            new String[]{"추천", "닫기"}, null);

                    if (result == 0) {
                        if (!likedPosts.contains(selectedIndex)) {
                            selectedPost.addLike();
                            likedPosts.add(selectedIndex);
                            userLikes.put(userId, likedPosts);
                            listModel.set(selectedIndex,
                                    selectedPost.getTitle() + " (추천수: " + selectedPost.getLikes() + ")");
                        } else {
                            JOptionPane.showMessageDialog(frame, "이미 추천한 게시글입니다.", "오류", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        /**
         * 메뉴로 돌아가기 버튼입니다.
         */
        JButton backButton = new JButton("돌아가기");
        backButton.setFont(new Font("돋움", Font.BOLD, 14));
        backButton.addActionListener(e -> {
            frame.dispose();
            MenuScreen menuScreen = new MenuScreen(userId);
            menuScreen.show();
        });
        panel.add(backButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * 게시글을 나타내는 내부 클래스입니다.
     */
    private static class Post {
        /**
         * 게시글 제목입니다.
         */
        private final String title;

        /**
         * 게시글 내용입니다.
         */
        private final String content;

        /**
         * 게시글 추천수입니다.
         */
        private int likes;

        /**
         * Post 생성자입니다.
         *
         * @param title 게시글 제목
         * @param content 게시글 내용
         */
        public Post(String title, String content) {
            this.title = title;
            this.content = content;
            this.likes = 0;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public int getLikes() {
            return likes;
        }

        public void addLike() {
            likes++;
        }
    }
}
