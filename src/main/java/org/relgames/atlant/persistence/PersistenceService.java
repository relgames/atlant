package org.relgames.atlant.persistence;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author relgames
 */
@Service
public class PersistenceService {
    private TreeSet<Expert> experts = new TreeSet<Expert>(new Comparator<Expert>() {
        @Override
        public int compare(Expert o1, Expert o2) {
            return o2.getVotes() - o1.getVotes();
        }
    });

    public List<Expert> getExperts() {
        return new ArrayList<Expert>(experts);

    }

    public synchronized void addExpert(Expert expert) {
        if (experts.contains(expert)) {
            experts.remove(expert);
        }
        experts.add(expert);
    }

    public int getSize() {
        return experts.size();
    }

    private Date lastUpdate;

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

}
