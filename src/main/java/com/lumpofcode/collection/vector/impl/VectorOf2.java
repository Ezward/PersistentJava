package com.lumpofcode.collection.vector.impl;

import com.lumpofcode.collection.vector.Vector;
import com.lumpofcode.collection.vector.Vectors;
import com.lumpofcode.collection.vector.VectorIterator;

import java.util.Iterator;
import java.util.function.Function;


/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/

public final class VectorOf2<T> implements Vector<T>, Iterable<T>
{
	private final T element0;
	private final T element1;

	public VectorOf2(T element0, T element1)
	{
		this.element0 = element0;
		this.element1 = element1;
	}

	public boolean isEmpty() { return false; }

	public int size() { return 2; }

	public T get(int index)
	{
		switch(index)
		{
			case 0: return element0;
			case 1: return element1;
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> set(int index, T value)
	{
		switch(index)
		{
			case 0: return new VectorOf2<>(value, element1);
			case 1: return new VectorOf2<>(element0, value);
			case 2: return push(value);
		}

		throw new IndexOutOfBoundsException();
	}

	public Vector<T> push(T value)
	{
		return new VectorOf3<>(element0, element1, value);
	}

	public Vector<T> push(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		return new VectorTrie<T>(1, new VectorOf16(element0, element1, e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13), new VectorOf2(e14, e15));
	}

	public Vector<T> pushAll(final Iterable<T> iterable)
	{
		return Vectors.pushAll(this, iterable);
	}

	public <R> Vector<R> map(Function<? super T, ? extends R> mapper)
	{
		return new VectorOf2<>(mapper.apply(element0), mapper.apply(element1));
	}

	public <R> Vector<R> flatmap(Function<T, Vector<R>> mapper)
	{
		return Vectors.flatmap(this, mapper);
	}

	public String toString()
	{
		return Vectors.toString(this);
	}

	public Iterator<T> iterator() { return new VectorIterator<T>(this); }
}

