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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expert expert = (Expert) o;

        return id != null ? id.equals(expert.id) : expert.id==null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
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
