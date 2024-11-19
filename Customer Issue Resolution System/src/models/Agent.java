package models;

import java.util.List;
import java.util.UUID;

public class Agent extends Observer {
    String id;
    String name;
    Issue currentIssue;

    List<IssueType> expertiseIssueTypes;

    public Agent(String name, List<IssueType> expertiseIssueTypes) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.expertiseIssueTypes = expertiseIssueTypes;
    }

    public String getId() {
        return id;
    }

    public void setCurrentIssue(Issue currentIssue) {
        this.currentIssue = currentIssue;
    }

    public Issue getCurrentIssue() {
        return currentIssue;
    }

    public boolean isAvailable() {
        return this.currentIssue == null;
    }
}
