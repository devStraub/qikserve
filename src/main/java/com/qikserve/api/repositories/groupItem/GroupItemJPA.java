package com.qikserve.api.repositories.groupItem;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qikserve.api.model.entities.GroupItem;

public interface GroupItemJPA extends JpaRepository<GroupItem, Long> {

}
