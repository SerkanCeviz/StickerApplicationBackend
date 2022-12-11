package com.sticker.StickerApplication.Service.ServiceImpl;

import com.sticker.StickerApplication.Entity.Request.StickerPackageRequest;
import com.sticker.StickerApplication.Entity.StickerPackage;
import com.sticker.StickerApplication.Repository.StickerPackageRepository;
import com.sticker.StickerApplication.Service.IService.StickerPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StickerPackageServiceImpl implements StickerPackageService{

    private final StickerPackageRepository stickerPackageRepository;
    @Override
    public ResponseEntity<StickerPackage> getByName(Long userId, String packageName) {
        return new ResponseEntity<>(stickerPackageRepository.getByNameAndUserId(packageName,userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addPackage(Long userId, StickerPackageRequest stickerPackage) {
        StickerPackage stickerPackage1 = new StickerPackage();
        stickerPackage1.setUserId(userId);
        stickerPackage1.setEnabled(true);
        stickerPackage1.setName(stickerPackage.getName());
        stickerPackage1.setImageUrl(stickerPackage.getImageUrl());
        stickerPackageRepository.save(stickerPackage1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StickerPackage>> getAll(Long userId) {
        return new ResponseEntity<>(stickerPackageRepository.findAllByUserId(userId),HttpStatus.OK) ;
    }
}
