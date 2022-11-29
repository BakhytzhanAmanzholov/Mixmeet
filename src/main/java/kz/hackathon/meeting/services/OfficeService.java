package kz.hackathon.meeting.services;

import kz.hackathon.meeting.models.Office;

import java.util.List;

public interface OfficeService extends CrudService<Office, Long> {
    List<Office> findAll();
}
