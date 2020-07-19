/**
 * DVD信息类
 * @Author ZhuMingQ
 * 2020/7/17 19:05
 */
public class DVDInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * DVD名
     */
    private String dvdName;
    /**
     * 状态
     */
    private Integer state = 0;
    /**
     * 借出日期
     */
    private String startDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDvdName() {
        return dvdName;
    }

    public void setDvdName(String dvdName) {
        this.dvdName = dvdName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public DVDInfo(){}

    public DVDInfo(String dvdName) {
        this.dvdName = dvdName;
    }

    public DVDInfo(Integer id, String dvdName, Integer state, String startDate) {
        this.id = id;
        this.dvdName = dvdName;
        this.state = state;
        this.startDate = startDate;
    }

    /**
     * 打印信息
     */
//    public void print(){
//        String st;
//        if(getState() == 0){
//            st = "可借";
//        }else{
//            st = "已借出";
//        }
//        System.out.println(getId()+"\t\t"+st+"\t"+"《"+getDvdName()+"》"+"\t"+getStartDate());
//    }
}
