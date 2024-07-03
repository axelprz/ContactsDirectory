package com.axelprz.contactsdirectory.controller;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.Group;
import com.axelprz.contactsdirectory.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Integer id) {
        try{
            Group group = groupService.getGroupById(id);
            return ResponseEntity.ok(group);
        }catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Integer id, @RequestBody Group groupDetails) {
        try{
            Group group = groupService.updateGroup(id, groupDetails);
            return ResponseEntity.ok(group);
        }catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable Integer id) {
        groupService.deleteGroup(id);
    }
}
