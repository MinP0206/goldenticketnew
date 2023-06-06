package com.example.goldenticketnew.payload.resquest;

import com.example.goldenticketnew.model.Branch;
import com.example.goldenticketnew.model.Movie;
import com.example.goldenticketnew.model.Room;
import com.example.goldenticketnew.model.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GetAllScheduleRequest {
    @JsonIgnore
    private Pageable pageable;

    private Integer movieId;

    private Integer branchId;

    private String startDate;

    private String startTime;
    private Integer roomId;

    private Integer isAdmin;


    public Specification<Schedule> getSpecification() {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (movieId != null) {
                Join<Movie, Schedule> join = root.join("movie", JoinType.INNER);
                predicates.add(cb.equal(join.get(Movie.Fields.id), movieId));
            }
            if (branchId != null) {
                Join<Branch, Schedule> join = root.join("branch", JoinType.INNER);
                predicates.add(cb.equal(join.get(Branch.Fields.id), branchId));
            }
            if (roomId != null) {
                Join<Room, Schedule> join = root.join("room", JoinType.INNER);
                predicates.add(cb.equal(join.get(Room.Fields.id), roomId));
            }
            if (isAdmin == null && startDate == null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get(Schedule.Fields.dateTime), LocalDateTime.now()));
            }
            if (startDate != null) {
                LocalDate date = LocalDate.parse(startDate);
                if(date.isEqual(LocalDate.now()) && startTime == null && isAdmin == null){
                    log.debug(String.valueOf(LocalDateTime.now()));
                    predicates.add(cb.greaterThanOrEqualTo(root.get(Schedule.Fields.startTime), LocalTime.now()));
                }
                predicates.add(cb.equal(root.get(Schedule.Fields.startDate), date));
            }
            if (startTime != null) {
                predicates.add(cb.equal(root.get(Schedule.Fields.startTime), LocalTime.parse(startTime)));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
