package com.codenjoy.dojo.games.mollymage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import static com.codenjoy.dojo.services.Direction.*;

/**
 * Author: John Ricaurte 
 * <p>
 * This is your AI algorithm for the game.
 * Implement it at your own discretion.
 * Pay attention to {@link YourSolverTest} - there is
 * a test framework for you.
 */
public class YourSolver implements Solver<Board> {

    private Dice dice;
    private Board board;

    Random random = new Random();

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;
        if (board.isGameOver()) return "";
        // TODO put your logic here

        var answer = moveToARandomEmptyAdjacentCell();
        return answer == null ? Command.DROP_POTION : answer;
    }

    private String moveToARandomEmptyAdjacentCell(){


        Point p = board.getHero();
        var elements = NearAnswer.getFromNear(board.getNear(p));
        while(elements.size() > 0){
            int nextMovement = random.nextInt(elements.size());
            var answer = elements.get(nextMovement);
            if(answer.element != Element.NONE) elements.remove(nextMovement);
            return Command.MOVE.apply(answer.direction);
        }
        return null;
    }
}

class NearAnswer{

    final Direction direction;
    public NearAnswer(Direction direction, Element element) {
        this.direction = direction;
        this.element = element;
    }

    final Element element;

    static List<NearAnswer> getFromNear(List<Element> elements){
        List<NearAnswer> nearAnswer = new ArrayList<>(4);
        nearAnswer.add( new NearAnswer(LEFT, elements.get(0)) );
        nearAnswer.add( new NearAnswer(RIGHT, elements.get(1)) );
        nearAnswer.add( new NearAnswer(UP, elements.get(2)) );
        nearAnswer.add( new NearAnswer(DOWN, elements.get(3)) );
        return nearAnswer;
    }
}