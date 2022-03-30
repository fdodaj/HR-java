package entity;

import java.time.LocalDate;
import java.util.Date;

public class Holiday {
    private Integer id;
    private String name;
    private String description;
    private LocalDate date;
    private Boolean active;
    private  Boolean deleted;

    public Holiday() {
    }


    public Holiday(Integer id, String name, String description, LocalDate date, Boolean active, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.deleted = deleted;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_active=" + active +
                ", is_deleted=" + deleted +
                ", date=" + date +
                '}';
    }
}
