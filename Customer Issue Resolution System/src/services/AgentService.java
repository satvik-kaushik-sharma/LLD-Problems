package services;

import manager.IssueQueueManager;
import models.Agent;
import models.Issue;
import models.IssueType;
import strategies.agent.AgentAssignmentStrategy;

import java.util.List;
import java.util.Map;

public class AgentService {
    private Map<String, Agent> agentRepo;
    private AgentAssignmentStrategy agentAssignmentStrategy;
    IssueQueueManager issueQueueManager = IssueQueueManager.getInstance();

    public Agent addAgent(String name, List<IssueType> expertiseIssueTypes) {
        Agent agent = new Agent(name, expertiseIssueTypes);
        agentRepo.put(agent.getId(), agent);
        return agent;
    }

    public Agent assignAgent(Issue issue) throws Exception {
        List<Agent> agents = agentRepo.values().stream().filter(Agent::isAvailable).toList();
        Agent assignedAgent = agentAssignmentStrategy.assignAgent(issue, agents);
        if(assignedAgent == null) {
            issueQueueManager.addIssue(issue);
        } else {
            this.assignAgentToIssue(assignedAgent, issue);
            assignedAgent.setCurrentIssue(issue);
            issue.setAssignedAgent(assignedAgent);
        }
        return assignedAgent;
    }

    public void handleAgentAvailable(Agent agent) {
        agent.setCurrentIssue(null);
        for(Issue issue: issueQueueManager.getAllPendingIssues()) {
            if(agentAssignmentStrategy.agentCanBeAssigned(issue, agent)) {
                issue.setAssignedAgent(agent);
                agent.setCurrentIssue(issue);
                issueQueueManager.removeIssue(issue);
                break;
            }
        }
    }

    private void assignAgentToIssue(Agent assignedAgent, Issue issue) throws Exception {
        if(assignedAgent.getCurrentIssue() != null) throw new Exception("Agent is not available");
        assignedAgent.setCurrentIssue(issue);
        issue.setAssignedAgent(assignedAgent);
    }


}
