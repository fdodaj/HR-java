package model;

public class holiday {
    private Integer id;
    private String name;
    private String description;
    private Boolean is_active;
    private  Boolean is_deleted;

    public holiday() {
    }

    public holiday(Integer id, String name, String description, Boolean is_active, Boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.is_active = is_active;
        this.is_deleted = is_deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_active=" + is_active +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
