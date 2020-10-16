package org.medium.examples.metrics.service;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.graphite.GraphiteConfig;
import io.micrometer.graphite.GraphiteMeterRegistry;
import org.medium.examples.metrics.entity.Request;
import org.medium.examples.metrics.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;
    //private Counter requestCounter = Metrics.counter("counter","demo");
//    private GraphiteConfig graphiteConfig = new GraphiteConfig() {
//        @Override
//        public String host() {
//            return "localhost";
//        }
//
//        @Override
//        public String get(String k) {
//            return null; // accept the rest of the defaults
//        }
//    };

//    @Bean
//    public MeterRegistryCustomizer<MeterRegistry> commonTags() {
//        return r -> r.config().commonTags("application", "demo");
//    }


//    public void counter(int id) {
//        Request request = requestRepository.getRequestById(id);
//        if ((Objects.nonNull(request))) {
//            long currentCount = request.getCount();
//            request.setCount(currentCount + 1);
//            requestRepository.save(request);
//        }
//    }

//    public void addMetric(Request request) throws SocketException, UnknownHostException {
//        GraphiteClient client = GraphiteClientFactory.defaultGraphiteClient("localhost", 2003);
//
//        long epoch = System.currentTimeMillis() / 1000;
//        CarbonMetric metric = new SimpleCarbonMetric(formatString(request), String.valueOf(request.getCount()), epoch);
//        System.out.println("add metric................");
//        client.saveCarbonMetrics(metric);
//    }

    private String formatString(Request request) {
        return String.format("request.%s.%s.%s", request.getId(), request.getMethod(), request.getName());
    }

    public Request getRequest(int id) {
        Request request = requestRepository.getRequestById(id);
        if (!Objects.nonNull(request)) {
            return new Request();
        }
        return request;
    }

//    public JsonNode query(Request request) throws Exception {
//        String graphiteHost = "localhost";
//        QueryableGraphiteClient client = GraphiteClientFactory.queryableGraphiteClient(graphiteHost);
//
//        String target = "constantLine(" + formatString(request) + ")";
//
//        JsonFormatter formatter = new JsonFormatter();
//        GraphiteQueryBuilder<JsonNode> builder = new GraphiteQueryBuilder<>(formatter);
//        GraphiteQuery<JsonNode> query = builder.setTarget(target).build();
//
//        JsonNode results = client.query(query);
//        return results;
//    }

    public void registryMetric(Request request) {
        //CompositeMeterRegistry compositeRegistry = new CompositeMeterRegistry();
        GraphiteMeterRegistry graphiteMeterRegistry = new GraphiteMeterRegistry(GraphiteConfig.DEFAULT, Clock.SYSTEM);

//        counter.increment(1);
        Metrics.addRegistry(graphiteMeterRegistry);
    }

    void counter() {
        //requestCounter.increment();
    }


}