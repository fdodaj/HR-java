package model;

import java.util.Date;

public class request_permission {
    private Integer id;
    private Integer user;
    private Date from_date;
    private Date to_date;
    private String reason;
    private Integer business_days;
    private String request_type;
    private String request_status;
    private Boolean is_deleted;

    public request_permission() {
    }

    public request_permission(Integer id, Integer user, Date from_date, Date to_date, String reason, Integer business_days, String request_type, String request_status, Boolean is_deleted) {
        this.id = id;
        this.user = user;
        this.from_date = from_date;
        this.to_date = to_date;
        this.reason = reason;
        this.business_days = business_days;
        this.request_type = request_type;
        this.request_status = request_status;
        this.is_deleted = is_deleted;
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

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getBusiness_days() {
        return business_days;
    }

    public void setBusiness_days(Integer business_days) {
        this.business_days = business_days;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public String getRequest_status() {
        return request_status;
    }

    public void setRequest_status(String request_status) {
        this.request_status = request_status;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "request_permission{" +
                "id=" + id +
                ", user=" + user +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", reason='" + reason + '\'' +
                ", business_days=" + business_days +
                ", request_type='" + request_type + '\'' +
                ", request_status='" + request_status + '\'' +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
