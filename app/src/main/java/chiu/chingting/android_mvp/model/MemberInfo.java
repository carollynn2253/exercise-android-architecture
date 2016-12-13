package chiu.chingting.android_mvp.model;

/**
 * Created by ting.chiu on 2016/12/9.
 */

public class MemberInfo {
    private String name = "";
    private String detail = "";

    public MemberInfo() {
    }

    public MemberInfo(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }
}
