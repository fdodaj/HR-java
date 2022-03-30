package entity;

import java.sql.Date;
import java.time.LocalDate;

public class Permission {
    private Integer id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;
    private Integer businessDays;
    private String permissionStatus;
    private Boolean deleted;
    private int user_id;

    public Permission() {
    }

    public Permission(Integer id, LocalDate fromDate, LocalDate toDate, String reason, Integer businessDays, String requestStatus, Boolean deleted, int user_id) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.businessDays = businessDays;
        this.permissionStatus = requestStatus;
        this.deleted = deleted;
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getBusinessDays() {
        return businessDays;
    }

    public void setBusinessDays(Integer businessDays) {
        this.businessDays = businessDays;
    }

    public String getPermissionStatus() {
        return permissionStatus;
    }

    public void setPermissionStatus(String permissionStatus) {
        this.permissionStatus = permissionStatus;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", reason='" + reason + '\'' +
                ", businessDays=" + businessDays +
                ", requestStatus='" + permissionStatus + '\'' +
                ", deleted=" + deleted +
                ", user_id=" + user_id +
                '}';
    }
}
