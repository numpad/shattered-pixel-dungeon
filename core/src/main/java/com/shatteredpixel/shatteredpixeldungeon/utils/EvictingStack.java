/*
 * Shattered Pixel Dungeon
 * Copyright (C) 2021 Christian Schäl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.utils;

import java.util.Stack;

public class EvictingStack<E> extends Stack<E> {
	private final int maxElements;

	public EvictingStack(int maxElements) throws IllegalArgumentException {
		if (maxElements < 1) throw new IllegalArgumentException("maxElements needs to be at least 1.");
		this.maxElements = maxElements;
	}

	public E push(E item) {
		super.push(item);
		while (this.size() > maxElements) {
			remove(0);
		}
		return item;
	}

}
