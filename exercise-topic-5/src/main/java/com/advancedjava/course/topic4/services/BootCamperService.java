package com.advancedjava.course.topic4.services;

import com.advancedjava.course.topic4.models.BootCamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BootCamperService {
    private final List<BootCamper> bootCampers = new ArrayList<>();

    public List<BootCamper> getAll() {
        return bootCampers;
    }

    public void add(BootCamper bootcamper) {
        bootCampers.add(bootcamper);
    }

    public BootCamper get(String name) {
        Optional<BootCamper> person = bootCampers.stream()
                .filter(bootCamper -> bootCamper.getName().equalsIgnoreCase(name))
                .findFirst();
                return person.orElse(null);
    }

}
