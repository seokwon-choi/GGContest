package digico.com.GGcontestb.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum StatusEnum {

    // TODO : message 한글로 변경
    SUCCESS(200, "정상처리되었습니다.", HttpStatus.OK), INVALID_REQUEST(400, "Bad Request", HttpStatus.BAD_REQUEST)
    , UNAUTHORIZE_ERROR(401, "인증에러입니다.", HttpStatus.UNAUTHORIZED)
    , FORBIDDEN(403, "Forbidden", HttpStatus.FORBIDDEN), DATA_NOT_FOUND(404, "Data Not Found", HttpStatus.NOT_FOUND)
    , INTERNAL_SERVER_ERROR(500, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR)
    , BASEURL_BAD_REQUEST(600, "BaseUrl Bad Request")

    // 공지 사항 3000대
    , DEL_NOTICE(3000, "삭제된 공지사항입니다.")
    , NOT_ALLOW_EXTENSION(3001, "허용된 확장자가 아닙니다.")
    , NOTICE_OVER(3002, "이 기간에 등록된 공지사항이 3개 이상입니다.")

    // 사용자 관리 4000대
    // pwd틀림, pwd 5회 이상 틀림, 회원정보 중지 or 탈퇴, 미가입회원, 비밀번호변경시 틀림, 인증번호 틀림, 인증번호 유효시간
    , WRONG_PWD(4000, "Password Not Valid") // 미사용
    , EXCEED_PWD_CNT(4001, "Password Count Exceed")
    , USER_NOT_FOUND(4002, "아이디가 존재하지 않습니다.")
    , USER_WAIT_STTUS(4003, "User Status Wait")
    , USER_NRML_STTUS(4004, "User Status Normal") // 미사용
    , PWD_CHANGE_NOT_VALID(4005, "Password Change Not Valid") // 미사용
    , USER_ALREADY_EXIST(4006, "User Already Exist") // 미사용
    , USER_STTUS_CHANGE_FAIL(4007, "User Status And Authority Change Fail")
    , USER_LOGIN_FAIL(4008, "User Login Fail")
    , PWD_ENCRYPT_ERROR(4009, "Password Encrypt Error") // 미사용
    , USER_UPDATE_FAIL(4010, "User Update Fail") // USER_NOT_FOUND로 변경 검토 필요
    , CREATE_USER_FAIL(4011, "User Create Fail")
    , ATHNNO_NOT_FOUND(4012, "AthnNo Not Found")
    , ATHNNO_VALID_FAIL(4013, "인증에 실패했습니다.")
    , INVALID_PWD(4014, "Invalid Password")
    , ATHNNO_TIME_OUT(4015, "AthnNo Time Out")
    , ATHNNO_EMAIL_TIME_ERROR(4016, "하루에 요청할 수 있는 이메일 인증 요청 횟수(5회)를 초과했습니다.")
    , SUPERUSER_CANNOT_CHANGE(4017, "슈퍼유저의 권한은 변경할 수 없습니다.")
    , SUPERUSER_CANNOT_WITHDRAWAL(4018, "슈퍼유저는 탈퇴시킬 수 없습니다.")
    , SUPERUSER_CANNOT_RESET_PASSWORD(4019, "슈퍼유저는 비밀번호를 초기화할 수 없습니다.")
    , USER_STTUS_WAIT_INITPWD_FAIL(4020, "해당 ID는 승인대기 상태로 비밀번호를 초기화할 수 없습니다")
    , NOT_EXIST_TOKEN(4043, "Not Exist Token", HttpStatus.UNAUTHORIZED)
    , EXPIRED_ACCESS_TOKEN(4044, "Expired Access Token", HttpStatus.UNAUTHORIZED)
    , EXPIRED_REFRESH_TOKEN(4045, "Expried Refresh Token", HttpStatus.UNAUTHORIZED)
    , CAPTCHA_FAIL(4046, "User Captcha Fail", HttpStatus.UNAUTHORIZED)
    , MALFORMED_JWT_TOKEN(4047, "JWT Token Malformed")
    , NOT_PASSED_DAY(4048, "Admr Not Passed Data")

    // , EXPIRED_JWT_TOKEN(4048, "JWT Token Expired")
    , UNSUPPORTED_JWT_TOKEN(4049, "Unsupported JWT Token")
    , JWT_ILLEGAL_ARGUMENT(4050, "JWT Validation Argument Illegal")
    , AUT_ID_NOT_FOUND(4051, "Aut Id Not Found") // DATA_NOT_FOUND로
                                                                                                              // 변경 검토
                                                                                                              // 필요
    , WRONG_USER_ID(4052, "아이디 형식이 다릅니다.")
    , BLANK_USERNM_CHECK(4053, "사용자 이름은 공백일수 없습니다.")
    , BLANK_POS_CHECK(4054, "소속은 공백일수 없습니다.")
    , BLANK_DES_CHECK(4055, "비고란은 공백일수 없습니다")
    , INVALID_STPLT(4056, "유효하지 않은 약관입니다.")
    , ALREADY_USED_PWD(4057, "이미 사용중인 비밀번호입니다.")

    // 시스템 관리, API 관리, 서비스 관리 5000대
    , API_ALREADY_EXIST(5000, "이미 사용중인 API입니다.")
    , DUPLICATED_API_URI_IN(5001, "이미 등록되어 있는 URI In입니다.")
    , API_DELETE_FAIL(5002, "API 삭제 요청에 실패했습니다")
    , API_UPDATE_FAIL(5003, "API Update Fail")
    , BAD_EDPT_REQUEST(5004, "위 형식의 엔드포인트는 인증서나 인증키를 등록할 수 없습니다.")
    , SYS_ALREADY_EXIST(5100, "System Already Exist")
    , SYS_ID_ALREADY_EXIST(5101, "시스템 아이디가 중복됩니다.")
    , CIRCTBRKR_BAD_REQUEST(5102, "장애전파차단 입력 오류입니다.")
    , SVC_ALREADY_EXSIT(5200, "Service Already Exist")
    , DATE_VIOLATE_REQUEST(5201, "서비스 시간 선택이 잘못되었습니다.")
    , DUPLICATED_API_VER(5300, "이미 존재하는 API 버전입니다.")
    , USING_API(5400, "API가 등록되어 있습니다. API 삭제 후 다시 시도 해주세요.")
    , DELETE_SYS(5500, "삭제된 System입니다")
    , API_DELETE_STATUS(5600, "삭제 된 API가 존재합니다.")
    , NOT_EXIST_SPEC(5700, "스웨거 파일이 존재하지 않습니다.")
    , NOT_DEPLOY_STATUS(5800, "배포가능 상태가 아닙니다.")
    , NOT_EXIST_TBLOG(5801, "TB서버에 로그가 존재하지 않습니다.")
    , ALREADY_OPEN_API(5900, "이미 Open API로 등록된 API입니다.")
    , BAD_CERTI_REQUEST(5901, "잘못된 MTLS 인증서입니다.")
    , BAD_JWT_REQUEST(5902, "잘못된 JWT key입니다.")
    

    // 대시보드 6000대
    , DASHBOARD_DATA_NOT_FOUND(6000, "Dashboard Data Not Found") // DATA_NOT_FOUND로 변경 검토 필요
    , DASHBOARD_DIVIDE_ERROR(6001, "ArithmeticException By Zero") // 미사용
    , LOG_PAGE_NUMBER_EXCEED(6002, "Log Page Number Exceed")

    // 공통 Exception 7000대
    , NOT_NULL_VIOLATE(7000, "Not Null Violate")
    , DATA_LENGTH_VIOLATE(7001, "Data Length Violate")
    , EMAIL_VIOLATE(7002, "Email Violate")
    , NOT_EMPTY_VIOLATE(7003, "Not Empty Violate")
    , PATTERN_VIOLATE(7004, "Pattern Violate")
    , BAD_EXTENSION(7005, "지원하지 않는 확장자 입니다.")

    // 권한 관리 8000대
    , SHOW_AUTH_VIOLATE(8000, "읽기 권한이 없는 사용자입니다.")
    , EDIT_AUTH_VIOLATE(8001, "편집 권한이 없는 사용자입니다.")
    , DUPLICATED_AUT_NM(8100, "이미 등록되어 있는 권한명입니다.")
    , USED_AUT(8101, "사용 중인 권한입니다.")
    , SUPERUSER_CANNOT_UPDATE_AUTH(8102, "슈퍼유저의 권한은 수정할 수 없습니다.")
    , SUPERUSER_CANNOT_DELETE_AUTH(8103, "슈퍼유저의 권한은 삭제할 수 없습니다.")

    // 핸들러 관리 9000대
    , CODE_COMPILE_ERROR(9000, "입력한 코드 컴파일이 실패했습니다.")
    , CODE_TEST_FAIL(9001, "코드 테스트 실패했습니다.")
    , DUPLICATED_HNDLR_ID(9002, "이미 등록되어 있는 핸들러 ID입니다.")
    , USED_HNDLR(9003, "사용 중인 핸들러입니다.")
    , DUPLICATED_HNDLR_GRP_ID(9100, "이미 등록되어 있는 핸들러 그룹 ID입니다.")
    , USED_HNDLR_GRP(9101, "사용 중인 핸들러 그룹입니다.")
    , INVALID_SOURCE(9102, "유효하지 않은 소스입니다.")
    , TIME_OUT(9103, "테스트 시간 아웃되었습니다.");

    private int code;

    private String message;

    private HttpStatus status;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    StatusEnum(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
