package com.actia.monitoring.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id ;
    @Column(unique = true)
    @NonNull
    private String ipAddress;
    private String name;
    private String type ;
    private String memory;
    private Status status ;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
