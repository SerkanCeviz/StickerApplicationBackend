package com.sticker.StickerApplication.Service.ServiceImpl;

import com.sticker.StickerApplication.Entity.Friend;
import com.sticker.StickerApplication.Repository.FriendRepository;
import com.sticker.StickerApplication.Service.IService.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;
    @Override
    public ResponseEntity<?> addFriend(Long userId, Long fuserId) {
        Friend friend = new Friend();
        friend.setEnabled(true);
        friend.setUserId(userId);
        friend.setFollowingUserId(fuserId);
        return new ResponseEntity<>(friendRepository.save(friend), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteFriend(Long userId, Long fuserId) {
        Friend friend = friendRepository.getByUserIdAndFollowingUserId(userId ,fuserId);
        friend.setEnabled(false);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> isFriend(Long userId, Long fuserId) {
        Friend friend = null;
        friend = friendRepository.findTopByUserIdAndFollowingUserId(userId ,fuserId);
        if(friend !=null && friend.isEnabled()){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(false,HttpStatus.OK);
        }

    }
}
