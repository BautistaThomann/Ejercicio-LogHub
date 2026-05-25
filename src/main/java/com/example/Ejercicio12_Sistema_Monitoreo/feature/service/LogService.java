package com.example.Ejercicio12_Sistema_Monitoreo.feature.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Ejercicio12_Sistema_Monitoreo.feature.dto.request.LogRequestDTO;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.ClientApplication;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.entity.Log;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.repository.ClientApplicationRepository;
import com.example.Ejercicio12_Sistema_Monitoreo.feature.repository.LogRepository;

@Service
public class LogService {

    private final LogRepository logRepository;
    private final ClientApplicationRepository applicationRepository;

    public LogService(LogRepository logRepository,
            ClientApplicationRepository applicationRepository) {

        this.logRepository = logRepository;
        this.applicationRepository = applicationRepository;
    }

    public void create(LogRequestDTO dto) {

        ClientApplication app = applicationRepository.findById(dto.getAppId())
                .orElseThrow(() -> new RuntimeException("Aplicación no encontrada"));

        Log log = new Log();

        log.setMessage(dto.getMessage());
        log.setLogLevel(dto.getLogLevel());
        log.setTimestamp(LocalDateTime.now());
        log.setApplication(app);

        logRepository.save(log);
    }

    public List<Log> getAll() {

        return logRepository.findAll();
    }

    public List<Log> getByAppId(Long appId) {

        return logRepository.findByApplicationId(appId);
    }

    public List<Log> getByDates(
            LocalDateTime from,
            LocalDateTime to) {

        return logRepository.findByTimestampBetween(from, to);
    }
}
