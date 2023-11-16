package com.example.job.service;

import com.example.job.Repository.JobRepo;
import com.example.job.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;
    public Job updateJobState(Integer id, boolean newState) {
        Optional<Job> optionalJob = jobRepo.findById(id);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            job.setEtat(newState);
            return jobRepo.save(job);
        } else {
            // Gérer l'erreur, par exemple en lançant une exception
            throw new IllegalArgumentException("Job not found with id: " + id);
        }
    }

    public List<Job> FindAll(){
        return jobRepo.findAll();
    }
    public Optional<Job> getJobById( Integer id) {
        return jobRepo.findById(id);
    }

    public List<Job> getJobsByService(String service) {
        return jobRepo.findByService(service);
    }
}
