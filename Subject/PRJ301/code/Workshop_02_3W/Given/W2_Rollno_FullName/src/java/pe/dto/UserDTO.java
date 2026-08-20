package pe.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String user;
    private String fullName;
    private Integer role;
    private boolean inUse;

    public UserDTO() {
    }

    public UserDTO(String user, String fullName, Integer role, boolean inUse) {
        this.user = user;
        this.fullName = fullName;
        this.role = role;
        this.inUse = inUse;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getRoleName() {
        if (role == null) {
            return "Unknown";
        }
        switch (role) {
            case 0:
                return "User";
            case 1:
                return "Manager";
            case 2:
                return "Staff";
            default:
                return "Unknown";
        }
    }
}
