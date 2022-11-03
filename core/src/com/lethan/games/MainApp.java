package com.lethan.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainApp extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;

	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		World world = new World(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(Color.WHITE);
		int x = 50;
		int y = 50;
		int line_length = 200;
		double angle_in_radians;
		for (float rotation=0; rotation<= 360; rotation+=1) {
			angle_in_radians = rotation * Math.PI / 180;
			shapeRenderer.line(x,y,(float)(x + line_length *  Math.cos(angle_in_radians)), (float)(y + line_length * Math.sin(angle_in_radians)));

		}
		shapeRenderer.end();
	}

	
	@Override
	public void dispose () {
	shapeRenderer.dispose();
	}
}
