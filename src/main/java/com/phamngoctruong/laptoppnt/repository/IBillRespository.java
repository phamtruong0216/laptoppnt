package com.phamngoctruong.laptoppnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phamngoctruong.laptoppnt.model.Bill;

public interface IBillRespository extends JpaRepository<Bill, Long>{

}
