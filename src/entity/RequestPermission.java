package entity;

import java.util.Date;

public class RequestPermission {
    private Integer id;
    private Integer user;
    private Date fromDate;
    private Date toDate;
    private String reason;
    private Integer businessDays;
    private String requestType;
    private String requestStatus;
    private Boolean deleted;

    public RequestPermission() {
    }

    public RequestPermission(Integer id, Integer user, Date fromDate, Date toDate, String reason, Integer businessDays, String requestType, String requestStatus, Boolean deleted) {
        this.id = id;
        this.user = user;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.businessDays = businessDays;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "request_permission{" +
                "id=" + id +
                ", user=" + user +
                ", from_date=" + fromDate +
                ", to_date=" + toDate +
                ", reason='" + reason + '\'' +
                ", business_days=" + businessDays +
                ", request_type='" + requestType + '\'' +
                ", request_status='" + requestStatus + '\'' +
                ", is_deleted=" + deleted +
                '}';
    }
}
