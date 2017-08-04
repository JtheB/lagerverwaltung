package de.jtheb.fh.lagerverwaltung.entities;

public class Item {
    private String articleNr;
    private String name;
    private int height;
    private int width;
    private int depth;

    public String getArticleNr() {
        return articleNr;
    }

    public void setArticleNr(final String articleNr) {
        this.articleNr = articleNr;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(final int depth) {
        this.depth = depth;
    }

    public int getVolume() {
        return depth * width * height;
    }

    @Override
    public String toString() {
        return "Item{" +
                "articleNr='" + articleNr + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }
}
