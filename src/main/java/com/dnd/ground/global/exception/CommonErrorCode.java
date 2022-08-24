package com.dnd.ground.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @description 에러 코드 구현체
 * @author  박찬호
 * @since   2022-08-24
 * @updated 1. 에러 코드 구현 생성
 *          - 2022.08.24 박찬호
 */

@RequiredArgsConstructor
@Getter
public enum CommonErrorCode implements ErrorCode {
    //4XX~
    NOT_FOUND_USER(HttpStatus.BAD_REQUEST, "회원이 존재하지 않습니다."),
    NOT_FOUND_CHALLENGE(HttpStatus.BAD_REQUEST, "챌린지가 존재하지 않습니다."),

    //5XX
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 동작 중 에러가 발생했습니다."),
    SQL_INTEGRITY_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SQL 처리 중 무결성 문제가 발생했습니다."),
    NULL_POINTER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Null Pointer 예외가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}