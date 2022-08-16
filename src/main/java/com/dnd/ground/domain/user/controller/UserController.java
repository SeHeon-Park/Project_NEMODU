package com.dnd.ground.domain.user.controller;

import com.dnd.ground.domain.user.dto.UserResponseDto;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description 회원 관련 역할 분리 인터페이스
 * @author  박세헌, 박찬호
 * @since   2022-08-02
 * @updated 1. 친구 프로필 조회 기능 구현
 *          - 2022.08.16 박찬호
 */

public interface UserController {
    ResponseEntity<?> home(@RequestParam("nickName") String nickName);
    ResponseEntity<UserResponseDto.UInfo> getUserInfo(@RequestParam("nickname") String nickname);
    ResponseEntity<UserResponseDto.Profile> getUserProfile(
            @ApiParam(value = "회원 닉네임", required = true) @RequestParam("user") String userNickname,
            @ApiParam(value = "대상 닉네임", required = true) @RequestParam("friend") String friendNickname);
}
