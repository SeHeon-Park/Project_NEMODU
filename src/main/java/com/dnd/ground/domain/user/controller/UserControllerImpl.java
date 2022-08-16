package com.dnd.ground.domain.user.controller;

import com.dnd.ground.domain.user.dto.HomeResponseDto;
import com.dnd.ground.domain.user.dto.UserResponseDto;
import com.dnd.ground.domain.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 회원 관련 컨트롤러 구현체
 * @author  박세헌, 박찬호
 * @since   2022-08-02
 * @updated 1. 친구 프로필 조회 기능 구현
 *          - 2022.08.16 박찬호
 */

@Api(tags = "유저")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @GetMapping("/home")
    @Operation(summary = "홈 화면 조회",
            description = "닉네임을 통해 홈화면에 필요한 유저 정보(userMatrix), " +
                    "챌린지를 안하는 친구 정보(friendMatrices, 리스트), " +
                    "나와 챌린지를 하는 유저 정보(challengeMatrices, 리스트) 조회")
    public ResponseEntity<HomeResponseDto> home(@RequestParam("nickname") String nickName){
        return ResponseEntity.ok(userService.showHome(nickName));
    }

    @GetMapping("/info")
    @Operation(summary = "회원 정보 조회(마이페이지)", description = "회원의 닉네임, 소개 메시지 정보 (추후 프로필 등 추가 예정)")
    public ResponseEntity<UserResponseDto.UInfo> getUserInfo(@RequestParam("nickname") String nickname) {
        return ResponseEntity.ok().body(userService.getUserInfo(nickname));
    }

    @GetMapping("/profile")
    @Operation(summary = "프로필 조회", description = "회원의 닉네임, 소개 메시지 정보 (추후 프로필 등 추가 예정)")
    public ResponseEntity<UserResponseDto.Profile> getUserProfile(
                            @ApiParam(value = "회원 닉네임", required = true) @RequestParam("user") String userNickname,
                            @ApiParam(value = "대상 닉네임", required = true) @RequestParam("friend") String friendNickname) {

        return ResponseEntity.ok().body(userService.getUserProfile(userNickname, friendNickname));
    }

}
