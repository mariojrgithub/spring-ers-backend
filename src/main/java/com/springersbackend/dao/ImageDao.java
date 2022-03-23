package com.springersbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springersbackend.entity.ImageEntity;

@Repository
public interface ImageDao extends JpaRepository<ImageEntity, Integer> {

}
