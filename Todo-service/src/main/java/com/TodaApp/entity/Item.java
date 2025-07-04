package com.TodaApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "user_id")
    private int userID;
    @OneToOne
    @JoinColumn(name = "item_details_id")
    private ItemDetails itemDetails;
}
