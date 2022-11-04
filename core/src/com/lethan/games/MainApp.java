package com.lethan.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainApp extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	World world;
	OrthographicCamera camera;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);

		world = new World(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		world.createWall(200,200,30,30);
		world.createWall(250,250,30,30);
		world.createWall(300,120,30,30);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(1,1,1,1);
		int x = Gdx.input.getX();
		int y = Gdx.input.getY();
		float dx;
		float dy;
		float a;
		int lightDistance = 300;
		for (double r=0; r<= 360; r+=.1) {
			dx = x;
			dy = y;
			a = (float) (r * (Math.PI / 180F));
			while (true) {
				dx += Math.cos(a);
				dy += Math.sin(a);
				if (world.intersectingWall(dx,dy)) {
					if (Math.sqrt(Math.pow((x - dx),2) + Math.pow((y-dy),2)) < lightDistance) {
						shapeRenderer.point(dx, dy, 0);
					}
					shapeRenderer.line(x,y,dx,dy);
					break;
				}
			}
		}
		shapeRenderer.end();
		//world.render(shapeRenderer);
	}

	
	@Override
	public void dispose () {
	shapeRenderer.dispose();
	}
}
