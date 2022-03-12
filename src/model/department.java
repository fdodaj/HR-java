package model;

public class department {
    private Integer id;
    private String name;
    private String description;
    private Integer department_leader;
    private Boolean is_deleted;

    public department() {
    }

    public department(Integer id, String name, String description, Integer department_leader, Boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.department_leader = department_leader;
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

    public Integer getDepartment_leader() {
        return department_leader;
    }

    public void setDepartment_leader(Integer department_leader) {
        this.department_leader = department_leader;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", department_leader=" + department_leader +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
