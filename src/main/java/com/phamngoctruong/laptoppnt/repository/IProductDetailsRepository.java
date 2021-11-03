package com.phamngoctruong.laptoppnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phamngoctruong.laptoppnt.model.ProductDetails;


public interface IProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
