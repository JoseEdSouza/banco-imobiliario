package app.model;

import app.utils.OsUtils;

import java.io.IOException;

public class Screen{
    private String content;
    private String info;
    private String options;

    public Screen(){
        content = "";
        options = "";
        info = "";
    }

    public Screen setContent(String content) {
        this.content = content;
        return this;
    }

    public Screen setInfo(String info) {
        this.info = info;
        return this;
    }

    public Screen setOptions(String options) {
        this.options = options;
        return this;
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
        System.out.print("> ");
    }

    public Screen update() {
        try {
            clear();
        } catch (IOException ignored) {
        }
        draw();

        return this;
    }

    public Screen flush(){
        this.content = "";
        this.info = "";
        this.options = "";

        return this;
    }
}
