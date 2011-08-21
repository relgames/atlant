package org.relgames.atlant.persistence;

/**
 * @author relgames
 */
public class Expert {
    private String id;
    private String name;
    private int votes;
    private String imageUrl;

    public Expert(String id, String name, int votes, String imageUrl) {
        this.id = id;
        this.name = name;
        this.votes = votes;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", votes=" + votes +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
