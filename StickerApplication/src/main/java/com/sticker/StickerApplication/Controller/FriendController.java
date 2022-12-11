package com.sticker.StickerApplication.Controller;

import com.sticker.StickerApplication.Service.IService.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/friend")
public class FriendController {

    private final FriendService friendService;

    @PostMapping(value = "/addFriend/{userId}")
    public ResponseEntity <?> addFriend(@PathVariable Long userId,
                                        @RequestBody Long fuserId){
        return friendService.addFriend(userId, fuserId);
    }

    @DeleteMapping(value = "/deleteFriend/{userId}/{fuserId}")
    public ResponseEntity<?> deleteFriend(@PathVariable Long userId,
                                          @PathVariable Long fuserId){
        return friendService.deleteFriend(userId,fuserId);
    }

    @GetMapping(value = "/isFriend/{userId}/{fuserId}")
    public ResponseEntity<Boolean> isFriend(@PathVariable Long userId,
                                            @PathVariable Long fuserId){
        return friendService.isFriend(userId,fuserId);
    }
}
