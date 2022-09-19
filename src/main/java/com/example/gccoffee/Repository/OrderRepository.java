package com.example.gccoffee.Repository;

import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    public static final String FIND_BY_EMAIL_QUERY = "select o from Order o where o.email = :email";
    public static final String FIND_BY_EMAIL_AND_DAYORDER_QUERY_MYSQL = "select o from Order o where o.email = :email and (DATEADD(DAY,-1,DATE_FORMAT(:localDateTime,'%Y-%m-%d-%T')) and o.date between DATE_FORMAT(:localDateTime,'%Y-%m-%d-%T')) ";
    public static final String FIND_BY_EMAIL_AND_DAYORDER_QUERY_H2 = "select * from Orders where email = :email and (created_at >= timestampadd(day,-1, formatdatetime(:date,'yyyy-MM-dd 14:00:00')) and created_at <= formatdatetime(:date, 'yyyy-MM-dd 14:00:00'))";
    public static final String FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_H2 = "select * from Orders where email = :email and (created_at > formatdatetime(:date, 'yyyy-MM-dd 14:00:00'))";
//    select * from Orders where created_at >= timestampadd(day,-1, formatdatetime('2022-09-08 17:58:00','yyyy-MM-dd 14:00:00')) and created_at <= formatdatetime('2022-09-08 17:58:00', 'yyyy-MM-dd 14:00:00')

    @Query(FIND_BY_EMAIL_QUERY)
    public List<Order> findByEmail(String email);

    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_QUERY_H2)
    public Optional<Order> findByEmailAndDayOrder(@Param("email")String email, @Param("date") LocalDateTime localDatetime);

    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_H2)
    public Optional<Order> findByEmailAndDayOrderNew(@Param("email")String email, @Param("date") LocalDateTime localDatetime);

    public List<Order> findByOrderStatus(OrderStatus orderStatus);


}
