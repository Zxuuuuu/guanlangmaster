package hangtian.com.guanlangmaster.javabeans;

public class InspectionPlanTitleAndMessage {

    private String title;           // 标题
    private String startTime;       // 开始时间
    private String area;            // 区域
    private String missionState;    // 任务状态
    private String actionCycle;     // 工作周期

    public InspectionPlanTitleAndMessage(String title, String startTime, String actionCycle,
                                            String area, String missionState) {
        this.title = title;
        this.startTime = startTime;
        this.actionCycle = actionCycle;
        this.area = area;
        this.missionState = missionState;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getActionCycle() {
        return actionCycle;
    }

    public void setActionCycle(String estimatedTime) {
        this.actionCycle = actionCycle;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMissionState() {
        return missionState;
    }

    public void setMissionState(String missionState) {
        this.missionState = missionState;
    }
}
