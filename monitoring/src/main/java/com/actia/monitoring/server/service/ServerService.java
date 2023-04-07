package com.actia.monitoring.server.service;

import com.actia.monitoring.server.model.Server;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ServerService {
    Server create (Server server);
    Server ping(String ipAddr);
    Collection<Server> list();
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);

}
