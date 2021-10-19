package assignment6_1;

import assignment5_4.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobCatalog {

    private List<Job> jobs;

    public JobCatalog() {
        jobs = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder jobsBuilder = new StringBuilder();
        for (Job job : jobs) {
            jobsBuilder.append(job).append("\n");
        }
        return "Job Catalog: \n" + jobsBuilder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobCatalog that = (JobCatalog) o;
        return Objects.equals(jobs, that.jobs);
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
