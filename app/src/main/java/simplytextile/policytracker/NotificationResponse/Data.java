package simplytextile.policytracker.NotificationResponse;

import java.util.List;

public class Data
{

    private List<NotificationList> notification_list ;

    private Integer totalrecords;

    public List<NotificationList> getNotification_list() {
        return notification_list;
    }

    public void setNotification_list(List<NotificationList> notification_list) {
        this.notification_list = notification_list;
    }

    public Integer getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(Integer totalrecords) {
        this.totalrecords = totalrecords;
    }
}
