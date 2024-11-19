package strategies.agent;

import models.Agent;
import models.Issue;

import java.util.List;

public interface AgentAssignmentStrategy {
    public Agent assignAgent(Issue issue, List<Agent> agents);

    public boolean agentCanBeAssigned(Issue issue, Agent agent);

}
