package com.sticker.StickerApplication.Controller;

import com.sticker.StickerApplication.Entity.Users;
import com.sticker.StickerApplication.Service.IService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/addUser")
    public ResponseEntity<?> addUser(@RequestBody Users user){

        return userService.addUser(user);
    }

    @GetMapping(value = "/findByNickname/{nickname}/{password}")
    public ResponseEntity<Users> findByNicknameAndPassword(@PathVariable String nickname,
                                             @PathVariable String password){
        return userService.findByNicknameAndPassword(nickname, password);
    }

    @GetMapping(value = "/findFriend/{nickname}")
    public ResponseEntity<Users> findByNickname(@PathVariable String nickname){
        return userService.findByNickname(nickname);
    }
}
