package webService;

import com.google.gson.Gson;
import dto.FeedObjects;
import model.ProjectManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;

@Path("/WebService")
public class FeedService {

    @GET
    @Path("/GetFeeds")
    @Produces("application/json")
    public String feed() {
        String feeds  = null;
        try {
            ArrayList<FeedObjects> feedData = null;
            ProjectManager projectManager = new ProjectManager();
            feedData = projectManager.GetFeeds();
            //StringBuffer sb = new StringBuffer();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);

        } catch (Exception e) {
            System.out.println("error");
        }
        return feeds;

    }
}
