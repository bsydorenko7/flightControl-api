package com.quantumproject.flightcontrol.services;

import com.quantumproject.flightcontrol.dao.FlyingManagerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FlyingManagerServiceImp implements FlyingManagerService {

    private final FlyingManagerDao flyingManagerDao;

    public FlyingManagerServiceImp(FlyingManagerDao flyingManagerDao) {
        this.flyingManagerDao = flyingManagerDao;
    }

    @Override
    public boolean isAvailableTicket(long id) {
        log.info("IN isAvailableTicket - checking ticket with id " + id);
        return flyingManagerDao.isAvailableTicket(id);
    }
}
