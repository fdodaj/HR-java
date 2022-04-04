package model;

import java.util.Date;

public class PermissionDTO {
    private Date fromDate;
    private Date toDate;
    private String reason;
    private Integer businessDays;
    private String permissionStatus;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getFromDate() {
        return fromDate;
    }


    public void setToDate(Date toDate) {
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

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    @Override
    public String toString() {
        return "PermissionDTO{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", reason='" + reason + '\'' +
                ", businessDays=" + businessDays +
                ", permissionStatus='" + permissionStatus + '\'' +
                '}';
    }
}
