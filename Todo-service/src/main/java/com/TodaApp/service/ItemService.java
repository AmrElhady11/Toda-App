package com.TodaApp.service;

import com.TodaApp.request.ItemRequest;
import com.TodaApp.response.ItemResponse;


public interface ItemService {
    void addNewItem(ItemRequest itemRequest);
    void deleteItem(int itemId);
    void updateItem(int id ,ItemRequest itemRequest);
    ItemResponse findItem(int id);

}
