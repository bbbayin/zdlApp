package com.zdl.bean;

import java.util.List;

/**
 * Created by bayin on 2016/11/10.
 */

public class DreamResultBean{

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":"1232","type":"生活类","title":"杀猪","result":"梦见杀猪，子孙会生病，发生交通事故或有其它灾难，尤其是用刀器杀猪的梦，是一家之中有人会生病之兆。"},{"id":"798","type":"物品类","title":"猪肉","result":"梦见猪肉，是得病的预兆。老人梦见猪肉，会得病。病人梦见猪肉，病情会恶化。"},{"id":"517","type":"动物类","title":"野猪","result":"1.如果你对雄野猪的印象是凶猛，可能它代表你内心的某部分在争取承认。2.如果你把生殖与它相联，那么是直接的性象征。另一方面，生殖有更隐喻的意义：即，给被压抑的部分生命。3.如果它给你的印象是兽性。那么兽性可能指原始的或不为社会接受的压抑部分。4.如果它与罪恶相联或是它对你有性暗示，它的代表你自己压抑的与性有关的情感。5.代表攻击性。人的攻击性有时朝向自己。所以你应该找到你的攻击性的源头。如男性可能与俄狄浦斯情结有关。"},{"id":"510","type":"动物类","title":"猪","result":"梦见猪走动，福星高照。梦见猪逃跑，困难要来到。梦见给伙房杀猪，内脏有病。梦见追赶猪，努力是徒劳的。女人梦见做猪肉，会吃了上顿没下顿。梦见猪，会捷报频传。梦见一群猪，家里要增加人口。梦见猪朝自己扑来，会染上传染病。梦见两头猪争斗，所从事的工作会失败。梦见猎狗追猪，要当心小偷和强盗。"},{"id":"467","type":"动物类","title":"刺猬、豪猪","result":"男人梦见刺猬或豪猪的刺，会交发运，发大财。女人梦见刺猬或豪猪的刺，格守贞操，会名扬天下。"},{"id":"430","type":"动物类","title":"黑猪","result":"梦见黑猪，生活会幸福。"},{"id":"104","type":"建筑类","title":"猪圈","result":"梦见猪圈，吉兆，生活会幸福。梦见猪圈着火，预示着事业会一帆风顺。"}]
     */

    private int code;
    private String msg;
    /**
     * id : 1232
     * type : 生活类
     * title : 杀猪
     * result : 梦见杀猪，子孙会生病，发生交通事故或有其它灾难，尤其是用刀器杀猪的梦，是一家之中有人会生病之兆。
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String id;
        private String type;
        private String title;
        private String result;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
