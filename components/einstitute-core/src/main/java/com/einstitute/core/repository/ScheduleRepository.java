package com.einstitute.core.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.schedule.Schedule;

public interface ScheduleRepository extends MongoRepository<Schedule, ObjectId> {

}
