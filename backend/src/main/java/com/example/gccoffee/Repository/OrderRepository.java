package com.example.gccoffee.Repository;

import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    String FIND_BY_EMAIL_QUERY = "select o from Order o where o.email = :email";
    String FIND_BY_EMAIL_AND_DAY_ORDER_QUERY_MYSQL = "SELECT * from ORDERS WHERE email = :email AND CREATED_AT BETWEEN DATE_SUB(DATE_FORMAT(:date,'%Y-%m-%d 14:00:00'), INTERVAL 1 DAY) AND DATE_FORMAT(:date,'%Y-%m-%d 14:00:00')";
    //2022-10-5_yeoooo : 작일 ~ 당일 2시 까지의 Order를 찾아내는 쿼리
    String FIND_BY_EMAIL_AND_DAY_ORDER_NEW_QUERY_MYSQL = "select * from Orders  WHERE email = :email AND created_at > DATE_FORMAT(:date,'%Y-%m-%d 14:00:00')";
    //2022-10-5_yeoooo : 당일 2시 이후의 Order를 찾아내는 쿼리

    @Query(FIND_BY_EMAIL_QUERY)
    public List<Order> findByEmail(String email);

    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAY_ORDER_QUERY_MYSQL)
    public Optional<Order> findByEmailAndDayOrder(@Param("email")String email, @Param("date") LocalDateTime localDatetime);
    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAY_ORDER_NEW_QUERY_MYSQL)
    public Optional<Order> findByEmailAndDayOrderAfter(@Param("email")String email, @Param("date") LocalDateTime localDatetime);

    public List<Order> findByOrderStatus(OrderStatus orderStatus);

    public Optional<Order> findById(UUID id);

    /**
     * H2
     * public final String FIND_BY_EMAIL_AND_DAYORDER_QUERY_H2 = "select * from Orders where email = :email and (created_at >= timestampadd(day,-1, formatdatetime(:date,'yyyy-MM-dd 14:00:00')) and created_at <= formatdatetime(:date, 'yyyy-MM-dd 14:00:00'))";
     * public final String FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_H2 = "select * from Orders where email = :email and (created_at > formatdatetime(:date, 'yyyy-MM-dd 14:00:00'))";
     *
     * @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_QUERY_H2)
     * public Optional<Order> findByEmailAndDayOrder(@Param("email")String email, @Param("date") LocalDateTime localDatetime);
     *
     * @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_H2)
     * public Optional<Order> findByEmailAndDayOrderAfter(@Param("email")String email, @Param("date") LocalDateTime localDatetime);
     */



}
