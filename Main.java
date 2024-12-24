package ftest;

/**
 * 프로그램 실행의 진입점으로, 로그인 화면을 시작합니다.
 */
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LoginScreen loginScreen = new LoginScreen();
			loginScreen.show();
		});
	}
}