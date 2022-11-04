package com.lethan.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
		world.createWall(200,200,100,100);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(Color.WHITE);
		int x = Gdx.input.getX();
		int y = Gdx.input.getY();
		float dx;
		float dy;
		float a;
		for (double r=0; r<= 360; r+=1) {
			dx = x;
			dy = y;
			a = (float) (r * (Math.PI / 180F));
			while (!world.intersectingWall(dx,dy)) {
				dx += Math.cos(a);
				dy += Math.sin(a);
			}
			shapeRenderer.line(x, y, dx, dy);
		}
		shapeRenderer.end();
		world.render(shapeRenderer);
	}

	
	@Override
	public void dispose () {
	shapeRenderer.dispose();
	}
}
