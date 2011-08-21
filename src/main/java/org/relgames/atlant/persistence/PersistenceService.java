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
            if (o1.getId().equals(o2.getId())) {
                return 0;
            } else {
                if (o1.getVotes() == o2.getVotes()) {
                    return o1.getId().compareTo(o2.getId());
                } else {
                    return o2.getVotes() - o1.getVotes();
                }
            }
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
