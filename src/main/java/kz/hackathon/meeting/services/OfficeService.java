package kz.hackathon.meeting.services;

import kz.hackathon.meeting.models.Office;

public interface OfficeService extends CrudService<Office, Long> {
    void addRoomToOffice(Long officeID, Long roomID);
}
