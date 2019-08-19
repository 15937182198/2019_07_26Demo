package cn.kgc.pojo;

/**
 * @author LZY
 * @date 2019/8/19 19:54
 * 图片处理实体类
 */
public class picture {
    private int pictureId;
    private String pictureName;
    private String pictureRoute;
    private String pictureInfo;
    public picture() {
    }
    public picture(int picture, String pictureName, String pictureRoute, String pictureInfo) {
        this.pictureId = picture;
        this.pictureName = pictureName;
        this.pictureRoute = pictureRoute;
        this.pictureInfo = pictureInfo;
    }

    public int getPicture() {
        return pictureId;
    }

    public void setPicture(int picture) {
        this.pictureId = picture;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureRoute() {
        return pictureRoute;
    }

    public void setPictureRoute(String pictureRoute) {
        this.pictureRoute = pictureRoute;
    }

    public String getPictureInfo() {
        return pictureInfo;
    }

    public void setPictureInfo(String pictureInfo) {
        this.pictureInfo = pictureInfo;
    }
}
