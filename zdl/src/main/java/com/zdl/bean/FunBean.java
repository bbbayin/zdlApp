package com.zdl.bean;

/**
 * Created by bayin on 2016/11/29.
 */

public class FunBean extends BaseBean<FunBean.NewslistBean> {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-11-30 07:43","title":"林心如挺孕肚与闺蜜聚会 精致小脸气色好","description":"腾讯明星","picUrl":"http://img1.gtimg.com/18/1832/183287/18328707_small.jpg","url":"http://ent.qq.com/a/20161130/004955.htm"},{"ctime":"2016-11-28 09:11","title":"李晨深夜晒了一锅汤，网友都猜是范冰冰下厨了","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/010132.htm"},{"ctime":"2016-11-28 09:26","title":"搞事情！2016韩娱圈被曝的情侣居然这么多？","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/011584.htm"},{"ctime":"2016-11-28 09:53","title":"被誉允儿+秀晶的综合体，居然还是他的妹妹？","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/013594.htm"},{"ctime":"2016-11-28 09:55","title":"女主持摸男星隐秘部位？韩综艺涉性骚扰惹公愤","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/013686.htm"},{"ctime":"2016-11-28 10:04","title":"还记得《搞笑一家人》小儿子吗？他现在长这样","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/014401.htm"},{"ctime":"2016-11-28 10:11","title":"撇下队友去吃鸟蛋，没想到你是这样的都&#26299;秀！","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/014927.htm"},{"ctime":"2016-11-28 10:13","title":"组图：汤晶媚曝赛车手身份 双面佳人实力玩转","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/015087.htm"},{"ctime":"2016-11-28 10:35","title":"@刘亚仁的黑粉，他私信了脏话给你请查收！","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/016588.htm"},{"ctime":"2016-11-28 10:37","title":"组图：梁静出席品牌活动 露背装性感婉约","description":"腾讯明星","picUrl":"","url":"http://ent.qq.com/a/20161128/016695.htm"}]
     */
//
//    private int code;
//    private String msg;
    /**
     * ctime : 2016-11-30 07:43
     * title : 林心如挺孕肚与闺蜜聚会 精致小脸气色好
     * description : 腾讯明星
     * picUrl : http://img1.gtimg.com/18/1832/183287/18328707_small.jpg
     * url : http://ent.qq.com/a/20161130/004955.htm
     */
//
//    private List<NewslistBean> newslist;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public List<NewslistBean> getNewslist() {
//        return newslist;
//    }
//
//    public void setNewslist(List<NewslistBean> newslist) {
//        this.newslist = newslist;
//    }

    public class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
