package entity;

public class Department {
    private Integer id;
    private String name;
    private String description;
    private Boolean deleted;

    public Department() {
    }

    public Department(Integer id, String name, String description,  Boolean deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_deleted=" + deleted +
                '}';
    }

    public String printName(){
        return name;
    }
}
