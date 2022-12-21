package com.example.goldenticketnew.repository;


import com.example.goldenticketnew.dtos.DayTransactionReport;
import com.example.goldenticketnew.dtos.UserReportDto;
import com.example.goldenticketnew.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill, Integer> , JpaSpecificationExecutor<Bill> {
    @Query(value = "SELECT DATE_FORMAT(bill.created_time,'%Y-%m-%d') dateTran,count(bill.id) transactionCount , count(ticket.id) ticketAmount, sum(bill.price) incomeAmount\n" +
        "FROM bill \n" +
        "INNER JOIN ticket  ON bill.id = bill_id\n" +
        "where bill.status = 1 and DATE_FORMAT(bill.created_time,'%Y-%m-%d') between :fromDate and :toDate " +
        "group by DATE_FORMAT(bill.created_time,'%Y-%m-%d')",nativeQuery = true)
    List<DayTransactionReport> findDashBoardBillByFromDateToDateAndStatusSuccess(@Param("fromDate") String fromDate , @Param("toDate") String toDate);

    @Query(value = "SELECT DATE_FORMAT(bill.created_time,'%Y-%m-%d') dateTran,count(bill.id) transactionCount , 0 ticketAmount, sum(bill.price) incomeAmount\n" +
        "FROM bill \n" +
        "where bill.status = 2 and DATE_FORMAT(bill.created_time,'%Y-%m-%d') between :fromDate and :toDate " +
        "group by DATE_FORMAT(bill.created_time,'%Y-%m-%d')",nativeQuery = true)
    List<DayTransactionReport> findDashBoardBillByFromDateToDateAndStatusEx(@Param("fromDate") String fromDate , @Param("toDate") String toDate);
    @Query(value = "SELECT  u.id id, u.name name,u.username username,u.email email, u.image image, count(b.id) transactionCount , 0 ticketAmount, sum(b.price) incomeAmount\n" +
        "        FROM bill b\n" +
        "        INNER JOIN user u ON b.user_id = u.id\n" +
        "        where b.status = 2 \n" +
        "        group by user_id",nativeQuery = true)
    List<UserReportDto> findAllByStatusExGroupByUser();

    @Query(value = "SELECT  u.id id, u.name name,u.username username,u.email email, u.image image,count(b.id) transactionCount , count(ticket.id) ticketAmount, sum(b.price) incomeAmount\n" +
        "        FROM bill b\n" +
        "\t\tINNER JOIN ticket  ON b.id = bill_id\n" +
        "        INNER JOIN user u ON b.user_id = u.id\n" +
        "        where b.status = 1 \n" +
        "        group by user_id",nativeQuery = true)
    List<UserReportDto> findAllByStatusSuccessGroupByUser();
}