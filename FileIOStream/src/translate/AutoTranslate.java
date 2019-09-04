package translate;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * create by CP on 2019/9/2 0002.
 */
public class AutoTranslate {

    @Test
    public void test() throws IOException {
        //app index.properties
//        Map<String, String> map = getIndexInitData();
//        File file = new File("src/translate/index.properties");

        //app common.properties
//        Map<String, String> map = getCommonInitData();
//        File file = new File("src/translate/common.properties");

        //server content.properties
        Map<String, String> map = getServerInitData();
        File file = new File("src/translate/content_en_US.properties");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String temp = null;
        while((temp=bufferedReader.readLine())!=null) {
            if (!temp.contains("=")){
                System.out.println();
                continue;
            }
            String key = temp.substring(temp.indexOf("=")+1);
            if (map.containsKey(key)) {
                String replace = temp.replace(key, map.get(key));
                System.out.println(replace);
            }else {
                System.out.println(temp);
            }

        }
        fileReader.close();
        bufferedReader.close();
    }

    private Map getServerInitData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("The user does not exist", "사용자가 존재하지 않습니다. ");
        map.put("Password error", "비밀번호 에러");
        map.put("Successful login", "로그인 성공");
        map.put("Successful inquiry for the latest version information!", "최신 버전 종보의 성공적인 요청");
        map.put("The user already exists", "사용자가 이미 있습니다. ");
        map.put("The mailbox has been registered.", "우편함이 등록되었습니다. ");
        map.put("Mailbox function is abnormal, please wait a moment.", "우편함 기능이 비정상입니다. 잠시 기다리세요. ");
        map.put("Register successfully", "등록 성공");
        map.put("Password Reset Successfully, Please Log in with New Password", "비밀번호 재설정 성공. 새로운 비밀번호로 로그인하세요. ");
        map.put("The verification code is incorrect. Please re-enter it.", "검증 코드가 다릅니다. 다시 입력하세요. ");
        map.put("The authentication code has been sent. Please open your mailbox to get the authentication code.", "승인 코드가 발송되었습니다. 우편함을 열어서 인증 코드를 확인하세요. ");
        map.put("The verification code was failed to send since the email adress does not exist or email function is abnormal.", "이메일 주소가 없거나 기능이 비정상적이어서 검증 코드 발송이 실패했습니다. ");
        map.put("Log out success", "로그 아웃 송공");
        map.put("The printer associated with this device is printing. Are you sure to close it?", "해당 프린터가 프린트 중입니다. 정말로 닫으시겠습니까? ");
        map.put("Operate successfully", "작동 성공 ");
        map.put("Sending'Query Printed Message'failed, please try again later!", "\"인쇄 정보 조회\"를 보내지 못했습니다. 나중에 다시 시도하십시오!");
        map.put("Failed to send'Query Printed Message'request! Cause: Failed to parse the result of sending command!", "\"인쇄 정보 조회\"요청을 보내지 못했습니다! 원인 : 발송 명령 파싱 결과가 실패했습니다!");
        map.put("Failed to send'Query Printed Message'request! Cause: Failed to get printer serial number!", "\"인쇄 정보 조회\"요청을 보내지 못했습니다! 원인 : 프린터 일련 번호를 가져 오지 못했습니다!");
        map.put("An exception occurred when sending the command \"Query Print Message\". Please try again later!", "\"인쇄 정보 조회\"명령을 보내는 중에 오류가 발생했습니다. 나중에 다시 시도하십시오!");
        map.put("Failed to get printer serial number, please try again later!", "프린터 일련 번호를 가져 오지 못했습니다. 나중에 다시 시도하십시오!");
        map.put("An exception occurred when sending the'status query request'command. Please try again later!", "Status Query Request 명령을 보내는 중에 예외가 발생했습니다. 나중에 다시 시도하십시오!");
        map.put("The result of parsing the send command failed, please try again later!", "발송 명령 구문 분석 결과가 실패했습니다. 나중에 다시 시도하십시오!");
        map.put("Invalid request parameters!", "요청 매개 변수가 유효하지 않습니다!");
        map.put("The request parameter format is incorrect!", "요청 수치 포맷이 올바르지 않습니다!");
        map.put("Invalid parameter type!", "요효하지 않은 파라미터 타입!");
        map.put("Business exception occurred, please try again later!", "비즈니스 예외가 발생했습니다. 나중에 다시 시도하십시오!");
        map.put("Operation failed, please try again later!", "작업이 실패했습니다. 나중에 다시 시도하십시오!");

        return map;
    }

    private Map getIndexInitData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Printer Administrator", "프린터 작업자");
        map.put("Developer", "개발자");
        map.put("Print Customer", "프린터 고객");
        map.put("Device Name: ", "장비 이름");
        map.put("Serial Number: ", "시리얼 번호");
        map.put("SQA: ", "SQA: ");
        map.put("Working Status: ", "작업 상태: ");
        map.put("User name should be 6~18 characters", "사용자 이름은 6~18자여야 합니다. ");
        map.put("Password should be 6~12 characters", "비밀번호는 6~12자여야 합니다. ");
        map.put("unknown error", "알려지지 않은 에러");
        map.put("Network abnormal", "비정상 네트워크");
        map.put("Access timeout", "접근 시간종료");
        map.put("Login error:", "로그인 에러: ");
        map.put("System Tips", "시스템 팁");
        map.put("Version update failed:", "버전 업데이트 실패:");
        map.put("Ready to download...", "다운로드 준비");
        map.put("Downloading", "다운로딩 중");
        map.put("Connected to the server", "서버 연결 완료");
        map.put("Downloaded", "다운로드 완료");
        map.put("Yes", "네");
        map.put("No", "아니오");
        map.put("Find new versions:", "새로운 버전 찾기: ");
        map.put("Find the new version:V", "새로운 버전 찾기: V");
        map.put("Upgrade confirmation", "업그레이드 승인 ");
        map.put("This is the lastest version", "이 버전이 최신버전임");
        map.put("Network Access Error", "네트워크 접근 에러");
        map.put("Network exception, please try again later", "네트워크 예외. 나중에 다시 시도하세요. ");
        map.put("Entry with * cannot be empty!", "*가 있는 항목은 비워 둘 수 없습니다. ");
        map.put("Password and confirmation must be the same", "비밀번호와 비밀번호 확인은 같아야만 합니다. ");
        map.put("User name should be 6-18 characters", "사용자 이름은 6~18자여야 합니다. ");
        map.put("Password should be 6-12 characters", "비밀번호는 6~12자여야 합니다. ");
        map.put("Illegal email address", "정당한 이메일 주소");
        map.put("Wait...", "기다리세요. ");
        map.put("The shortest username requires 6 characters", "가장 짧은 사용자 이름은 6자 입니다. ");
        map.put("The minimum password required is 6 characters", "최소 비밀번호는 6자입니다. ");
        map.put("The password and confirmation password are inconsistent!", "비밀번호와 비밀번호 확인이 일치하지 않습니다. ");
        map.put("Get the authentication code:", "승인 코드를 얻으세요. ");
        map.put("User logged out", "사용자 로그 아웃");
        map.put("Logout failed", "로그아웃 실패");
        map.put("Logout failed:", "로그아웃 실패");
        map.put("Cancel", "취소");
        map.put("Confirm", "확인");
        map.put("Prompt", "프롬프트");
        map.put("Has started", "시작되었음");
        map.put("Has stopped", "종료되었음");
        map.put("Has been suspended", "지연되었음");
        map.put("Offline", "오프라인");
        map.put("Online", "온라인");
        map.put("Running", "실행중");
        map.put("Standby", "대기중");
        map.put("Abnormal", "비정상 ");
        map.put("Unknown", "알려지지않음. ");
        map.put("Remote Readiness", "원격 준비되었음");
        map.put("Running", "실행중");
        map.put("Pause", "중지");
        map.put("Self checking", "자가 확인");
        map.put("Gas filling", "가스 충전");
        map.put("Pause", "중지");
        map.put("Laser start ", "레이져 시작");
        map.put("Printing", "프린팅");
        map.put("Pause", "중지");
        map.put("Complete", "완료");
        map.put("Standby", "대기중");
        map.put("Close", "닫힘");
        map.put("Open", "열림");
        map.put("Locked", "잠김");
        map.put("Click once more to exit the application", "어플을 종료하기 위해 클릭을 한번 더 누르세요.");
        map.put("Suspend", "중단");
        map.put("Start prompting:", "프롬프트 시작");
        map.put("Start", "시작되었음");
        map.put("Stop prompting:", "프롬프트 정지");
        map.put("Please wait a moment......", "잠시 기다려주세요.");
        map.put("Please wait a moment...", "잠시 기다려주세요. ");
        map.put("The printer is not in the \"ready\", \"in print\" or \"pause\" state. The remote operation option cannot be turned on!", "프린터는 \"준비\"나 \"인쇄 중\" 혹은 \"정지\" 상태가 아닙니다. 원격 작업 옵션이 켜질 수 없습니다. ");
        map.put("Open remote options?", "원격 옵션을 열까요? ");
        map.put("The alarm has been read and the notification failed!", "알람이 인식되고 알림에 실패했습니다. ");
        map.put("Alarm Read Notification Abnormal:", "알람 인식 공지 기능 이상");
        map.put("No notification on this machine", "장비에 대한 알림이 없습니다. ");
        map.put("Successful start-up", "성공적인 시작");
        map.put("File does not exist", "파일이 없습니다. ");
        map.put("Document damage", "문서 손상");
        map.put("Other errors", "기타 에러");
        map.put("Stop Success", "중지 성공");
        map.put("Stop Failure", "중지 실패");
        map.put("Successful suspension", "성공적인 중지");
        map.put("Suspension failure", "중지 실패");
        map.put("Laser", "레이져 ");
        map.put("Status:", "상태: ");
        map.put("Temperature:", "온도: ");
        map.put("Prediction of Powder Addition", "파우더 추가 예상");
        map.put("Register successfully, please login!", "성공적으로 등록, 로그인하세요. ");
        map.put("Maintenance during rainy season", "장마 기간 동안의 유지보수");
        map.put("Do you want to log out ?", "로그 아웃 하시겠습니까? ");
        map.put("Printer: ", "프린터: ");
        map.put("Warning Code: ", "경고 코드: ");
        map.put("Warning Description: ", "경고 설명: ");
        map.put("The alarm message is not processed and cannot be returned. Please click on it alone or empty it all.", "알람 메시지가 진행이 안되고 돌아갈 수 없습니다. 단독으로 클릭하거나 모두 비우세요. ");
        map.put("Notification List: ", "알림 리스트: ");
        map.put("Do you want to clear all warning messages?", "모든 경고 메시지를 삭제하시겠습니까? ");
        map.put("Locked", "잠겨있음");
        map.put("Close", "닫힘");
        map.put("Open", "열림");
        map.put("YES", "네");
        map.put("Adding Powder", "파우더 추가 ");


        return map;
    }

    private Map getCommonInitData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Remember me", "나를 기억할 것");
        map.put("Username", "사용자 이름");
        map.put("Password", "비밀번호");
        map.put("Sign in", "회원 로그인");
        map.put("Join now", "지금 합류하세요. ");
        map.put("Forgot password?", "비밀번호를 잊으셨습니까? ");
        map.put("New to Profeta 3D Cloud?", "Profeta 3D Cloud로 새것을 전송하시겠습니까? ");
        map.put("Register", "등록하기");
        map.put("Username*", "사용자이름*");
        map.put("6-18 characters", "6-18 자");
        map.put("Password*", "비밀번호* ");
        map.put("6-12 characters", "6-12 자");
        map.put("Confirm*", "확인*");
        map.put("Enter your password again", "다시 귀하의 비밀번호를 입력하세요. ");
        map.put("Realname*", "실제 이름*");
        map.put("Enter your real name", "귀하의 실제 이름을 입력하세요. ");
        map.put("Phone*", "전화번호*");
        map.put("Enter the phone number", "전화번호를 입력하세요. ");
        map.put("Email*", "Email*");
        map.put("Enter your email", "이메일을 넣으세요. ");
        map.put("Role*", "직위*");
        map.put("Printer Administrator", "프린터 작업자");
        map.put("Developer", "개발자");
        map.put("Customers", "고객");
        map.put("Printers", "프린터 ");
        map.put("Enter serial number, separated by #", "일련 번호를 ##으로 구분하여 입력하십시오");
        map.put("Password Reset", "비밀번호 재설정");
        map.put("Email:", "Email:");
        map.put("Enter the registered email", "등록 된 이메일 주소를 입력하십시오");
        map.put("Get Code", "코드 받기");
        map.put("Code:", "코드:");
        map.put("Enter the code", "이메일로받은 인증 코드를 입력하십시오.");
        map.put("New Password:", "새로운 비밀번호:");
        map.put("Enter a new password", "새로운 비밀번호 입력하기");
        map.put("Confirm:", "확인:");
        map.put("Enter the new password again", "새로운 비밀번호를 다시 입력하세요.");
        map.put("Reset Password", "비밀번호를 재설정하세요. ");
        map.put("3D Cloud", "3D Cloud");
        map.put("Logout", "로그아웃");
        map.put("Settings", "파라미터");
        map.put("Work Details", "작업 구분");
        map.put("Back", "뒤로 가기");
        map.put("Info", "정보");
        map.put("Printing Information", "프린팅 정보");
        map.put("File List:", "파일 리스트:");
        map.put("Height:", "높이:");
        map.put("Thickness:", "두께:");
        map.put("Printing Progress", "작업 상태");
        map.put("Printing Process:", "작업 상태:");
        map.put("Layer Progress:", "레이어 상태:");
        map.put("Time Schedule:", "시간 스케줄:");
        map.put("Time Details:", "시간 세부 내용:");
        map.put("Schedule Update Time:", "스케줄 업데이트 시간: ");
        map.put("Start", "시작");
        map.put("Stop", "종료");
        map.put("Device Information", "장비 정보");
        map.put("Network Status:", "네트워크 상태:");
        map.put("Working Status:", "작업 상태:");
        map.put("Chamber Door:", "챔버 도어:");
        map.put("Chamber Pressure:", "챔버 압력:");
        map.put("Oxygen Content:", "산소 함유도:");
        map.put("Duration Of Filter:", "필터 사용 기간:");
        map.put("Hour(s)", "시간 (S):");
        map.put("Laser Status:", "레이져 상태: ");
        map.put("Laser Temperature:", "레이져 온도: ");
        map.put("Molding Position:", "몰딩 포지션: ");
        map.put("Supply Position:", "공급 포지션:");
        map.put("Scraper Position:", "스크래퍼 포지션: ");
        map.put("Chiller Status:", "냉각기 상태:");
        map.put("Water Temperature:", "물 온도:");
        map.put("Water Flow:", "물 흐름: ");
        map.put("Conductivity:", "전도도: ");
        map.put("Nitrogen Generator Management", "질소 생성기 관리");
        map.put("Nitrogen Purity:", "질소 순도:");
        map.put("SLMS Version:", "SLMS Version:");
        map.put("Inform", "공지 ");
        map.put("Back", "뒤로가기");
        map.put("Clean", "청소");
        map.put("Settings", "수치");
        map.put("Alarm Ring", "알람 링");
        map.put("Printing Ring", "프린팅 링");
        map.put("Version:", "버전: ");
        map.put("Version Check", "버전 확인");

        return map;
    }

}
