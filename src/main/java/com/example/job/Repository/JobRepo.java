package com.example.job.Repository;

import com.example.job.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepo extends JpaRepository<Job,Integer> {
    List<Job> findByService(String service);

}
