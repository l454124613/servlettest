package bases;




/**
 * Created by lixuecheng on 2016/6/23.
 */
public class Widget {
    private  String title="";



    public boolean istitle() {
        return istitle;
    }

    private   boolean istitle=false;
    private   boolean isframe=false;

    public boolean isframe() {
        return isframe;
    }

    public Widget(String... a) {
        if(a!=null&&a.length>0) {
            if (a[0].equalsIgnoreCase("title")) {
                title=a[1];
                istitle=true;
            } else if(a.length>2&&a[2].equalsIgnoreCase("title")){

                title=a[3];
                istitle=true;
                isframe=true;
                Switch.frame(By.getBy(a[0], a[1]));
            }else {
                Switch.frame(By.getBy(a[0], a[1]));
                isframe=true;

            }

        }


        }
      void switchToWin(){
        Switch.window(title);//"百度一下，你就知道"

    }
    void  switchDefaultContent(){
        Switch.defaultContent();
    }


    }

