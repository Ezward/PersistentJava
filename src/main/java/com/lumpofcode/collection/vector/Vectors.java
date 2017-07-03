package com.lumpofcode.collection.vector;

import com.lumpofcode.collection.vector.impl.*;

import com.lumpofcode.annotation.NotNull;

import java.util.Iterator;
import java.util.function.Function;

/**
* Methods that create or act on Vectors.
*
* Use the Vectors.asVector() functions to construct Vectors.
*
* Created by emurphy on 6/16/17.
*/
public final class Vectors
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
	public static final <T> Vector<T> asVector(final T e0)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14)
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
	public static final <T> Vector<T> asVector(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)
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
	public static final <T> Vector<T> asVector(Iterable<T> values)
	{
		return Vectors.empty.pushAll(values);
	}

	/**
	 * Push all elements in the Iterable into the end of the Vector
	 *
	 * @param vector
	 * @param iterable
	 * @param <T>
	 * @return a new Vector with the Iterable's elements appended.
	 */
	public static final <T> Vector<T> pushAll(final Vector vector, final Iterable<T> iterable)
	{
		//
		// do in chunks of node size for efficiency
		//
		Vector<T> result = vector;
		final Iterator<T> it = iterable.iterator();

		//
		// get to a node-size-aligned result, so we can start using push-16 for efficiency
		//
		while(((result.size() % VECTOR_NODE_SIZE) != 0) && it.hasNext())
		{
			result = result.push(it.next());
		}

		//
		// While we have 16 elements available, collect them and use the more efficient 16 push,
		// otherwise push each element individually
		//
		while(it.hasNext())
		{
			final T e0 = it.next();
			if (it.hasNext())
			{
				final T e1 = it.next();
				if (it.hasNext())
				{
					final T e2 = it.next();
					if (it.hasNext())
					{
						final T e3 = it.next();
						if (it.hasNext())
						{
							final T e4 = it.next();
							if (it.hasNext())
							{
								final T e5 = it.next();
								if (it.hasNext())
								{
									final T e6 = it.next();
									if (it.hasNext())
									{
										final T e7 = it.next();
										if (it.hasNext())
										{
											final T e8 = it.next();
											if (it.hasNext())
											{
												final T e9 = it.next();
												if (it.hasNext())
												{
													final T e10 = it.next();
													if (it.hasNext())
													{
														final T e11 = it.next();
														if (it.hasNext())
														{
															final T e12 = it.next();
															if (it.hasNext())
															{
																final T e13 = it.next();
																if (it.hasNext())
																{
																	final T e14 = it.next();
																	if (it.hasNext())
																	{
																		//
																		// we have enough for a node size push
																		//
																		final T e15 = it.next();
																		result = result.push(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
																	}
																	else
																	{
																		//
																		// else we don't have enough for a push of node size, so do a series of push of 1
																		//
																		result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12).push(e13).push(e14);
																	}
																}
																else
																{
																	//
																	// else we don't have enough for a push of node size, so do a series of push of 1
																	//
																	result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12).push(e13);
																}
															}
															else
															{
																//
																// else we don't have enough for a push of node size, so do a series of push of 1
																//
																result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12);
															}
														}
														else
														{
															//
															// else we don't have enough for a push of node size, so do a series of push of 1
															//
															result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11);
														}
													}
													else
													{
														//
														// else we don't have enough for a push of node size, so do a series of push of 1
														//
														result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10);
													}
												}
												else
												{
													//
													// else we don't have enough for a push of node size, so do a series of push of 1
													//
													result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9);
												}
											}
											else
											{
												//
												// else we don't have enough for a push of node size, so do a series of push of 1
												//
												result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8);
											}
										}
										else
										{
											//
											// else we don't have enough for a push of node size, so do a series of push of 1
											//
											result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7);
										}
									}
									else
									{
										//
										// else we don't have enough for a push of node size, so do a series of push of 1
										//
										result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6);
									}
								}
								else
								{
									//
									// else we don't have enough for a push of node size, so do a series of push of 1
									//
									result = result.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5);
								}
							}
							else
							{
								//
								// else we don't have enough for a push of node size, so do a series of push of 1
								//
								result = result.push(e0).push(e1).push(e2).push(e3).push(e4);
							}
						}
						else
						{
							//
							// else we don't have enough for a push of node size, so do a series of push of 1
							//
							result = result.push(e0).push(e1).push(e2).push(e3);
						}
					}
					else
					{
						//
						// else we don't have enough for a push of node size, so do a series of push of 1
						//
						result = result.push(e0).push(e1).push(e2);
					}
				}
				else
				{
					//
					// else we don't have enough for a push of node size, so do a series of push of 1
					//
					result = result.push(e0).push(e1);
				}
			}
			else
			{
				//
				// else we don't have enough for a push of node size, so do a series of push of 1
				//
				result = result.push(e0);
			}
		}

		return result;
	}

	/**
	 * Map the values in the vector using the mapper function
	 * and return a new vector of mapped elements.
	 *
	 * @param vector the vector to operate on
	 * @param <R> the resulting element type
	 * @param mapper function that maps a T to an R
	 * @return Vector of elements of type R
	 */
	public static <T, R> Vector<R> map(final @NotNull Vector<T> vector, final @NotNull Function<? super T, ? extends R> mapper)
	{
		//
		// do in chunks of node size for efficiency
		//
		Vector<R> result = Vectors.empty;
		int index = 0;
		while(index <= (vector.size() - VECTOR_NODE_SIZE))
		{
			result = result.push(
				mapper.apply(vector.get(index + 0)), 	mapper.apply(vector.get(index + 1)), 	mapper.apply(vector.get(index + 2)), 	mapper.apply(vector.get(index + 3)), 
				mapper.apply(vector.get(index + 4)), 	mapper.apply(vector.get(index + 5)), 	mapper.apply(vector.get(index + 6)), 	mapper.apply(vector.get(index + 7)), 
				mapper.apply(vector.get(index + 8)), 	mapper.apply(vector.get(index + 9)), 	mapper.apply(vector.get(index + 10)), 	mapper.apply(vector.get(index + 11)), 
				mapper.apply(vector.get(index + 12)), 	mapper.apply(vector.get(index + 13)), 	mapper.apply(vector.get(index + 14)), 	mapper.apply(vector.get(index + 15)));
			index += VECTOR_NODE_SIZE;
		}

		//
		// handle the rest with simple push
		//
		while(index < vector.size())
		{
			result = result.push(mapper.apply(vector.get(index)));
			index += 1;
		}

		return result;
	}

	/**
	 * Map each element of type T of the vector to
	 * a Vector of type R, to produce a vector of vectors of type R,
	 * then flatten (append) that into a vector of type R.
	 *
	 * @param vector the vector to operate on
	 * @param <R> the resulting element type
	 * @param mapper function that maps a value of type T
	 *               to a Vector with elements of type R
	 * @return Vector of elements of type R
	 */
	public static <T, R> Vector<R> flatmap(final @NotNull Vector<T> vector, final @NotNull Function<T, Vector<R>> mapper)
	{
		Vector<R> result = Vectors.empty;
		for(T element : vector)
		{
			result = result.pushAll(mapper.apply(element));
		}

		return result;
	}

	/**
	 * Format vectors as '[e0, e1, e2...]'
	 *
	 * @param vector
	 * @param <T>
	 * @return
	 */
	public static <T> String toString(final @NotNull Vector<T> vector)
	{
		final StringBuilder builder = new StringBuilder();
		builder.append('[');
		if(!vector.isEmpty())
		{
			builder.append(vector.get(0));
			for(int i = 1; i < vector.size(); i += 1)
			{
				builder.append(", ").append(vector.get(i));
			}
		}
		builder.append(']');
		return builder.toString();
	}

}

