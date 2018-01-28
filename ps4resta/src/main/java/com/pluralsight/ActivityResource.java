package com.pluralsight;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pluralsight.model.Activity;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities") //http:localhost:8080/exercise-services/webapi/activies
public class ActivityResource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
		
		@GET
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public List<Activity> getAllActivities() {
			return activityRepository.findAllActivities();
		}
		
		@GET
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		@Path("{activityId}") ////http:localhost:8080/exercise-services/webapi/activies/1234
		public Activity getActivity(@PathParam("activityId") String activityId) {
			return activityRepository.findActivity(activityId);
		}
		
//		@Produces(MediaType.APPLICATION_XML)
//		@Produces(MediaType.APPLICATION_JSON)

}
