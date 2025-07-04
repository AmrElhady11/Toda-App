package com.TodaApp.repository;

import com.TodaApp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findById(int id);
    Optional<Item> deleteById(int id);
}
