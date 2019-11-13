package com.remindme.server.controller;

import com.remindme.server.entity.Remind;
import com.remindme.server.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private RemindService service;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getAllReminders() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getRemind(@PathVariable long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveRemind(@RequestBody Remind remind) {
        return service.saveOrUpdate(remind);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteRemind(@PathVariable long id) {
        service.remove(id);
    }

}
