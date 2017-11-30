package dao;

import dto.FeedObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Project {

    public ArrayList<FeedObjects> GetFeeds(Connection connection) throws Exception
    {
        ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
        try
        {
            //String uname = request.getParameter("uname");
            PreparedStatement ps = connection.prepareStatement("SELECT title,description,url FROM website ORDER BY id DESC");
            //ps.setString(1,uname);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                FeedObjects feedObject = new FeedObjects();
                feedObject.setTitle(rs.getString("title"));
                feedObject.setDescription(rs.getString("description"));
                feedObject.setUrl(rs.getString("url"));
                feedData.add(feedObject);
            }
            return feedData;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}


/*
*
*
INSERT INTO website (title, description, url )
VALUES ('Ajax Image Upload without Refreshing Page using Jquery.','Description Text','http://www.9lessons.info/2011/08/ajax-image-upload-without-refreshing.html');
INSERT INTO website (title, description, url )
VALUES ('Java MySQL JSON Display Records using Jquery.','Description Text','http://www.9lessons.info/2012/08/java-json-jquery-display-records.html');
INSERT INTO website (title, description, url )
VALUES ('Java MySQL Insert Record using Jquery.','Description Text','http://www.9lessons.info/2012/07/java-mysql-insert-record-using-jquery.html');
*
* */