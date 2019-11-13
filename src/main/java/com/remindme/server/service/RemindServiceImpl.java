package com.remindme.server.service;

import com.remindme.server.entity.Remind;
import com.remindme.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RemindServiceImpl implements RemindService {

    @Autowired
    private RemindRepository remindRepository;

    public List<Remind> getAll() {
        return remindRepository.findAll();
    }

    public Remind getById(Long id) {
        return remindRepository.findOne(id);
    }

    public Remind saveOrUpdate(Remind remind) {
        return remindRepository.saveAndFlush(remind);
    }

    public void remove(Long id) {
        remindRepository.delete(id);
    }
}
