package com.sticker.StickerApplication.Repository;

import com.sticker.StickerApplication.Entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {
    Friend getByUserIdAndFollowingUserId(Long userId, Long fuserId);

    List<Friend> findAllByUserId(Long userId);

    Friend findTopByUserIdAndFollowingUserId(Long userId, Long fuserId);
}
