package com.axelprz.contactsdirectory.service;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.Group;
import com.axelprz.contactsdirectory.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private IGroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group getGroupById(Integer id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + id));
    }

    public Group updateGroup(Integer id, Group groupDetails) {
        Group group = getGroupById(id);

        group.setName(groupDetails.getName());

        return groupRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        Group group = getGroupById(id);
        groupRepository.delete(group);
    }
}
