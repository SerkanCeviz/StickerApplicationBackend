package com.sticker.StickerApplication.Controller;

import com.sticker.StickerApplication.Entity.Request.StickerPackageRequest;
import com.sticker.StickerApplication.Entity.StickerPackage;
import com.sticker.StickerApplication.Service.IService.StickerPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/stickerPackages")
public class StickerPackageController {

    private final StickerPackageService stickerPackageService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<StickerPackage>> getAll(@PathVariable Long userId){
        return stickerPackageService.getAll(userId);
    }

    @GetMapping(value = "/getByName/{userId}")
    public ResponseEntity<StickerPackage> getByName(@RequestParam String packageName,
                                                    @PathVariable Long userId){
        return stickerPackageService.getByName(userId, packageName);
    }

    @PostMapping(value = "/addPackage/{userId}")
    public ResponseEntity<?> addPackage(@RequestBody StickerPackageRequest stickerPackage,
                                        @PathVariable Long userId){
        return stickerPackageService.addPackage(userId,stickerPackage);
    }
}
