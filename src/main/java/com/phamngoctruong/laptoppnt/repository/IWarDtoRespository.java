package com.phamngoctruong.laptoppnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phamngoctruong.laptoppnt.dto.WardDto;
@Repository
@Transactional
public interface IWarDtoRespository extends JpaRepository<WardDto, String> {
	@Query(value ="SELECT * FROM cdwebshoplaptop.ward where ward.districtid=?1" ,nativeQuery = true)
	List<WardDto> findALlWardIdD(String district);

}
