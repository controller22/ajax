package shop.mtcoding.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.ajax.dto.ResponseDto;

@Controller
public class UserController {

    @GetMapping("/")
    public String d() {

        return "tt";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    // 스프링을 200만 응답 (오류가 안난다면)
    @GetMapping("/user/usernameSameCheck")
    public @ResponseBody ResponseDto<?> check(String username) {
        if (username == null || username.isEmpty()) {
            return new ResponseDto<>(-1, "username 쿼리스트링을 전달해주세요", null);
        }

        if (username.equals("ssar")) { // DB에 있음
            // 같은것이 있다
            return new ResponseDto<>(1, "동일한 username 존재합니다", false);
        } else {
            // 같은것이 없다
            return new ResponseDto<>(1, "해당 username 으로 회원가입 할 수 있습니다", true);
        }
    }
}