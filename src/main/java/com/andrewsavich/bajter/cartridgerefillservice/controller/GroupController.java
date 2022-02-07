package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.GroupTitleExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.cartridge.Group;
import com.andrewsavich.bajter.cartridgerefillservice.service.group.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/groups", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getCartridgeGroupList(){
        log.info("Controller: getting group list");

        return groupService.getAllGroups();
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long groupId){
        log.info("Controller: getting group with id: " + groupId);
        Group group = groupService.getGroupById(groupId);

        log.info("Controller: sending group with id: " + groupId);
        return ResponseEntity.ok(group);
    }

    @GetMapping("/title/{groupTitle}")
    public ResponseEntity<Group> getGroupByTitle(@PathVariable String groupTitle){
        log.info("Controller: getting group with title: " + groupTitle);
        Group group = groupService.getGroupByTitle(groupTitle);

        log.info("Controller: sending group with title: " + groupTitle);
        return ResponseEntity.ok(group);
    }

    @PostMapping
    public void createGroup(@RequestBody @Valid Group group){
        log.info("Controller: Got group for creating: " + group);

        if(groupService.isExistGroupTitle(group)){
            throw new GroupTitleExistsException("Group with title '" + group.getTitle() + "' is exist");
        }

        groupService.createGroup(group);
    }

    @PutMapping
    public void updateGroup(@RequestBody @Valid Group group){
        log.info("Controller: Got group for updating: " + group);

        if(groupService.isExistGroupTitle(group)){
            throw new GroupTitleExistsException("Group with title '" + group.getTitle() + "' is exist");
        }

        groupService.updateGroup(group);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId){
        log.info("Controller: Deleting group with id: " + groupId);

        groupService.deleteGroupById(groupId);
    }

}