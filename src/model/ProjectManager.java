package model;

import dao.Database;
import dao.Project;
import dto.FeedObjects;

import java.sql.Connection;
import java.util.ArrayList;

public class ProjectManager {

    public ArrayList<FeedObjects> GetFeeds()throws Exception {
        ArrayList<FeedObjects> feeds = null;
        try {
            Database database= new Database();
            Connection connection = database.Get_Connection();
            Project project= new Project();
            feeds=project.GetFeeds(connection);

        } catch (Exception e) {
            throw e;
        }
        return feeds;
    }

}
