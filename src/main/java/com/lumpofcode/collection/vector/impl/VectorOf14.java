package com.lumpofcode.collection.vector.impl;

import com.lumpofcode.collection.vector.Vector;
import com.lumpofcode.collection.vector.Vectors;
import com.lumpofcode.collection.vector.VectorIterator;

import java.util.Iterator;
import java.util.function.Function;


/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/

public final class VectorOf14<T> implements Vector<T>, Iterable<T>
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

	public VectorOf14(T element0, T element1, T element2, T element3, T element4, T element5, T element6, T element7, T element8, T element9, T element10, T element11, T element12, T element13)
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
	}

	public boolean isEmpty() { return false; }

	public int size() { return 14; }

	public T get(int index)
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
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf14<>(value, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13);
			case 1: return new VectorOf14<>(element0, value, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13);
			case 2: return new VectorOf14<>(element0, element1, value, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13);
			case 3: return new VectorOf14<>(element0, element1, element2, value, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13);
			case 4: return new VectorOf14<>(element0, element1, element2, element3, value, element5, element6, element7, element8, element9, element10, element11, element12, element13);
			case 5: return new VectorOf14<>(element0, element1, element2, element3, element4, value, element6, element7, element8, element9, element10, element11, element12, element13);
			case 6: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, value, element7, element8, element9, element10, element11, element12, element13);
			case 7: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, element6, value, element8, element9, element10, element11, element12, element13);
			case 8: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, element6, element7, value, element9, element10, element11, element12, element13);
			case 9: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, value, element10, element11, element12, element13);
			case 10: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, value, element11, element12, element13);
			case 11: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, value, element12, element13);
			case 12: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, value, element13);
			case 13: return new VectorOf14<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, value);
			case 14: return push(value);
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> push(T value)
	{
		return new VectorOf15<>(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, value);
	}

	public Vector<T> push(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15)
	{
		return new VectorTrie<T>(1, new VectorOf16(element0, element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, e0, e1), new VectorOf14(e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));
	}

	public Vector<T> pushAll(final Iterable<T> iterable)
	{
		return Vectors.pushAll(this, iterable);
	}

	public <R> Vector<R> map(Function<? super T, ? extends R> mapper)
	{
		return new VectorOf14<>(mapper.apply(element0), mapper.apply(element1), mapper.apply(element2), mapper.apply(element3), mapper.apply(element4), mapper.apply(element5), mapper.apply(element6), mapper.apply(element7), mapper.apply(element8), mapper.apply(element9), mapper.apply(element10), mapper.apply(element11), mapper.apply(element12), mapper.apply(element13));
	}

	public <R> Vector<R> flatmap(Function<T, Vector<R>> mapper)
	{
		return Vectors.flatmap(this, mapper);
	}

	public String toString()
	{
		return "[" + element0.toString() + ", " + element1.toString() + ", " + element2.toString() + ", " + element3.toString() + ", " + element4.toString() + ", " + element5.toString() + ", " + element6.toString() + ", " + element7.toString() + ", " + element8.toString() + ", " + element9.toString() + ", " + element10.toString() + ", " + element11.toString() + ", " + element12.toString() + ", " + element13.toString() + "]";

	}

	public Iterator<T> iterator() { return new VectorIterator<T>(this); }
}

