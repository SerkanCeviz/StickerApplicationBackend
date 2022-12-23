package com.sticker.StickerApplication.Controller;

import com.sticker.StickerApplication.Entity.Request.StickerRequest;
import com.sticker.StickerApplication.Entity.Sticker;
import com.sticker.StickerApplication.Service.IService.StickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/stickers")
public class StickerController {


    private final StickerService stickerService;


    @GetMapping(value = "/home/{userId}")
    public ResponseEntity<List<Sticker>> getStickers(@PathVariable Long userId){

        return stickerService.getStickers(userId);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Sticker>> getAllSticker(){
        return stickerService.getAll();
    }

    @GetMapping(value = "/getStickers/{packageId}")
    public ResponseEntity<List<Sticker>> getStickerByPackageId(@PathVariable Long packageId){

        return stickerService.getAllByPackageId(packageId);
    }

    @PostMapping(value = "/addSticker/{packageId}")
    public ResponseEntity<?> addSticker(@RequestBody StickerRequest sticker,
                                        @PathVariable Long packageId){
        return stickerService.addSticker(packageId, sticker);
    }

    @PutMapping(value = "/updateSticker/{packageId}/{stickerId}")
    public ResponseEntity<?> updateSticker(@RequestBody Sticker sticker,
                                           @PathVariable Long packageId,
                                           @PathVariable Long stickerId){
        return stickerService.updateSticker(packageId, sticker,stickerId);
    }

    @DeleteMapping(value = "/deleteSticker/{packageId}/{stickerId}")
    public ResponseEntity<?> deleteSticker(@PathVariable Long packageId,
                                           @PathVariable Long stickerId){
        return stickerService.deleteSticker(packageId, stickerId);
    }

    @PostMapping(value = "/addStickerToPackage/{packageId}/{stickerId}")
    public ResponseEntity<?> addStickerToPackage(@PathVariable Long packageId,
                                                 @PathVariable Long stickerId){
        return stickerService.addStickerToPackage(packageId,stickerId);
    }
}
