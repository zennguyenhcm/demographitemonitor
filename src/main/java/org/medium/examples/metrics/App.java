package org.medium.examples.metrics;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.graphite.GraphiteConfig;
import io.micrometer.graphite.GraphiteMeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class App
{
    static final MetricRegistry metrics = new MetricRegistry();
//    static final GraphiteMeterRegistry graphiteMeterRegistry = new GraphiteMeterRegistry(GraphiteConfig.DEFAULT, Clock.SYSTEM);
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
        Meter requests = metrics.meter("requests");
        startReport();
        requests.mark();
        wait5Seconds();
    }


    static void startReport() {
        final Graphite graphite = new Graphite(new InetSocketAddress("localhost", 2003));
        final GraphiteReporter reporter = GraphiteReporter.forRegistry(metrics)
                .prefixedWith("web1.example.com")
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(graphite);
        reporter.start(1, TimeUnit.MINUTES);
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5*1000);
        }
        catch(InterruptedException e) {}
    }
}
