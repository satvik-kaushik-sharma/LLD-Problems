package models;

import java.util.UUID;

public class Issue {
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

    }

    public void markAsResolved() {
        this.issueStatus = IssueStatus.RESOLVED;
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
