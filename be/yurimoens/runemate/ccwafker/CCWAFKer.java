package be.yurimoens.runemate.ccwafker;

import be.yurimoens.runemate.ccwafker.task.*;
import com.runemate.game.api.client.paint.PaintListener;
import com.runemate.game.api.hybrid.util.StopWatch;
import com.runemate.game.api.script.framework.task.TaskScript;

import java.awt.*;


public class CCWAFKer extends TaskScript implements PaintListener {

    private StopWatch runtime;

    @Override
    public void onStart(String... args) {
        runtime = new StopWatch();
        runtime.start();

        getEventDispatcher().addListener(this);
        setLoopDelay(800, 1500);

        add(
                new SkipResults(),
                new EnterLobby(),
                new EnterFromLobby(),
                new LeaveRespawnRoom(),
                new Idle()
        );
    }

    @Override
    public void onPaint(Graphics2D g) {
        final int xOffset = 60;
        final int yOffset = 10;
        final int lineHeight = 20;

        g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
        g.setFont((new Font("Arial", 0, 12)));
        g.drawString("Time running: " + runtime.getRuntimeAsString(), xOffset, yOffset + lineHeight);
    }

}
