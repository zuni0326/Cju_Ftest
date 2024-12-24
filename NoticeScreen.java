package ftest;

/**
 * 공지사항 화면을 관리하는 클래스입니다.
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NoticeScreen {
	private JFrame frame;

	/**
	 * 공지사항 화면을 초기화하고 표시합니다.
	 */
	public void show() {
		frame = new JFrame("공지사항");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("공지사항", SwingConstants.CENTER);
		titleLabel.setFont(new Font("돋움", Font.BOLD, 16));
		panel.add(titleLabel, BorderLayout.NORTH);

		List<String> titles = DataManager.getNoticeTitles();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String title : titles) {
			listModel.addElement(title);
		}

		JList<String> noticeList = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(noticeList);
		panel.add(scrollPane, BorderLayout.CENTER);

		noticeList.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				String selectedTitle = noticeList.getSelectedValue();
				String content = DataManager.getNoticeContent(selectedTitle);
				JOptionPane.showMessageDialog(frame, content, "공지사항 상세", JOptionPane.INFORMATION_MESSAGE);
			}
		});

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