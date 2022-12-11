package com.sticker.StickerApplication.Service.IService;

import com.sticker.StickerApplication.Entity.Sticker;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface StickerService {

    ResponseEntity<List<Sticker>> getStickers(Long userId);

    ResponseEntity<List<Sticker>> getAll();

    ResponseEntity<?> addSticker(Long packageId, Sticker sticker);

    ResponseEntity<?> updateSticker(Long packageId, Sticker sticker, Long stickerId);

    ResponseEntity<?> deleteSticker(Long packageId, Long stickerId);

    ResponseEntity<List<Sticker>> getAllByPackageId(Long packageId);


}
