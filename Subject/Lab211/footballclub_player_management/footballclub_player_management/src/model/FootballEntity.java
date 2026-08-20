package model;

import java.util.Objects;

/**
 * Common abstraction for entities managed by the application.
 */
public abstract class FootballEntity {
    private String id;

    protected FootballEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    public abstract String toDataString();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FootballEntity)) {
            return false;
        }
        FootballEntity other = (FootballEntity) obj;
        return id != null && other.id != null && id.equalsIgnoreCase(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id == null ? null : id.toUpperCase());
    }
}
