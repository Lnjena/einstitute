package com.einstitute.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.einstitute.core.domain.Attendance;
import com.einstitute.core.domain.AttendanceId;

public interface AttendanceRepository extends MongoRepository<Attendance, AttendanceId> {
	
	public static final String ATTND_REPORT_STND_VIEW = "{'grp_id':?0, 'grp_activity_id':?1}, {'attnd_report':{$elemMatch:{'entity_id' : ?2}}}";

				
	@Query(ATTND_REPORT_STND_VIEW)
	List<Attendance> getAttendanceHistory(@Param("groupId") String groupId, @Param("activityId") String activityId, @Param("entityId")String entityId);
	
}
