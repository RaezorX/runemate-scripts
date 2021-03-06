package be.yurimoens.runemate.cabysscrafter.task.altar;

import be.yurimoens.runemate.cabysscrafter.Constants;
import be.yurimoens.runemate.cabysscrafter.Location;
import be.yurimoens.runemate.cabysscrafter.RuneType;
import be.yurimoens.runemate.cabysscrafter.event.CreateRunesListener;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.task.Task;

public class HandleAltar extends Task {

    public HandleAltar(RuneType runeType, CreateRunesListener... listeners) {
        add(new CreateRunes(runeType.ALTAR_MODEL_ID, runeType.RUNE_ID, listeners), new Teleport());
    }

    @Override
    public boolean validate() {
        return (Location.getLocation() == Location.ALTAR);
    }

    @Override
    public void execute() {}
}
