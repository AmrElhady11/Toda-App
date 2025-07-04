package com.TodaApp.service.Impl;

import com.TodaApp.entity.Item;
import com.TodaApp.entity.ItemDetails;
import com.TodaApp.exception.NotFoundException;
import com.TodaApp.repository.ItemDetailsRepository;
import com.TodaApp.repository.ItemRepository;
import com.TodaApp.request.ItemRequest;
import com.TodaApp.response.ItemResponse;
import com.TodaApp.security.user.CustomUser;
import com.TodaApp.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemDetailsRepository itemDetailsRepository;
    @Override
    @Transactional
    public void addNewItem(ItemRequest request) {
      ItemDetails itemDetails = ItemDetails.builder()
                        .description(request.getDescription())
                        .createdAt(LocalDateTime.now())
                        .status(request.getStatus())
                        .priority(request.getPriority())
                        .build();
     itemDetailsRepository.save(itemDetails);

     Item item=   Item.builder()
                .title(request.getTitle())
                .userID(getUserId())
                .itemDetails(itemDetails)
                .build();
     itemRepository.save(item);


    }

    @Override
    @Transactional
    public void deleteItem(int itemId) {

        itemRepository.deleteById(itemId).orElseThrow(()-> new NotFoundException(String.format("Item with ID %d not found", itemId)));

    }

    @Override
    @Transactional
    public void updateItem(int id ,ItemRequest request) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("Item with ID %d not found", id)));

        ItemDetails itemDetails = itemDetailsRepository.findById(item.getItemDetails().getId()).orElseThrow(()-> new NotFoundException(String.format("Item with ID %d not found", item.getItemDetails().getId())));

        itemDetails.setDescription(request.getDescription());
        itemDetails.setStatus(request.getStatus());
        itemDetails.setPriority(request.getPriority());
        itemDetailsRepository.save(itemDetails);
        item.setTitle(request.getTitle());
        item.setItemDetails(itemDetails);
        itemRepository.save(item);
    }

    @Override
    public ItemResponse findItem(int id) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("Item with ID %d not found", id)));
        ItemDetails itemDetails = itemDetailsRepository.findById(item.getItemDetails().getId()).orElseThrow(()-> new NotFoundException(String.format("Item with ID %d not found", item.getItemDetails().getId())));
       ItemResponse response = ItemResponse.builder()
               .itemId(item.getId())
               .title(item.getTitle())
               .description(itemDetails.getDescription())
               .status(itemDetails.getStatus())
               .priority(itemDetails.getPriority())
               .build();
        return response;
    }
    private int getUserId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUser user = (CustomUser) auth.getPrincipal();
        return user.getUserId();
    }
}
