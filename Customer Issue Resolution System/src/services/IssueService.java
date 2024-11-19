package services;

import manager.IssueQueueManager;
import models.Agent;
import models.Issue;

import java.util.*;

public class IssueService {
    Map<String, Issue> issueRepo = new HashMap<>();
    AgentService agentService = new AgentService();
    IssueQueueManager issueQueueManager = IssueQueueManager.getInstance();

    public Agent assignIssue(String issueId) throws Exception {
        Issue issue = issueRepo.get(issueId);
        if(issue == null) throw new Exception("Invalid Issue Id");
        Agent agent = agentService.assignAgent(issue);
        return agent;
    }

    public void issueResolved(Issue issue) {
        issue.markAsResolved();
        agentService.handleAgentAvailable(issue.getAssignedAgent());
    }


}
