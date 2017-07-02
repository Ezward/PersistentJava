package com.lumpofcode.collection.vector;

import com.lumpofcode.math.IntegerMath;
import java.util.Iterator;
import java.util.function.Function;

public final class VectorTrie<T> implements Vector<T>
{
	private static final int VECTOR_NODE_SIZE = 16;
	
	private final int level;        // zero if leaf node, 1 is first level trie, 2 is second level trie, etc.
	private final int childSize;    // capacity (maximum size) of a child node at this level
	private final int size;
	private final Vector<T> vector0;
	private final Vector<T> vector1;
	private final Vector<T> vector2;
	private final Vector<T> vector3;
	private final Vector<T> vector4;
	private final Vector<T> vector5;
	private final Vector<T> vector6;
	private final Vector<T> vector7;
	private final Vector<T> vector8;
	private final Vector<T> vector9;
	private final Vector<T> vector10;
	private final Vector<T> vector11;
	private final Vector<T> vector12;
	private final Vector<T> vector13;
	private final Vector<T> vector14;
	private final Vector<T> vector15;
	
	public VectorTrie(final int level, final Vector<T> vector0, final Vector<T> vector1)
	{
		this(level, vector0, vector1, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty, Vectors.empty);
	}
	
	public VectorTrie(final int level, final Vector<T> vector0, final Vector<T> vector1, final Vector<T> vector2, final Vector<T> vector3, final Vector<T> vector4, final Vector<T> vector5, final Vector<T> vector6, final Vector<T> vector7, final Vector<T> vector8, final Vector<T> vector9, final Vector<T> vector10, final Vector<T> vector11, final Vector<T> vector12, final Vector<T> vector13, final Vector<T> vector14, final Vector<T> vector15)
	{
		this.level = level;
		this.childSize = IntegerMath.power(VECTOR_NODE_SIZE, level);
		this.vector0 = vector0;
		this.vector1 = vector1;
		this.vector2 = vector2;
		this.vector3 = vector3;
		this.vector4 = vector4;
		this.vector5 = vector5;
		this.vector6 = vector6;
		this.vector7 = vector7;
		this.vector8 = vector8;
		this.vector9 = vector9;
		this.vector10 = vector10;
		this.vector11 = vector11;
		this.vector12 = vector12;
		this.vector13 = vector13;
		this.vector14 = vector14;
		this.vector15 = vector15;
		
		this.size =  vector0.size() + vector1.size() + vector2.size() + vector3.size() + vector4.size() + vector5.size() + vector6.size() + vector7.size() + vector8.size() + vector9.size() + vector10.size() + vector11.size() + vector12.size() + vector13.size() + vector14.size() + vector15.size();
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return false;
	}
	
	public T get(final int index)
	{
		if((index < 0) || (index >= size())) throw new IndexOutOfBoundsException();
		
		//
		// find the child within this trie (index / childSize)
		// then get that child's element (index % childSize)
		//
		return getChild(index / childSize).get(index % childSize);
	}
	
	public Vector<T> set(final int index, final T value)
	{
		if((index < 0) || (index > size())) throw new IndexOutOfBoundsException();
		
		//
		// find the child within this trie (index / childSize)
		// if it is within this trie, set it's element (index % childIndex)
		// if it is not within this trie, then we need to add another level to the hierarchy
		//
		final int childIndex = index / childSize;
		if(childIndex < VECTOR_NODE_SIZE)
		{
			//
			// find the child within this trie (index / childSize)
			// then set that child's element (index % childSize)
			// and build a new vector using the updated child
			//
			return setChild(childIndex, getChild(childIndex).set(index % childSize, value));
		}
		
		//
		// we are beyond the capacity of this trie, so create a new level in the hierarachy
		//
		return new VectorTrie(level + 1,this, Vectors.asVector(value));
	}
	
	public Vector<T> push(final T value)
	{
		// add element after last current element
		return this.set(this.size(), value);
	}
	
	public Vector<T> push(final T e0, final T e1, final T e2, final T e3, final T e4, final T e5, final T e6, final T e7, final T e8, final T e9, final T e10, final T e11, final T e12, final T e13, final T e14, final T e15)	{
		final int childIndex = size / childSize; // index of vector containing last element
		final int childCount = size % childSize;  // size of vector containing last element
		final int childCapacity = childSize - childCount;   // remaining capacity of vector containing last element
		
		//
		// determine if we can just add this to the child, or if we need to split it between children
		//
		if(childCapacity >= 16)
		{
			if(childIndex < VECTOR_NODE_SIZE)
			{
				//
				// there is room for these elements in the child,
				// push to the child, then rebuild the trie with the updated child
				//
				return setChild(childIndex, getChild(childIndex).push(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));
			}
			
			//
			// no room in this level of the hierarchy, so create another level
			//
			return new VectorTrie<T>(this.level + 1, this, Vectors.asVector(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));
		}
		
		else
		{
			//
			// there is not enough room in the child for 16 elements, which means these
			// new elements will need to be split between children.
			// Use a loop to push each element.  It is inefficient, but handles situation
			// where a new child or new level in the hierarchy is required
			//
			return this.push(e0).push(e1).push(e2).push(e3).push(e4).push(e5).push(e6).push(e7).push(e8).push(e9).push(e10).push(e11).push(e12).push(e13).push(e14).push(e15);
		}
		
	}
	
	public Vector<T> pushAll(final Iterable<T> iterable)
	{
		return Vectors.pushAll(this, iterable);
	}
	
	public <R> Vector<R> map(final Function<? super T, ? extends R> mapper)
	{
		return new VectorTrie<R>(level, vector0.map(mapper), vector1.map(mapper), vector2.map(mapper), vector3.map(mapper), vector4.map(mapper), vector5.map(mapper), vector6.map(mapper), vector7.map(mapper), vector8.map(mapper), vector9.map(mapper), vector10.map(mapper), vector11.map(mapper), vector12.map(mapper), vector13.map(mapper), vector14.map(mapper), vector15.map(mapper));
	}
	
	public <R> Vector<R> flatmap(final Function<T, Vector<R>> mapper)
	{
		Vector<R> result = Vectors.empty;
		result = result.pushAll(vector0.flatmap(mapper));
		result = result.pushAll(vector1.flatmap(mapper));
		result = result.pushAll(vector2.flatmap(mapper));
		result = result.pushAll(vector3.flatmap(mapper));
		result = result.pushAll(vector4.flatmap(mapper));
		result = result.pushAll(vector5.flatmap(mapper));
		result = result.pushAll(vector6.flatmap(mapper));
		result = result.pushAll(vector7.flatmap(mapper));
		result = result.pushAll(vector8.flatmap(mapper));
		result = result.pushAll(vector9.flatmap(mapper));
		result = result.pushAll(vector10.flatmap(mapper));
		result = result.pushAll(vector11.flatmap(mapper));
		result = result.pushAll(vector12.flatmap(mapper));
		result = result.pushAll(vector13.flatmap(mapper));
		result = result.pushAll(vector14.flatmap(mapper));
		result = result.pushAll(vector15.flatmap(mapper));
		return result;
	}
	
	public String toString()
	{
		return Vectors.toString(this);
	}
	
	public Iterator<T> iterator()
	{
		return new VectorIterator<T>(this);
	}
	
	//
	// ---------------------- private helpers --------------------------
	//
	/**
	 * get child vector at given child index
	 *
	 * @param childIndex index of child vector 0..VECTOR_NODE_SIZE-1
	 * @return child vector given child index
	 */
	private Vector<T> getChild(final int childIndex)
	{
		if((childIndex < 0) || (childIndex >= VECTOR_NODE_SIZE)) throw new IndexOutOfBoundsException();
		switch(childIndex)
		{
			case 0: return vector0;
			case 1: return vector1;
			case 2: return vector2;
			case 3: return vector3;
			case 4: return vector4;
			case 5: return vector5;
			case 6: return vector6;
			case 7: return vector7;
			case 8: return vector8;
			case 9: return vector9;
			case 10: return vector10;
			case 11: return vector11;
			case 12: return vector12;
			case 13: return vector13;
			case 14: return vector14;
			default: return vector15;
		}
		
	}
	
	/**
	 * set child element at given index to the given vector
	 *
	 * @param childIndex index of child vector 0..VECTOR_NODE_SIZE-1
	 * @param childValue child vector
	 * @return new vector with given child at given index
	 */
	private Vector<T> setChild(final int childIndex, Vector<T> childValue)
	{
		if((childIndex < 0) || (childIndex >= VECTOR_NODE_SIZE)) throw new IndexOutOfBoundsException();
		switch(childIndex)
		{
			case 0: return new VectorTrie(level, childValue, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 1: return new VectorTrie(level, vector0, childValue, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 2: return new VectorTrie(level, vector0, vector1, childValue, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 3: return new VectorTrie(level, vector0, vector1, vector2, childValue, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 4: return new VectorTrie(level, vector0, vector1, vector2, vector3, childValue, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 5: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, childValue, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 6: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, childValue, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 7: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, childValue, vector8, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 8: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, childValue, vector9, vector10, vector11, vector12, vector13, vector14, vector15);
			case 9: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, childValue, vector10, vector11, vector12, vector13, vector14, vector15);
			case 10: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, childValue, vector11, vector12, vector13, vector14, vector15);
			case 11: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, childValue, vector12, vector13, vector14, vector15);
			case 12: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, childValue, vector13, vector14, vector15);
			case 13: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, childValue, vector14, vector15);
			case 14: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, childValue, vector15);
			default: return new VectorTrie(level, vector0, vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8, vector9, vector10, vector11, vector12, vector13, vector14, childValue);
		}
		
	}
	
}
