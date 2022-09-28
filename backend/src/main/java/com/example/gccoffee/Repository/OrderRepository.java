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

    public final String FIND_BY_EMAIL_QUERY = "select o from Order o where o.email = :email";

    public final String FIND_BY_EMAIL_AND_DAYORDER_QUERY_MYSQL = "select * from Orders where email = :email and created_at between (DATEADD(DAY,-1,DATE_FORMAT(:date,'%Y-%m-%d-%T')) and DATE_FORMAT(:date,'%Y-%m-%d-%T')) ";
    public final String FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_MYSQL = "select * from Orders where email = :email and (created_at > DATE_FORMAT(:date,'%Y-%m-%d-%T'))";

    public final String FIND_BY_EMAIL_AND_DAYORDER_QUERY_H2 = "select * from Orders where email = :email and (created_at >= timestampadd(day,-1, formatdatetime(:date,'yyyy-MM-dd 14:00:00')) and created_at <= formatdatetime(:date, 'yyyy-MM-dd 14:00:00'))";
    public final String FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_H2 = "select * from Orders where email = :email and (created_at > formatdatetime(:date, 'yyyy-MM-dd 14:00:00'))";

    @Query(FIND_BY_EMAIL_QUERY)
    public List<Order> findByEmail(String email);

//    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_QUERY_H2)
    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_QUERY_MYSQL)
    public Optional<Order> findByEmailAndDayOrder(@Param("email")String email, @Param("date") LocalDateTime localDatetime);

//    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_H2)
    @Query(nativeQuery = true, value = FIND_BY_EMAIL_AND_DAYORDER_NEW_QUERY_MYSQL)
    public Optional<Order> findByEmailAndDayOrderAfter(@Param("email")String email, @Param("date") LocalDateTime localDatetime);

    public List<Order> findByOrderStatus(OrderStatus orderStatus);

    public Optional<Order> findById(UUID id);


}
