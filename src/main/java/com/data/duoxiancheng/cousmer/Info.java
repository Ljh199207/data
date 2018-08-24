package com.data.duoxiancheng.cousmer;

public class Info {

    private String title;
    private String content;
    // false 表示可以取走数据，但不能生产数据
    // true 表示可以生产数据，但不能取走数据
    private boolean falg = true;
  /*  public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
*/
    //解决同步问题

    public  synchronized  void set(String title,String content){
        if(falg ==false)
        {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title=title;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content=content;
        this.falg =false;
        super.notify();
    }

    public  synchronized  void get (){
        if(falg == true)
        {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.title +"---"+this.content);
        this.falg=true;
        super.notify();
    }





}
