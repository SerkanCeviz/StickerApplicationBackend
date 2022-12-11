package com.sticker.StickerApplication.Service.IService;

import com.sticker.StickerApplication.Entity.Request.StickerPackageRequest;
import com.sticker.StickerApplication.Entity.StickerPackage;
import org.springframework.http.ResponseEntity;


import java.util.List;


public interface StickerPackageService {
    ResponseEntity<StickerPackage> getByName(Long userId, String packageName);

    ResponseEntity<?> addPackage(Long userId, StickerPackageRequest stickerPackage);

    ResponseEntity<List<StickerPackage>> getAll(Long userId);
}
