package com.github.wolfie.kuramud.client.commands.chat;

import org.vaadin.console.Console;
import org.vaadin.console.Console.Command;

import com.github.wolfie.kuramud.server.PlayerCharacter;

public class Say implements Command {

    private static final long serialVersionUID = -59431370586086904L;

    private final PlayerCharacter player;

    public Say(final PlayerCharacter player) {
        this.player = player;
    }

    @Override
    public Object execute(final Console console, final String[] argv)
            throws Exception {
        String message = "";
        if (argv != null) {
            for (int i = 1; i < argv.length; i++) {
                message += argv[i] + " ";
            }
        }
        player.getCurrentRoom().say(player, message);
        return null;
    }

    @Override
    public String getUsage(final Console console, final String[] argv) {
        return "Use 'say' to speak in the chat";
    }

}
