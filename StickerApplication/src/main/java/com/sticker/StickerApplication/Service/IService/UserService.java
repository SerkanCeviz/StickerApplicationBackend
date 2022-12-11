package com.sticker.StickerApplication.Service.IService;

import com.sticker.StickerApplication.Entity.Users;
import org.springframework.http.ResponseEntity;


public interface UserService {

    ResponseEntity<?> addUser(Users user);

    ResponseEntity<Users> findByNicknameAndPassword(String nickname, String password);


    ResponseEntity<Users> findByNickname(String nickname);
}
