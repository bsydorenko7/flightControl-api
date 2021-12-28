package com.quantumproject.flightcontrol.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface FlyingManagerService {

    public boolean isAvailableTicket(long id);
}
