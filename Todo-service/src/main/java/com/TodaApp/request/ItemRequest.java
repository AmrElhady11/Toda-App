package com.TodaApp.request;

import com.TodaApp.enums.ItemPriority;
import com.TodaApp.enums.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private String title ;
    private String description ;
    private ItemPriority priority;
    private ItemStatus status;
}
