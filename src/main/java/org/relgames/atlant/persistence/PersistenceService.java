package org.relgames.atlant.persistence;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author relgames
 */
@Service
public class PersistenceService {
    private TreeSet<Expert> experts = new TreeSet<Expert>();

    public List<Expert> getExperts() {
        return new ArrayList<Expert>(experts);

    }

    public synchronized void addExpert(Expert expert) {
        if (experts.contains(expert)) {
            experts.remove(expert);
        }
        experts.add(expert);
    }
}
