package ftest;

/**
 * 사용자 데이터 관리를 담당하는 클래스입니다.
 */
import java.util.*;

public class DataManager {
    /**
     * 사용자 데이터(학번 및 비밀번호)를 저장하는 맵입니다.
     * 키는 학번이고 값은 비밀번호입니다.
     */
    private static final Map<String, String> users = new HashMap<>();

    /**
     * 공지사항 데이터를 저장하는 리스트입니다.
     * 배열의 첫 번째 요소는 공지 제목, 두 번째 요소는 공지 내용입니다.
     */
    private static final List<String[]> notices = new ArrayList<>();

    /**
     * 시간표 데이터를 저장하는 리스트입니다.
     * 각 항목은 시간표의 문자열 표현입니다.
     */
    private static final List<String> timetable = new ArrayList<>();

    // 데이터 초기화 블록
    static {
        users.put("20220101", "password1");
        users.put("20220102", "password2");
        users.put("20220103", "password3");
        users.put("20220104", "password4");
        users.put("20220105", "password5");

        timetable.add("월요일 - Java (09:00~11:00)");
        timetable.add("화요일 - Python (10:00~12:00)");
        timetable.add("수요일 - 네트워크 (13:00~15:00)");

        notices.add(new String[] { "Java 과제 제출 마감", "자바 과제 제출 마감은 이번 주 목요일입니다." });
        notices.add(new String[] { "Python 시험 예정", "파이썬 시험은 다음 주 화요일입니다." });
    }

    /**
     * 사용자의 학번과 비밀번호를 검증합니다.
     *
     * @param userId 사용자의 학번
     * @param password 사용자의 비밀번호
     * @return 학번과 비밀번호가 유효하면 true, 그렇지 않으면 false
     */
    public static boolean validateUser(String userId, String password) {
        return users.containsKey(userId) && users.get(userId).equals(password);
    }

    /**
     * 저장된 시간표를 문자열로 반환합니다.
     *
     * @return 시간표를 줄바꿈으로 구분한 문자열
     */
    public static String getTimetable() {
        return String.join("\n", timetable);
    }

    /**
     * 저장된 공지사항의 제목 리스트를 반환합니다.
     *
     * @return 공지사항 제목 리스트
     */
    public static List<String> getNoticeTitles() {
        List<String> titles = new ArrayList<>();
        for (String[] notice : notices) {
            titles.add(notice[0]);
        }
        return titles;
    }

    /**
     * 주어진 제목에 해당하는 공지사항의 상세 내용을 반환합니다.
     *
     * @param title 공지사항 제목
     * @return 공지사항 내용, 해당 제목이 없으면 "상세 내용을 찾을 수 없습니다."
     */
    public static String getNoticeContent(String title) {
        for (String[] notice : notices) {
            if (notice[0].equals(title)) {
                return notice[1];
            }
        }
        return "상세 내용을 찾을 수 없습니다.";
    }
}
