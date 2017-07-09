package com.lumpofcode.collection.vector;

import com.lumpofcode.collection.vector.impl.*;

import com.lumpofcode.annotation.NotNull;

import java.util.function.Function;


/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/

public interface Vector<T> extends Iterable<T>
{
	public static final int VECTOR_NODE_SIZE = 16;

	/**
	 * An empty vector as a singleton.
	 */
	public static final EmptyVector empty = new EmptyVector();

	/**
	 * Factory to construct a Vector with 1 elements
	 *
	 * @param e0 the element an index 0
	 * @param <T> the type of the element
	 * @return a Vector of type T with 1 elements
	 */
	public static <T> Vector<T> of(final T e0)
	{
		return new VectorOf1<>(e0);
	}

	/**
	 * Factory to construct a Vector with 2 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param <T> the type of the element
	 * @return a Vector of type T with 2 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1)
	{
		return new VectorOf2<>(e0, e1);
	}

	/**
	 * Factory to construct a Vector with 3 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param <T> the type of the element
	 * @return a Vector of type T with 3 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2)
	{
		return new VectorOf3<>(e0, e1, e2);
	}

	/**
	 * Factory to construct a Vector with 4 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param <T> the type of the element
	 * @return a Vector of type T with 4 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3)
	{
		return new VectorOf4<>(e0, e1, e2, e3);
	}

	/**
	 * Factory to construct a Vector with 5 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param <T> the type of the element
	 * @return a Vector of type T with 5 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4)
	{
		return new VectorOf5<>(e0, e1, e2, e3, e4);
	}

	/**
	 * Factory to construct a Vector with 6 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param <T> the type of the element
	 * @return a Vector of type T with 6 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5)
	{
		return new VectorOf6<>(e0, e1, e2, e3, e4, e5);
	}

	/**
	 * Factory to construct a Vector with 7 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param <T> the type of the element
	 * @return a Vector of type T with 7 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6)
	{
		return new VectorOf7<>(e0, e1, e2, e3, e4, e5, e6);
	}

	/**
	 * Factory to construct a Vector with 8 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param <T> the type of the element
	 * @return a Vector of type T with 8 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7)
	{
		return new VectorOf8<>(e0, e1, e2, e3, e4, e5, e6, e7);
	}

	/**
	 * Factory to construct a Vector with 9 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param <T> the type of the element
	 * @return a Vector of type T with 9 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8)
	{
		return new VectorOf9<>(e0, e1, e2, e3, e4, e5, e6, e7, e8);
	}

	/**
	 * Factory to construct a Vector with 10 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param e9 the element an index 9
	 * @param <T> the type of the element
	 * @return a Vector of type T with 10 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9)
	{
		return new VectorOf10<>(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9);
	}

	/**
	 * Factory to construct a Vector with 11 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param e9 the element an index 9
	 * @param e10 the element an index 10
	 * @param <T> the type of the element
	 * @return a Vector of type T with 11 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10)
	{
		return new VectorOf11<>(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
	}

	/**
	 * Factory to construct a Vector with 12 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param e9 the element an index 9
	 * @param e10 the element an index 10
	 * @param e11 the element an index 11
	 * @param <T> the type of the element
	 * @return a Vector of type T with 12 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11)
	{
		return new VectorOf12<>(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
	}

	/**
	 * Factory to construct a Vector with 13 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param e9 the element an index 9
	 * @param e10 the element an index 10
	 * @param e11 the element an index 11
	 * @param e12 the element an index 12
	 * @param <T> the type of the element
	 * @return a Vector of type T with 13 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12)
	{
		return new VectorOf13<>(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
	}

	/**
	 * Factory to construct a Vector with 14 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param e9 the element an index 9
	 * @param e10 the element an index 10
	 * @param e11 the element an index 11
	 * @param e12 the element an index 12
	 * @param e13 the element an index 13
	 * @param <T> the type of the element
	 * @return a Vector of type T with 14 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13)
	{
		return new VectorOf14<>(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);
	}

	/**
	 * Factory to construct a Vector with 15 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param e9 the element an index 9
	 * @param e10 the element an index 10
	 * @param e11 the element an index 11
	 * @param e12 the element an index 12
	 * @param e13 the element an index 13
	 * @param e14 the element an index 14
	 * @param <T> the type of the element
	 * @return a Vector of type T with 15 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14)
	{
		return new VectorOf15<>(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14);
	}

	/**
	 * Factory to construct a Vector with 16 elements
	 *
	 * @param e0 the element an index 0
	 * @param e1 the element an index 1
	 * @param e2 the element an index 2
	 * @param e3 the element an index 3
	 * @param e4 the element an index 4
	 * @param e5 the element an index 5
	 * @param e6 the element an index 6
	 * @param e7 the element an index 7
	 * @param e8 the element an index 8
	 * @param e9 the element an index 9
	 * @param e10 the element an index 10
	 * @param e11 the element an index 11
	 * @param e12 the element an index 12
	 * @param e13 the element an index 13
	 * @param e14 the element an index 14
	 * @param e15 the element an index 15
	 * @param <T> the type of the element
	 * @return a Vector of type T with 16 elements
	 */
	public static <T> Vector<T> of(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
	{
		return new VectorOf16<>(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
	}

	/**
	 * Construct a vector from an Iterable
	 *
	 * @param values an Iterable that provides ordered values
	 * @param <T>
	 * @return A vector of the elements of the Iterable
	 */
	public static <T> Vector<T> asVector(Iterable<T> values)
	{
		return Vector.empty.pushAll(values);
	}

	/**
	 * The number of elements in the Vector.
	 * This is calculated efficiently.
	 *
	 * @return The number of elements in the Vector
	 */
	int size();

	/**
	 * Determine if the Vector is empty.
	 *
	 * @return true if the vector is empty, false if not.
	 */
	boolean isEmpty();

	/**
	 * Get the element at the given index
	 *
	 * @param index zero based index of element 0..size-1
	 * @return the element
	 * @throws IndexOutOfBoundsException if index lt 0 or index gte size
	 */
	T get(final int index);

	/**
	 * Set the value at the given index.
	 * Setting the value at index == size will
	 * increase the size of the Vector by one
	 * (it is equivalent to a push()).
	 *
	 * @param index zero based index 0..size
	 * @param value the value to set
	 * @return a new Vector with the element set
	 * @throws IndexOutOfBoundsException if index lt 0 or index gt size
	 */
	Vector<T> set(final int index, final T value);

	/**
	 * Append a value to the end of the Vector.
	 *
	 * @param value the value to append
	 * @return a new Vector with the value appended
	 */
	Vector<T> push(final T value);

	/**
	 * Efficiently append elements to the end of the Vector.
	 * When building a large vector, this is the most
	 * efficient way to build up the vector, provided that
	 * elements are always added in chunks of Vector.VECTOR_NODE_SIZE.
	 *
	 * @param e0 element to push
	 * @param e1 element to push
	 * @param e2 element to push
	 * @param e3 element to push
	 * @param e4 element to push
	 * @param e5 element to push
	 * @param e6 element to push
	 * @param e7 element to push
	 * @param e8 element to push
	 * @param e9 element to push
	 * @param e10 element to push
	 * @param e11 element to push
	 * @param e12 element to push
	 * @param e13 element to push
	 * @param e14 element to push
	 * @param e15 element to push
	 * @return a new Vector with 16 addition elements
	 */
	public Vector<T> push(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15);

	/**
	 * Append all elements in the given vector
	 * to this vector, in order.
	 *
	 * @param iterable with elements to append
	 * @return a new vector with the Iterable's elements appended.
	*/
	Vector<T> pushAll(@NotNull final Iterable<T> iterable);

	/**
	 * Map the values in the vector using the mapper function
	 * and return a new vector of mapped elements.
	 *
	 * @param <R> the resulting element type
	 * @param mapper function that maps a T to an R
	 * @return Vector of elements of type R
	 */
	<R> Vector<R> map(@NotNull Function<? super T, ? extends R> mapper);

	/**
	 * Map each element of type T of this vector to
	 * a Vector of type R, to produce a vector of vectors of type R,
	 * then flatten (append) that into a vector of type R.
	 *
	 * @param <R> the resulting element type
	 * @param mapper function that maps a value of type T
	 *               to a Vector with elements of type R
	 * @return Vector of elements of type R
	 */
	<R> Vector<R> flatmap(@NotNull Function<T, Vector<R>> mapper);
}

