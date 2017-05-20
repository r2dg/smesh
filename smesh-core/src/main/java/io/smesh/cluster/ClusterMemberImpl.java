package io.smesh.cluster;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

public class ClusterMemberImpl implements ClusterMember {
    private final String name;
    private final String uuid;
    private final Role role;
    private final boolean local;


    public ClusterMemberImpl(String name, String uuid, Role role, boolean local) {
        this.name = Objects.requireNonNull(name, "name is required");
        this.uuid = Objects.requireNonNull(uuid, "uuid is required");
        this.local = Objects.requireNonNull(local, "local is required");;
        this.role = Objects.requireNonNull(role, "role is required");;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public boolean isLocal() {
        return local;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClusterMember)) {
            return false;
        }

        if (isLocal()) {
            return super.equals(obj);
        }

        ClusterMember other = (ClusterMember) obj;
        EqualsBuilder builder = new EqualsBuilder() //
                .append(getName(), other.getName());
        builder.append(getUuid(), other.getUuid());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        if (isLocal()) {
            return super.hashCode();
        }

        HashCodeBuilder builder = new HashCodeBuilder().append(getName()).append(getUuid());
        return builder.toHashCode();
    }

    @Override
    public String toString() {
        return getName();
    } // TODO: implement
}
