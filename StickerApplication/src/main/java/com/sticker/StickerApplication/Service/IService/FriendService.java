package com.sticker.StickerApplication.Service.IService;

import org.springframework.http.ResponseEntity;


public interface FriendService {

    ResponseEntity<?> addFriend(Long userId, Long fuserId);

    ResponseEntity<?> deleteFriend(Long userId, Long fuserId);

    ResponseEntity<Boolean> isFriend(Long userId, Long fuserId);
}
