package hangtian.com.guanlangmaster.javabeans;

import java.lang.ref.SoftReference;

public class InspectionMissionTitleAndMessage {
    private String title;           // 标题
    private String startTime;       // 开始时间
    private String estimatedTime;   // 结束/预期时间
    private String area;            // 区域
    private String missionState;    // 任务状态

    public InspectionMissionTitleAndMessage(String title, String startTime, String estimatedTime,
                                            String area, String missionState) {
        this.title = title;
        this.startTime = startTime;
        this.estimatedTime = estimatedTime;
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

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
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
