package com.sticker.StickerApplication.Service.ServiceImpl;

import com.sticker.StickerApplication.Entity.Friend;
import com.sticker.StickerApplication.Entity.Sticker;
import com.sticker.StickerApplication.Repository.FriendRepository;
import com.sticker.StickerApplication.Repository.StickerRepository;
import com.sticker.StickerApplication.Service.IService.StickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StickerServiceImpl implements StickerService {

    private final StickerRepository stickerRepository;
    private final FriendRepository friendRepository;

    @Override
    public ResponseEntity<List<Sticker>> getStickers(Long userId) {
        List<Long> fuserId = friendRepository.findAllByUserId(userId).stream().map(Friend::getFollowingUserId).collect(Collectors.toList());
        return new ResponseEntity<>(stickerRepository.findAllByUserIdIn(fuserId), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> addSticker(Long packageId, Sticker sticker) {
        sticker.setStickerPackageId(packageId);
        return new ResponseEntity<>(stickerRepository.save(sticker),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateSticker(Long packageId, Sticker sticker, Long stickerId) {
        Sticker existSticker= stickerRepository.getById(stickerId);
        existSticker.setStickerName(sticker.getStickerName());
        existSticker.setEnabled(sticker.isEnabled());
        existSticker.setImageUrl(sticker.getImageUrl());
        existSticker.setStickerPackageId(sticker.getStickerPackageId());
        stickerRepository.save(existSticker);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteSticker(Long packageId, Long stickerId) {
        //TODO SOFT DELETİNG
        stickerRepository.deleteById(stickerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Sticker>> getAllByPackageId(Long packageId) {
        List<Sticker> stickers = stickerRepository.getAllByStickerPackageId(packageId);
        return new ResponseEntity<>(stickers,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Sticker>> getAll() {
        List<Sticker> stickers = stickerRepository.findAll();
        return new ResponseEntity<>(stickers,HttpStatus.OK);
    }
}
