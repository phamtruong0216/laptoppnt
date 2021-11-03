package com.phamngoctruong.laptoppnt.services;

import org.springframework.data.domain.Page;

import com.phamngoctruong.laptoppnt.model.Product;

public interface IProductServices {
	Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection,long id,String keyword);

}
