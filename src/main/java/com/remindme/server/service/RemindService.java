package com.remindme.server.service;

import com.remindme.server.entity.Remind;

import java.util.List;

public interface RemindService {

    List<Remind> getAll();

    Remind getById(Long id);

    Remind saveOrUpdate(Remind remind);

    void remove(Long id);
}
