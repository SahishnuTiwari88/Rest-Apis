package com.tokengenerate.dao;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tokengenerate.entity.Desk;
//@Repository
//public interface DeskRepository extends JpaRepository<Desk, Long> {
//	Optional<Desk> findByDeskNo(String deskNo);
//	
//	Optional<Desk> findByStatus(boolean s);
//	
//	@Query("select d from Desk d where d.status = true AND d.deskNo NOT IN "
//			+ "(SELECT t.deskNumber FROM Token t WHERE DATE(t.dateTime) =:date GROUP BY t.deskNumber HAVING COUNT(t) >= 10) "
//			+ "ORDER BY (SELECT COUNT(t) FROM Token t WHERE t.deskNumber = d.deskNo AND DATE(t.dateTime) =:date) ASC")
//	Desk findDeskWithLowestTokenCount(@Param("date") LocalDateTime date);
//	
//	
//}

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {

	Optional<Desk> findByDeskNo(String deskNo);

	Optional<Desk> findByStatus(boolean b);

	@Query("SELECT d FROM Desk d WHERE d.status = true AND d.deskNo NOT IN "
			+ "(SELECT t.deskNumber FROM Token t WHERE DATE(t.datetime) = :date GROUP BY t.deskNumber HAVING COUNT(t) >= 10) "
			+ "ORDER BY (SELECT COUNT(t) FROM Token t WHERE t.deskNumber = d.deskNo AND DATE(t.dateTime) = :date) ASC")
	Desk findDeskWithLowestTokenCount(@Param("datetime") LocalDateTime datetime);

}
