package com.sticker.StickerApplication.Repository;

import com.sticker.StickerApplication.Entity.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerRepository extends JpaRepository<Sticker,Long> {
    Sticker getById(Long stickerId);

    List<Sticker> getAllByStickerPackageId(Long packageId);

    List<Sticker> findAll();

    List<Sticker> findAllByUserIdIn(List<Long> userId);
}
