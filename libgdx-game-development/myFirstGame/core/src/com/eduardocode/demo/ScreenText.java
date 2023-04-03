package com.eduardocode.demo;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenText implements BatchDrawable, FontAssignable
{
    private BitmapFont font;

    private String text;

    private int xPosition;
    private int yPosition;

    public ScreenText() {}

    public ScreenText(String text, int xPosition, int yPosition)
    {
        this.text = text;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public BitmapFont getFont()
    {
        return font;
    }

    @Override
    public void setFont(BitmapFont font)
    {
        this.font = font;
    }

    public String getText()
    {
        return text;
    }

    public int getxPosition()
    {
        return xPosition;
    }

    public int getyPosition()
    {
        return yPosition;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setxPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        font.draw(batch, getText(), getxPosition(), getyPosition());
    }
}
