package com.phamngoctruong.laptoppnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phamngoctruong.laptoppnt.model.Banner;
@Repository
public interface IBannerRespository  extends JpaRepository<Banner, Long>{

}
