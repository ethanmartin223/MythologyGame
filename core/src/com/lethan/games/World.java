package com.lethan.games;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    int width;
    int height;
    List<Wall> wallList;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.wallList = new ArrayList<>();
    }

    public void createWall(int wx, int wy, int w, int h) {
        wallList.add(new Wall(this, wx, wy, w, h));
    }

    public boolean intersectingWall(double x, double y) {
        if (0 > x || 0 > y || x > width || y > height) return true;
        for (Wall wall : wallList) {
            if (wall.containsPoint(x, y)) return true;
        }
        return false;
    }

    public void render(ShapeRenderer shapeRenderer) {
        for (Wall wall : wallList) {
            wall.render(shapeRenderer);
        }
    }


}
