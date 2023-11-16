package com.example.job.Controller;

import com.example.job.Repository.JobRepo;
import com.example.job.entities.Job;
import com.example.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")

public class JobController {
    @Autowired
    private JobService jobService;
    @PatchMapping("/{id}/updateState/{newState}")
    public ResponseEntity<Job> updateJobState(@PathVariable Integer id, @PathVariable boolean newState) {
        Job updatedJob = jobService.updateJobState(id, newState);
        return ResponseEntity.ok(updatedJob);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.FindAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/service/{service}")
    public List<Job> getJobsByService(@PathVariable String service) {
        return jobService.getJobsByService(service);
    }
}
