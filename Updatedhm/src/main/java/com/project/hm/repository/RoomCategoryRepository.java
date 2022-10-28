package com.project.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hm.entity.RoomsCategory;

@Repository

public interface RoomCategoryRepository extends JpaRepository<RoomsCategory, Long> {

}
