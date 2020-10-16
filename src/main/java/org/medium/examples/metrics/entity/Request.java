package org.medium.examples.metrics.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Request implements Serializable {
    @Id
    private int id;
    private String method;
    private String name;
    private long count;


    public Request(){

    }

    public Request(int id, String method, String name, long count){
        this.id=id;
        this.method=method;
        this.name   =name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
