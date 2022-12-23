package com.sticker.StickerApplication.Repository;

import com.sticker.StickerApplication.Entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByNickNameAndPassword(String nickname, String password);

    Users findByNickName(String nickname);

    Users getById(Long id);
}
