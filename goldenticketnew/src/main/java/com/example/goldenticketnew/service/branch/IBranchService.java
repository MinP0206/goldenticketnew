package com.example.goldenticketnew.service.branch;



import com.example.goldenticketnew.dtos.BranchDto;
import com.example.goldenticketnew.model.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBranchService {
    List<BranchDto> getBranchesThatShowTheMovie(Integer movieId);

    Page<Branch> getAllBranch(Pageable pageable);
}
