package com.lumpofcode.collection.vector.impl;

import com.lumpofcode.collection.vector.Vector;
import com.lumpofcode.collection.vector.Vectors;
import com.lumpofcode.collection.vector.VectorIterator;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.function.Function;


/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/

public final class VectorOf16<T> implements Vector<T>, Iterable<T>
{
	private final T element0;
	private final T element1;
	private final T element2;
	private final T element3;
	private final T element4;
	private final T element5;
	private final T element6;
	private final T element7;
	private final T element8;
	private final T element9;
	private final T element10;
	private final T element11;
	private final T element12;
	private final T element13;
	private final T element14;
	private final T element15;

	public VectorOf16(final T element0, final T element1, final T element2, final T element3, final T element4, final T element5, final T element6, final T element7, final T element8, final T element9, final T element10, final T element11, final T element12, final T element13, final T element14, final T element15)
	{
		this.element0 = element0;
		this.element1 = element1;
		this.element2 = element2;
		this.element3 = element3;
		this.element4 = element4;
		this.element5 = element5;
		this.element6 = element6;
		this.element7 = element7;
		this.element8 = element8;
		this.element9 = element9;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element13 = element13;
		this.element14 = element14;
		this.element15 = element15;
	}

	public boolean isEmpty() { return false; }

	public int size() { return 16; }

	public T get(final int index)
	{
		switch(index)
		{
			case 0: return element0;
			case 1: return element1;
			case 2: return element2;
			case 3: return element3;
			case 4: return element4;
			case 5: return element5;
			case 6: return element6;
			case 7: return element7;
			case 8: return element8;
			case 9: return element9;
			case 10: return element10;
			case 11: return element11;
			case 12: return element12;
			case 13: return element13;
			case 14: return element14;
			case 15: return element15;
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> set(final int index, final T value)
	{
		switch(index)
		{
			case 0: return new VectorOf16<>(value, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14, element15);
			case 1: return new VectorOf16<>(element0, value, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14, element15);
			case 2: return new VectorOf16<>(element0, element1, value, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14, element15);
			case 3: return new VectorOf16<>(element0, element1, element2, value, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14, element15);
			case 4: return new VectorOf16<>(element0, element1, element2, element3, value, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14, element15);
			case 5: return new VectorOf16<>(element0, element1, element2, element3, element4, value, element6, element7, element8, element9, element10, element11, element12, element13, element14, element15);
			case 6: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, value, element7, element8, element9, element10, element11, element12, element13, element14, element15);
			case 7: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, value, element8, element9, element10, element11, element12, element13, element14, element15);
			case 8: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, value, element9, element10, element11, element12, element13, element14, element15);
			case 9: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, value, element10, element11, element12, element13, element14, element15);
			case 10: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, value, element11, element12, element13, element14, element15);
			case 11: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, value, element12, element13, element14, element15);
			case 12: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, value, element13, element14, element15);
			case 13: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, value, element14, element15);
			case 14: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, value, element15);
			case 15: return new VectorOf16<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14, value);
			case 16: return push(value);
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> push(final T value)
	{
		return new VectorTrie<>(1, this, new VectorOf1<>(value));
	}

	public Vector<T> push(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		return new VectorTrie<T>(1, new VectorOf16(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14, element15), new VectorOf16(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));
	}

	public Vector<T> pushAll(@NotNull final Iterable<T> iterable)
	{
		return Vectors.pushAll(this, iterable);
	}

	public <R> Vector<R> map(@NotNull final Function<? super T, ? extends R> mapper)
	{
		return new VectorOf16<>(mapper.apply(element0), mapper.apply(element1), mapper.apply(element2), mapper.apply(element3), mapper.apply(element4), mapper.apply(element5), mapper.apply(element6), mapper.apply(element7), mapper.apply(element8), mapper.apply(element9), mapper.apply(element10), mapper.apply(element11), mapper.apply(element12), mapper.apply(element13), mapper.apply(element14), mapper.apply(element15));
	}

	public <R> Vector<R> flatmap(@NotNull final Function<T, Vector<R>> mapper)
	{
		return Vectors.flatmap(this, mapper);
	}

	public String toString()
	{
		return Vectors.toString(this);
	}

	public Iterator<T> iterator() { return new VectorIterator<T>(this); }
}

