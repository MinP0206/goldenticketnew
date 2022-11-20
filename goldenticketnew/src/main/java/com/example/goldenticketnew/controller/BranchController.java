package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.dtos.BranchDto;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.resquest.GetAllBranchRequest;
import com.example.goldenticketnew.service.branch.IBranchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/branches", produces = "application/json")
@Tag(name = "Branch Controller", description = "Thao tác với các chi nhánh")
public class BranchController {
    @Autowired
    private IBranchService branchService;

    @GetMapping
    public ResponseEntity<List<BranchDto>> getBranchesThatShowTheMovie(@RequestParam Integer movieId) {
        return new ResponseEntity<>(branchService.getBranchesThatShowTheMovie(movieId), HttpStatus.OK);
    }
    @Operation(
        summary = "Get All Branch với filter ",
        description = "- Get All Branch với filter"
    )
    @GetMapping("/getAll")
    public ResponseEntity<PageResponse<BranchDto>> getAllBranch(@ParameterObject Pageable pageable , @ParameterObject GetAllBranchRequest request) {
        request.setPageable(pageable);
        return new ResponseEntity<>(branchService.getAllBranch(request), HttpStatus.OK);
    }
}


