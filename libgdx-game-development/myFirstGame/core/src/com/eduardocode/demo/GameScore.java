package com.eduardocode.demo;

public class GameScore
{

    private int dropsGathered;

    private final ScreenText scoreText;

    private final String templateText;

    private final RainGatheredChecker rainGatheredChecker;

    public GameScore(final Drop game, ApplicationSettings applicationSettings, GameSettings gameSettings,
                     RainGatheredChecker rainGatheredChecker)
    {
        this.rainGatheredChecker = rainGatheredChecker;
        dropsGathered = 0;

        scoreText = new ScreenText();
        scoreText.setxPosition(applicationSettings.getOriginWidth());
        scoreText.setyPosition(applicationSettings.getHeight());

        game.assignFont(scoreText);

        templateText = gameSettings.getAsset(GameSettings.TextPlaceholder.DROPS_COLLECTED);
        updateScoreText();
    }

    public ScreenText getScoreText()
    {
        return scoreText;
    }

    public void updateNewScore(Rain rain, Bucket bucket)
    {
        dropsGathered += rainGatheredChecker.checkForRaindrops(rain, bucket);
        updateScoreText();
    }


    private void updateScoreText()
    {
        scoreText.setText(templateText + dropsGathered);
    }

    public void dispose()
    {
        rainGatheredChecker.dispose();
    }
}
