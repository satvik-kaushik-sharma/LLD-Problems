package models;

import java.util.UUID;

public class Issue extends Observable{
    String id;
    String transactionId;
    IssueType issueType;
    String customerEmail;
    IssueStatus issueStatus;
    String subject;
    String description;
    Agent assignedAgent;

    public Issue(String transactionId, IssueType issueType, String customerEmail, IssueStatus issueStatus) {
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.customerEmail = customerEmail;
        this.issueStatus = issueStatus;
        this.id = UUID.randomUUID().toString();
    }

    public void markAsAssigned() {
        this.notifyObservers("The issue with ID:" + this.id + " has been assigned to :" + this.assignedAgent.name);
    }

    public void markAsResolved() {
        this.issueStatus = IssueStatus.RESOLVED;
        this.notifyObservers("The issue with ID:" + this.id + " has been marked as resolved.");
    }

    public String getId() {
        return id;
    }

    public Agent getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(Agent assignedAgent) {
        this.assignedAgent = assignedAgent;
    }
}
