package com.app.demo.shibie.model;

import java.util.List;

/**
 * 獲取識別結果響應實體
 *
 * @author llw
 * @date 2021/4/2 16:30
 */
public class GetDiscernResultResponse {

    /**
     * log_id : 327863200205075661
     * result_num : 5
     * result : [{"score":0.967622,"root":"公眾人物","baike_info":{"baike_url":"http://baike.baidu.com/item/%E6%96%B0%E5%9E%A3%E7%BB%93%E8%A1%A3/8035884","image_url":"http://imgsrc.baidu.com/baike/pic/item/91ef76c6a7efce1b27893518a451f3deb58f6546.jpg","description":"新垣結衣(Aragaki Yui)，1988年6月11日出生於沖繩縣那霸市。日本女演員、歌手、模特。畢業於日出高中。2001年，參加《nicola》模特比賽並獲得最優秀獎。2005年，因出演現代劇《澀谷15》而作為演員出道。2006年，參演校園劇《我的老大，我的英雄》；同年，她還出版了個人首本寫真集《水漾青春》。2007年，她從日出高校畢業後開始專注於演藝發展，並發表個人首張音樂專輯《天空》；同年，新垣結衣還主演了愛情片《戀空》，而她也憑借該片獲得了多個電影新人獎項。2010年，主演愛情片《花水木》。2011年，主演都市劇《全開女孩》。2012年，相繼參演現代劇《Legal High》、劇情片《劇場版新參者：麒麟之翼》。2013年，主演都市劇《飛翔情報室》。2014年，她主演了劇情片《黎明的沙耶》。2016年，主演愛情喜劇《逃避雖可恥但有用》，並憑借該劇獲得了多個電視劇女主角獎項。2017年，主演愛情片《戀愛回旋》，憑借該片獲得第60屆藍絲帶獎最佳女主角；同年11月，她還憑借醫療劇《Code Blue 3》獲得第94屆日劇學院賞最佳女配角。"},"keyword":"新垣結衣"},{"score":0.716067,"root":"人物-人物特寫","keyword":"頭發"},{"score":0.421281,"root":"商品-穿戴","keyword":"圍巾"},{"score":0.22347,"root":"商品-五金","keyword":"拉鏈"},{"score":0.028031,"root":"商品-穿戴","keyword":"脖套"}]
     */

    private long log_id;
    private int result_num;
    private List<ResultBean> result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getResult_num() {
        return result_num;
    }

    public void setResult_num(int result_num) {
        this.result_num = result_num;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * score : 0.967622
         * root : 公眾人物
         * baike_info : {"baike_url":"http://baike.baidu.com/item/%E6%96%B0%E5%9E%A3%E7%BB%93%E8%A1%A3/8035884","image_url":"http://imgsrc.baidu.com/baike/pic/item/91ef76c6a7efce1b27893518a451f3deb58f6546.jpg","description":"新垣結衣(Aragaki Yui)，1988年6月11日出生於沖繩縣那霸市。日本女演員、歌手、模特。畢業於日出高中。2001年，參加《nicola》模特比賽並獲得最優秀獎。2005年，因出演現代劇《澀谷15》而作為演員出道。2006年，參演校園劇《我的老大，我的英雄》；同年，她還出版了個人首本寫真集《水漾青春》。2007年，她從日出高校畢業後開始專注於演藝發展，並發表個人首張音樂專輯《天空》；同年，新垣結衣還主演了愛情片《戀空》，而她也憑借該片獲得了多個電影新人獎項。2010年，主演愛情片《花水木》。2011年，主演都市劇《全開女孩》。2012年，相繼參演現代劇《Legal High》、劇情片《劇場版新參者：麒麟之翼》。2013年，主演都市劇《飛翔情報室》。2014年，她主演了劇情片《黎明的沙耶》。2016年，主演愛情喜劇《逃避雖可恥但有用》，並憑借該劇獲得了多個電視劇女主角獎項。2017年，主演愛情片《戀愛回旋》，憑借該片獲得第60屆藍絲帶獎最佳女主角；同年11月，她還憑借醫療劇《Code Blue 3》獲得第94屆日劇學院賞最佳女配角。"}
         * keyword : 新垣結衣
         */

        private double score;
        private String root;
        private BaikeInfoBean baike_info;
        private String keyword;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getRoot() {
            return root;
        }

        public void setRoot(String root) {
            this.root = root;
        }

        public BaikeInfoBean getBaike_info() {
            return baike_info;
        }

        public void setBaike_info(BaikeInfoBean baike_info) {
            this.baike_info = baike_info;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public static class BaikeInfoBean {
            /**
             * baike_url : http://baike.baidu.com/item/%E6%96%B0%E5%9E%A3%E7%BB%93%E8%A1%A3/8035884
             * image_url : http://imgsrc.baidu.com/baike/pic/item/91ef76c6a7efce1b27893518a451f3deb58f6546.jpg
             * description : 新垣結衣(Aragaki Yui)，1988年6月11日出生於沖繩縣那霸市。日本女演員、歌手、模特。畢業於日出高中。2001年，參加《nicola》模特比賽並獲得最優秀獎。2005年，因出演現代劇《澀谷15》而作為演員出道。2006年，參演校園劇《我的老大，我的英雄》；同年，她還出版了個人首本寫真集《水漾青春》。2007年，她從日出高校畢業後開始專注於演藝發展，並發表個人首張音樂專輯《天空》；同年，新垣結衣還主演了愛情片《戀空》，而她也憑借該片獲得了多個電影新人獎項。2010年，主演愛情片《花水木》。2011年，主演都市劇《全開女孩》。2012年，相繼參演現代劇《Legal High》、劇情片《劇場版新參者：麒麟之翼》。2013年，主演都市劇《飛翔情報室》。2014年，她主演了劇情片《黎明的沙耶》。2016年，主演愛情喜劇《逃避雖可恥但有用》，並憑借該劇獲得了多個電視劇女主角獎項。2017年，主演愛情片《戀愛回旋》，憑借該片獲得第60屆藍絲帶獎最佳女主角；同年11月，她還憑借醫療劇《Code Blue 3》獲得第94屆日劇學院賞最佳女配角。
             */

            private String baike_url;
            private String image_url;
            private String description;

            public String getBaike_url() {
                return baike_url;
            }

            public void setBaike_url(String baike_url) {
                this.baike_url = baike_url;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }
}
