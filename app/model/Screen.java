package app.model;

import app.utils.OsUtils;

import java.io.IOException;

public class Screen{
    private String content;
    private String info;
    private String options;


    Screen(){
        content = "";
        options = "";
        info = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    private void clear() throws IOException {
        if (OsUtils.isUnix()) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } else {
            Runtime.getRuntime().exec("cls");
        }
    }

    private void draw() {
        System.out.println(content);
        System.out.println(options);
        System.out.println(info);
        System.out.println("> ");
    }

    public void update() {
        try {
            clear();
        } catch (IOException ignored) {
        }
        draw();
    }


}
