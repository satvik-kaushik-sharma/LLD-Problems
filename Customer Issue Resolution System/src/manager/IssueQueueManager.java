package manager;

import models.Issue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IssueQueueManager {
    static private IssueQueueManager instance;
    private IssueQueueManager() {
        this.waitingIssues = new LinkedList<>();
    }

    static public IssueQueueManager getInstance() {
        if(IssueQueueManager.instance == null) {
            IssueQueueManager.instance = new IssueQueueManager();
        }
        return IssueQueueManager.instance;
    }

    LinkedList<Issue> waitingIssues;

    public void addIssue(Issue issue) {
        waitingIssues.addLast(issue);
    }

    public void removeIssue(Issue issue) {
        waitingIssues.remove(issue);
    }

    public List<Issue> getAllPendingIssues() {
        return new ArrayList<>(waitingIssues);
    }

}
