package com.example.goldenticketnew.service.branch;


import com.example.goldenticketnew.dtos.BranchDto;
import com.example.goldenticketnew.model.Branch;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.resquest.GetAllBranchRequest;
import com.example.goldenticketnew.repository.IBranchRepository;
import com.example.goldenticketnew.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService implements IBranchService {

    @Autowired
    private IBranchRepository IBranchRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BranchDto> getBranchesThatShowTheMovie(Integer movieId) {
        List<Branch> branches = IBranchRepository.getBranchThatShowTheMovie(movieId);
        return branches.stream().map(BranchDto::new).collect(Collectors.toList());
    }
    @Override
    public PageResponse<BranchDto> getAllBranch(GetAllBranchRequest request) {
        Page<Branch> branchPage = IBranchRepository.findAll(request.getSpecification(), request.getPageable());
        return new PageResponse<>(branchPage.map(BranchDto::new));
    }
}
