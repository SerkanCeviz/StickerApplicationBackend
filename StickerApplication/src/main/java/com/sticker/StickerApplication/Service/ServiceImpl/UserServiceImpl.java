package com.sticker.StickerApplication.Service.ServiceImpl;

import com.sticker.StickerApplication.Entity.Users;
import com.sticker.StickerApplication.Repository.UserRepository;
import com.sticker.StickerApplication.Service.IService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUser(Users user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Users> findByNicknameAndPassword(String nickname, String password) {
        return new ResponseEntity<>(userRepository.findByNickNameAndPassword(nickname, password),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Users> findByNickname(String name) {
        return new ResponseEntity<>(userRepository.findByNickName(name),HttpStatus.OK);
    }
}