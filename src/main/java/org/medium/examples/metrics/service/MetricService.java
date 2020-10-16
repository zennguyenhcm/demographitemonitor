package org.medium.examples.metrics.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MetricService {

    @Autowired
    private MetricRepository repo;

    private List<ArrayList<Integer>> statusMetric;
    private List<String> statusList;

    public MetricService(MetricRepository repo) {
        this.repo = repo;
    }
}
