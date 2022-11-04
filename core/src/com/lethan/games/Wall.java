package com.lethan.games;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Wall {

    private final int width;
    private final int height;
    private int y;
    private int x;
    private World world;

    public Wall(World world, int x, int y, int width, int height) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean containsPoint(double px, double py) {
        return ((px >= x) && (py >= y) && (px < (x + width)) && (py < (y + height)));
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(x,y,width,height);
        shapeRenderer.end();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
