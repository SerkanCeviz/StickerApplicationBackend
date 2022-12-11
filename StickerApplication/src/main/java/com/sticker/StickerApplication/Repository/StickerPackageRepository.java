package com.sticker.StickerApplication.Repository;

import com.sticker.StickerApplication.Entity.StickerPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerPackageRepository extends JpaRepository<StickerPackage,Long> {
    StickerPackage getByNameAndUserId(String packageName, Long userId);

    List<StickerPackage> findAllByUserId(Long userId);

}