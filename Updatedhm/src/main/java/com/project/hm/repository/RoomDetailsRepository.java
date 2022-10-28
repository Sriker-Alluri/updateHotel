package com.project.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hm.entity.RoomDetails;

@Repository

public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Long> {

}
