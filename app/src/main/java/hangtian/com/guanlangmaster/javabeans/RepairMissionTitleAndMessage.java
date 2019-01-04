package hangtian.com.guanlangmaster.javabeans;

public class RepairMissionTitleAndMessage {

    private String groupTitle;
    private String childTitle;


    public RepairMissionTitleAndMessage(String groupTitle, String childTitle) {

        this.groupTitle = groupTitle;
        this.childTitle = childTitle;

    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {

        this.groupTitle = groupTitle;
    }

    public String getChildTitle() {
        return childTitle;
    }

    public void setChildTitle(String childTitle) {
        this.childTitle = childTitle;
    }
}
