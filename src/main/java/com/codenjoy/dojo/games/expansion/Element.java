package com.codenjoy.dojo.games.expansion;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2022 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.services.printer.CharElement;

import static com.codenjoy.dojo.client.AbstractLayeredBoard.Layers.LAYER1;
import static com.codenjoy.dojo.client.AbstractLayeredBoard.Layers.LAYER2;

public enum Element implements CharElement {

/// Empty space where player can go

    EMPTY(LAYER2, '-',                  "."),

    FLOOR(LAYER1, '.',                  "."),

// Walls

    ANGLE_IN_LEFT(LAYER1, '╔',          "."),

    WALL_FRONT(LAYER1, '═',             "."),

    ANGLE_IN_RIGHT(LAYER1, '┐',         "."),

    WALL_RIGHT(LAYER1, '│',             "."),

    ANGLE_BACK_RIGHT(LAYER1, '┘',       "."),

    WALL_BACK(LAYER1, '─',              "."),

    ANGLE_BACK_LEFT(LAYER1, '└',        "."),

    WALL_LEFT(LAYER1, '║',              "."),

    WALL_BACK_ANGLE_LEFT(LAYER1, '┌',   "."),

    WALL_BACK_ANGLE_RIGHT(LAYER1, '╗',  "."),

    ANGLE_OUT_RIGHT(LAYER1, '╝',        "."),

    ANGLE_OUT_LEFT(LAYER1, '╚',         "."),

    SPACE(LAYER1, ' ',                  "."),

/// Forces stuff

    FORCE1(LAYER2, '♥', 0,              "."),

    FORCE2(LAYER2, '♦', 1,              "."),

    FORCE3(LAYER2, '♣', 2,              "."),

    FORCE4(LAYER2, '♠', 3,              "."),

/// Other stuff

    EXIT(LAYER1, 'E',                   "."),

    HOLE(LAYER1, 'O',                   "."),

    BREAK(LAYER1, 'B',                  "."),

    GOLD(LAYER1, '$',                   "."),

// Bases stuff

    BASE1(LAYER1, '1', 0,               "."),

    BASE2(LAYER1, '2', 1,               "."),

    BASE3(LAYER1, '3', 2,               "."),

    BASE4(LAYER1, '4', 3,               "."),

/// System elements, don't touch it

    FOG(LAYER1, 'F',                    "."),

    BACKGROUND(LAYER2, 'G',             ".");

    public int getIndex() {
        return index;
    }

    public static Element getForce(int index) {
        switch (index) {
            case 0: return FORCE1;
            case 1: return FORCE2;
            case 2: return FORCE3;
            case 3: return FORCE4;
            default: throw new IllegalArgumentException(
                    "Force element bot found for index: " + index);
        }
    }

    private final char ch;
    private final int layer;
    private final int index;
    private final String info;

    Element(int layer, char ch, int index, String info) {
        this.layer = layer;
        this.ch = ch;
        this.index = index;
        this.info = info;
    }

    Element(int layer, char ch, String info) {
        this(layer, ch, -1, info);
    }

    @Override
    public char ch() {
        return ch;
    }

    @Override
    public String info() {
        return info;
    }

    @Override
    public String toString() {
        return String.valueOf(ch);
    }

    public int getLayer() {
        return layer;
    }

    public boolean isWall() {
        return is(
                ANGLE_IN_LEFT,
                WALL_FRONT,
                ANGLE_IN_RIGHT,
                WALL_RIGHT,
                ANGLE_BACK_RIGHT,
                WALL_BACK,
                ANGLE_BACK_LEFT,
                WALL_LEFT,
                WALL_BACK_ANGLE_LEFT,
                WALL_BACK_ANGLE_RIGHT,
                ANGLE_OUT_RIGHT,
                ANGLE_OUT_LEFT,
                SPACE);
    }

    public static final Element[] barriers = new Element[] {
            SPACE,
            BREAK,
            ANGLE_IN_LEFT,
            WALL_FRONT,
            ANGLE_IN_RIGHT,
            WALL_RIGHT,
            ANGLE_BACK_RIGHT,
            WALL_BACK,
            ANGLE_BACK_LEFT,
            WALL_LEFT,
            WALL_BACK_ANGLE_LEFT,
            WALL_BACK_ANGLE_RIGHT,
            ANGLE_OUT_RIGHT,
            ANGLE_OUT_LEFT,
    };

}
