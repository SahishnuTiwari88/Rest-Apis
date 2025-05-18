package com.tokengenerate.dao;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tokengenerate.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

	@Query("SELECT COUNT(t) FROM Token t WHERE t.deskNo = :deskNo AND t.timestamp < :timestamp")
	int countByDeskNoAndTimestampBefore(@Param("deskNo") String deskNo, @Param("timestamp") LocalDateTime timestamp);

	@Query(value = "SELECT MAX(tokenNo) FROM Token")
	String findLastTokenNumber();

}
	


