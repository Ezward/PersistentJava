
package com.lumpofcode.collection.vector;

import com.lumpofcode.generator.Macros;
import com.lumpofcode.generator.SourceBuilder;

import java.io.Writer;

/**
 * Class to generate java source file for a Vector class of a given size.
 */
public final class VectorTemplate
{
	/**
	 * Generate java source for Vector.java interface of given radix (node size)
	 *
	 * @param writer
	 * @param nodeSize
	 */
	public void generateVectorInterface(final Writer writer, final int nodeSize)
	{
		if(nodeSize < 2) throw new IllegalArgumentException();
		
		final SourceBuilder b = new SourceBuilder(writer);
		final Macros m = new Macros();
		
		//
		// set up common symbols
		//
		m.with("nodesize", nodeSize);
		m.with("nodesize-1", nodeSize-1);

		b.line("package com.lumpofcode.collection.vector;").eol();
		b.line("import com.lumpofcode.collection.vector.impl.*;").eol();
		b.line("import com.lumpofcode.annotation.NotNull;").eol();
		b.line("import java.util.function.Function;").eol();
		
		b.eol().line("/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/").eol();

		/**
		 * Public methods for a peristent Vector.
		 * Vectors have o(1) access for reading and writing elements at arbitrary index.
		 *
		 * Created by emurphy on 6/16/17.
		 */
		b.line("public interface Vector<T> extends Iterable<T>");
		b.block();
		{
			b.line(m.apply("public static final int VECTOR_NODE_SIZE = {{nodesize}};")).eol();
			
			//
			// empty vector singleton
			//
			b.line("/**");
			b.line(" * An empty vector as a singleton.");
			b.line(" */");
			b.line("public static final EmptyVector empty = new EmptyVector();").eol();
			
			//
			// loop to create all the Vector.of() factory methods from 1..nodeSize
			//
			for(int i = 1; i <= nodeSize; i += 1)
			{
				m.with("i", i);
				b.line("/**");
				b.line(m.apply(" * Factory to construct a Vector with {{i}} elements"));
				b.line(" *");
				for(int j = 0; j < i; j += 1)
				{
					b.line(m.with("j", j).apply(" * @param e{{j}} the element an index {{j}}"));
				}
				b.line(" * @param <T> the type of the element");
				b.line(m.apply(" * @return a Vector of type T with {{i}} elements"));
				b.line(" */");
				b.indent("public static <T> Vector<T> of").args();
				for (int j = 0; j < i; j += 1)
				{
					b.arg(j, m.with("j", j).apply("final T e{{j}}"));
				}
				b.endArgs().eol();
				
				b.block();
				{
					//
					// using VectorOf## implementation
					//
					m.with("i", i);
					b.indent(m.apply("return new VectorOf{{i}}<>")).args();
					for (int j = 0; j < i; j += 1)
					{
						b.arg(j, m.with("j", j).apply("e{{j}}"));
					}
					b.endArgs().eol(";");
				}
				b.endBlock();
			}
			
			//
			// factory to construct Vector from an Iterable
			//
			b.line("/**");
			b.line(" * Construct a vector from an Iterable");
			b.line(" *");
			b.line(" * @param values an Iterable that provides ordered values");
			b.line(" * @param <T>");
			b.line(" * @return A vector of the elements of the Iterable");
			b.line(" */");
			b.line("public static <T> Vector<T> asVector(Iterable<T> values)");
			b.block();
			{
				b.line("return Vector.empty.pushAll(values);");
			}
			b.endBlock();
			
			
			//
			// size()
			//
			b.line("/**");
			b.line(" * The number of elements in the Vector.");
			b.line(" * This is calculated efficiently.");
			b.line(" *");
			b.line(" * @return The number of elements in the Vector");
			b.line(" */");
			b.line("int size();").eol();
			
			//
			// isEmpty()
			//
			b.line("/**");
			b.line(" * Determine if the Vector is empty.");
			b.line(" *");
			b.line(" * @return true if the vector is empty, false if not.");
			b.line(" */");
			b.line("boolean isEmpty();").eol();
			
			//
			// get()
			//
			b.line("/**");
			b.line(" * Get the element at the given index");
			b.line(" *");
			b.line(" * @param index zero based index of element 0..size-1");
			b.line(" * @return the element");
			b.line(" * @throws IndexOutOfBoundsException if index lt 0 or index gte size");
			b.line(" */");
			b.line("T get(final int index);").eol();
			
			//
			// set()
			//
			b.line("/**");
			b.line(" * Set the value at the given index.");
			b.line(" * Setting the value at index == size will");
			b.line(" * increase the size of the Vector by one");
			b.line(" * (it is equivalent to a push()).");
			b.line(" *");
			b.line(" * @param index zero based index 0..size");
			b.line(" * @param value the value to set");
			b.line(" * @return a new Vector with the element set");
			b.line(" * @throws IndexOutOfBoundsException if index lt 0 or index gt size");
			b.line(" */");
			b.line("Vector<T> set(final int index, final T value);").eol();
			
			//
			// push()
			//
			b.line("/**");
			b.line(" * Append a value to the end of the Vector.");
			b.line(" *");
			b.line(" * @param value the value to append");
			b.line(" * @return a new Vector with the value appended");
			b.line(" */");
			b.line("Vector<T> push(final T value);").eol();
			
			//
			// push(e0, e1, ...)
			//
			b.line("/**");
			b.line(" * Efficiently append elements to the end of the Vector.");
			b.line(" * When building a large vector, this is the most");
			b.line(" * efficient way to build up the vector, provided that");
			b.line(" * elements are always added in chunks of Vector.VECTOR_NODE_SIZE.");
			b.line(" *");
			for(int i = 0; i < nodeSize; i += 1)
			{
				b.line(m.with("i", i).apply(" * @param e{{i}} element to push"));
			}
			b.line(m.apply(" * @return a new Vector with {{nodesize}} addition elements"));
			b.line(" */");
			b.indent("public Vector<T> push").args();
			for(int i = 0; i < nodeSize; i += 1)
			{
				b.arg(i, m.with("i", i).apply("final T e{{i}}"));
			}
			b.endArgs().eol(";").eol();
			
			//
			// pushAll()
			//
			b.line("/**");
			b.line(" * Append all elements in the given vector");
			b.line(" * to this vector, in order.");
			b.line(" *");
			b.line(" * @param iterable with elements to append");
			b.line(" * @return a new vector with the Iterable's elements appended.");
			b.line("*/");
			b.line("Vector<T> pushAll(@NotNull final Iterable<T> iterable);").eol();
			
			//
			// map()
			//
			b.line("/**");
			b.line(" * Map the values in the vector using the mapper function");
			b.line(" * and return a new vector of mapped elements.");
			b.line(" *");
			b.line(" * @param <R> the resulting element type");
			b.line(" * @param mapper function that maps a T to an R");
			b.line(" * @return Vector of elements of type R");
			b.line(" */");
			b.line("<R> Vector<R> map(@NotNull Function<? super T, ? extends R> mapper);").eol();
			
			//
			// flatmap()
			//
			b.line("/**");
			b.line(" * Map each element of type T of this vector to");
			b.line(" * a Vector of type R, to produce a vector of vectors of type R,");
			b.line(" * then flatten (append) that into a vector of type R.");
			b.line(" *");
			b.line(" * @param <R> the resulting element type");
			b.line(" * @param mapper function that maps a value of type T");
			b.line(" *               to a Vector with elements of type R");
			b.line(" * @return Vector of elements of type R");
			b.line(" */");
			b.line("<R> Vector<R> flatmap(@NotNull Function<T, Vector<R>> mapper);");
		}
		b.endBlock();

	}
	
	/**
	 * Generate java source for EmptyVector.java of given radix (node size)
	 *
	 * @param writer
	 * @param nodeSize
	 */
	public void generateEmptyVector(final Writer writer, final int nodeSize)
	{
		if(nodeSize < 2) throw new IllegalArgumentException();
		
		final SourceBuilder b = new SourceBuilder(writer);
		final Macros m = new Macros();
		
		//
		// set up common symbols
		//
		m.with("nodesize", nodeSize);
		m.with("nodesize-1", nodeSize-1);
		
		b.line("package com.lumpofcode.collection.vector.impl;").eol();
		b.line("import com.lumpofcode.collection.vector.Vector;");
		b.line("import com.lumpofcode.collection.vector.Vectors;");
		b.line("import com.lumpofcode.collection.vector.VectorIterator;").eol();
		b.line("import com.lumpofcode.annotation.NotNull;").eol();
		b.line("import java.util.Iterator;");
		b.line("import java.util.function.Function;").eol();
		
		b.eol().line("/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/").eol();

		//
		// class definition
		//
		b.line("/**");
		b.line(" * An empty vector.");
		b.line(" * This is an internal data structure.");
		b.line(" * Don't construct this directly, use the Vector.empty singleton.");
		b.line(" *");
		b.line(" * Created by emurphy on 6/16/17.");
		b.line(" */");
		b.line("public class EmptyVector<T> implements Vector<T>");
		b.block();
		{
			//
			// size()
			//
			b.line("public int size()");
			b.block();
			{
				b.line("return 0;");
			}
			b.endBlock();
			
			//
			// isEmpty()
			//
			b.line("public boolean isEmpty()");
			b.block();
			{
				b.line("return true;");
			}
			b.endBlock();
			
			//
			// get()
			//
			b.line("public T get(final int index)");
			b.block();
			{
				b.line("throw new IndexOutOfBoundsException();");
			}
			b.endBlock();
			
			//
			// set()
			//
			b.line("public Vector<T> set(final int index, final T value)");
			b.block();
			{
				b.line("if(0 == index) return push(value);");
				b.line("throw new IndexOutOfBoundsException();");
			}
			b.endBlock();
			
			//
			// push()
			//
			b.line("public Vector<T> push(final T value)");
			b.block();
			{
				b.line("return Vector.of(value);");
			}
			b.endBlock();

			//
			// push(e0, e1, ...)
			//
			b.indent("public Vector<T> push").args();
			for(int i = 0; i < nodeSize; i += 1)
			{
				b.arg(i, m.with("i", i).apply("final T e{{i}}"));
			}
			b.endArgs().eol();
			b.block();
			{
				b.indent("return Vector.of").args();
				for(int i = 0; i < nodeSize; i += 1)
				{
					b.arg(i, m.with("i", i).apply("e{{i}}"));
				}
				b.endArgs().eol(";");
			}
			b.endBlock();
			
			//
			// pushAll()
			//
			b.line("public Vector<T> pushAll(@NotNull final Iterable<T> values)");
			b.block();
			{
				b.line("return Vectors.pushAll(this, values);");
			}
			b.endBlock();

			//
			// map()
			//
			b.line("public <R> Vector<R> map(@NotNull final Function<? super T, ? extends R> mapper)");
			b.block();
			{
				b.line("return Vector.empty;");
			}
			b.endBlock();

			//
			// flatmap()
			//
			b.line("public <R> Vector<R> flatmap(@NotNull final Function<T, Vector<R>> mapper)");
			b.block();
			{
				b.line("return Vector.empty;");
			}
			b.endBlock();


			//
			// toString()
			//
			b.line("public String toString()");
			b.block();
			{
				b.line("return \"[]\";");
			}
			b.endBlock();

			//
			// iterator()
			//
			b.line("public Iterator<T> iterator()");
			b.block();
			{
				b.line("return new VectorIterator<T>(this);");
			}
			b.endBlock();
		}
		b.endBlock();
		
	}
		
	/**
	 * Generate java source for a vector class of a given size.
	 * This will write to the given writer.
	 *
	 * To create a string, supply a new StringWriter(),
	 * the when generate finishes, get the string from
	 * the writer.
	 *
	 * @param writer a Writer that gets the vector source.
	 * @param size the size of the vector 1..nodeSize
	 */
	public void generateVectorOfNN(final Writer writer, final int size, final int nodeSize)
	{
		if(nodeSize < 2) throw new IllegalArgumentException();
		if((size < 1) || (size > nodeSize)) throw new IllegalArgumentException();
		
		final SourceBuilder b = new SourceBuilder(writer);
		final Macros m = new Macros();
		
		//
		// set up common symbols
		//
		m.with("size", size);
		m.with("size-1", size - 1);
		m.with("size+1", size + 1);
		m.with("nodesize", nodeSize);
		
		//
		// package and imports
		//
		b.line("package com.lumpofcode.collection.vector.impl;").eol();
		b.line("import com.lumpofcode.collection.vector.Vector;");
		b.line("import com.lumpofcode.collection.vector.Vectors;");
		b.line("import com.lumpofcode.collection.vector.VectorIterator;").eol();
		b.line("import com.lumpofcode.annotation.NotNull;").eol();
		b.line("import java.util.Iterator;");
		b.line("import java.util.function.Function;").eol();
		
		
		b.eol().line("/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/").eol();
		
		//
		// class definition
		//
		b.line(m.apply("public final class VectorOf{{size}}<T> implements Vector<T>, Iterable<T>"));
		b.block();
		{
			//
			// private properties for each element
			//
			for (int i = 0; i < size; i += 1)
			{
				b.line(m.with("i", i).apply("private final T element{{i}};"));
			}
			b.eol();
			
			//
			// constructor
			//
			b.indent(m.apply("public VectorOf{{size}}")).args();
			if (size > 0)
			{
				for (int i = 0; i < size; i += 1)
				{
					b.arg(i, m.with("i", i).apply("final T element{{i}}"));
				}
			}
			b.endArgs();
			b.eol();
			
			// constructor body; assign each argument to corresponding property
			b.block();
			{
				for (int i = 0; i < size; i += 1)
				{
					b.line(m.with("i", i).apply("this.element{{i}} = element{{i}};"));
				}
			}
			b.endBlock();
			
			//
			// isEmpty() method
			//
			b.line("public boolean isEmpty() { return false; }").eol();
			
			//
			// size() method
			//
			b.line(m.apply("public int size() { return {{size}}; }")).eol();
			
			//
			// get() method
			//
			b.block("public T get(final int index)");
			{
				b.block("switch(index)");
				{
					for (int i = 0; i < size; i += 1)
					{
						b.line(m.with("i", i).apply("case {{i}}: return element{{i}};"));
					}
					b.endBlock();
				}
				b.line("throw new IndexOutOfBoundsException();");
			}
			b.endBlock();
			
			//
			// set() method
			//
			b.block("public Vector<T> set(final int index, final T value)");
			{
				b.block("switch(index)");
				{
					for (int i = 0; i < size; i += 1)
					{
						b.indent(m.with("i", i).apply("case {{i}}: return new VectorOf{{size}}<>"));
						b.args();
						if (size > 0)
						{
							// use current values except for the index we are setting
							b.arg(0, (0 == i) ? "value" : "element0");
							for (int j = 1; j < size; j += 1)
							{
								b.arg(j, (i == j) ? "value" : m.with("j", j).apply("element{{j}}"));
							}
						}
						b.endArgs().eol(";");
					}
					b.line(m.apply("case {{size}}: return push(value);"));
				}
				b.endBlock();
				
				b.line("throw new IndexOutOfBoundsException();");
			}
			b.endBlock();
			
			//
			// push() method
			//
			b.block("public Vector<T> push(final T value)");
			{
				if (size < nodeSize)
				{
					b.indent(m.apply("return new VectorOf{{size+1}}<>"));
					b.args();
					for (int i = 0; i < size; i += 1)
					{
						b.arg(i, m.with("i", i).apply("element{{i}}"));
					}
					b.arg(size, "value");
					b.endArgs().eol(";");
				}
				else
				{
					b.line("return new VectorTrie<>(1, this, new VectorOf1<>(value));");
				}
			}
			b.endBlock();
			
			//
			// push(e0..e15) method
			//
			// like for VectorOf5:
			//   return new VectorTrie<T>(
			//       1,
			//       new VectorOf16(element0, element1, element2, element3, element4, e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10),
			//       new VectorOf5(e11, e12, e13, e14, e15));
			//
			//
			//
			b.indent("public Vector<T> push").args();
			for(int i = 0; i < nodeSize; i += 1)
			{
				b.arg(i, m.with("i", i).apply("final T e{{i}}"));
			}
			b.endArgs().eol();
			b.block();
			{
				b.indent().args("return new VectorTrie<T>");
				{
					b.arg(0, "1");
					b.arg(1, m.apply("new VectorOf{{nodesize}}")).args();
					{
						for (int i = 0; i < size; i += 1)
						{
							b.arg(i, m.with("i", i).apply("element{{i}}"));
						}
						for (int i = 0, j = size; i < nodeSize - size; i += 1, j += 1)
						{
							b.arg(j, m.with("i", i).apply("e{{i}}"));
						}
					}
					b.endArgs();
					b.arg(2, m.apply("new VectorOf{{size}}")).args();
					{
						for (int i = nodeSize - size, j = 0; i < nodeSize; i += 1, j += 1)
						{
							b.arg(j, m.with("i", i).apply("e{{i}}"));
						}
					}
					b.endArgs();
				}
				b.endArgs(";").eol();
			}
			b.endBlock();
			
			
			//
			// pushAll() method
			//
			b.line("public Vector<T> pushAll(@NotNull final Iterable<T> iterable)");
			b.block();
			{
				b.line("return Vectors.pushAll(this, iterable);");
			}
			b.endBlock();
			
			//
			// map() method
			//
			b.line("public <R> Vector<R> map(@NotNull final Function<? super T, ? extends R> mapper)");
			b.block();
			{
				b.indent(m.apply("return new VectorOf{{size}}<>"));
				b.args();
				for (int i = 0; i < size; i += 1)
				{
					b.arg(i, m.with("i", i).apply("mapper.apply(element{{i}})"));
				}
				b.endArgs();
				b.eol(";");
			}
			b.endBlock();
			
			//
			// flatmap() method
			//
			b.line("public <R> Vector<R> flatmap(@NotNull final Function<T, Vector<R>> mapper)");
			b.block();
			{
				b.line("return Vectors.flatmap(this, mapper);");
			}
			b.endBlock();
			
			
			//
			// toString() method
			//
			b.line("public String toString()");
			b.block();
			{
				b.line("return Vectors.toString(this);");
			}
			b.endBlock();
			
			
			//
			// iterator() method
			//
			b.line("public Iterator<T> iterator() { return new VectorIterator<T>(this); }");
			
			
			//
			// close class
			//
		}
		b.endBlock();
	}
	
	public void generateVectorTrie(final Writer writer, final int nodeSize)
	{
		if(nodeSize < 2) throw new IllegalArgumentException();
		
		final SourceBuilder b = new SourceBuilder(writer);
		final Macros m = new Macros();
		
		//
		// set up common symbols
		//
		m.with("nodesize", nodeSize);
		m.with("nodesize-1", nodeSize-1);
		
		//
		// package and imports
		//
		b.line("package com.lumpofcode.collection.vector.impl;").eol();
		b.line("import com.lumpofcode.collection.vector.Vector;");
		b.line("import com.lumpofcode.collection.vector.Vectors;");
		b.line("import com.lumpofcode.collection.vector.VectorIterator;").eol();
		b.line("import com.lumpofcode.math.IntegerMath;").eol();
		b.line("import java.util.Iterator;").eol();
		b.line("import java.util.function.Function;").eol();
		
		b.eol().line("/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/").eol();

		//
		// class declaration and private final properties
		//
		b.line("public final class VectorTrie<T> implements Vector<T>");
		b.block();
		{
			b.line("private final int level;        // zero if leaf node, 1 is first level trie, 2 is second level trie, etc.");
			b.line("private final int childSize;    // capacity (maximum size) of a child node at this level");

			b.line("private final int size;");
			for(int i = 0; i < nodeSize; i += 1)
			{
				b.line(m.with("i", i).apply("private final Vector<T> vector{{i}};"));
			}
			b.eol();

			//
			// 2 vector constructor
			//
			b.line("public VectorTrie(final int level, final Vector<T> vector0, final Vector<T> vector1)");
			b.block();
			{
				b.indent().args("this");
				b.arg(0, "level").arg(1, "vector0").arg(2, "vector1");
				for(int i = 2; i < nodeSize; i += 1)
				{
					b.arg(i, "Vector.empty");
				}
				b.endArgs().eol(";");
			}
			b.endBlock();


			//
			// complete constructor
			//
			b.indent().args("public VectorTrie").arg(0, "final int level");
			for(int i = 0; i < nodeSize; i += 1)
			{
				b.arg(i + 1, m.with("i", i).apply("final Vector<T> vector{{i}}"));
			}
			b.endArgs().eol();
			b.block();
			{
				b.line("this.level = level;");
				b.line("this.childSize = IntegerMath.power(Vector.VECTOR_NODE_SIZE, level);");
				
				//
				// initialize vector properties
				//
				for(int i = 0; i < nodeSize; i += 1)
				{
					b.line(m.with("i", i).apply("this.vector{{i}} = vector{{i}};"));
				}
				b.eol();

				//
				// eager size calculation
				//
				b.indent().list().item(0, "this.size =  vector0.size()", "+ ");
				for(int i = 1; i < nodeSize; i += 1)
				{
					b.item(i, m.with("i", i).apply("vector{{i}}.size()"), " + ");
				}
				b.eol(";");
			}
			b.endBlock();

			//
			// size()
			//
			b.line("public int size()");
			b.block();
			{
				b.line("return this.size;");
			}
			b.endBlock();

			//
			// isEmpty()
			//
			b.line("public boolean isEmpty()");
			b.block();
			{
				b.line("return false;");
			}
			b.endBlock();

			//
			// get() method()
			//
			b.line("public T get(final int index)");
			b.block();
			{
				b.line("if((index < 0) || (index >= size())) throw new IndexOutOfBoundsException();");
				b.eol();
				b.line("//");
				b.line("// find the child within this trie (index / childSize)");
				b.line("// then get that child's element (index % childSize)");
				b.line("//");
				b.line("return getChild(index / childSize).get(index % childSize);");
			}
			b.endBlock();

			//
			// set() method
			//
			b.line("public Vector<T> set(final int index, final T value)");
			b.block();
			{
				b.line("if((index < 0) || (index > size())) throw new IndexOutOfBoundsException();");
				b.eol();
				b.line("//");
				b.line("// find the child within this trie (index / childSize)");
				b.line("// if it is within this trie, set it's element (index % childIndex)");
				b.line("// if it is not within this trie, then we need to add another level to the hierarchy");
				b.line("//");
				b.line("final int childIndex = index / childSize;");
				b.line("if(childIndex < Vector.VECTOR_NODE_SIZE)");
				b.block();
				{
					b.line("//");
					b.line("// find the child within this trie (index / childSize)");
					b.line("// then set that child's element (index % childSize)");
					b.line("// and build a new vector using the updated child");
					b.line("//");
					b.line("return setChild(childIndex, getChild(childIndex).set(index % childSize, value));");
				}
				b.endBlock();
				
				b.line("//");
				b.line("// we are beyond the capacity of this trie, so create a new level in the hierarachy");
				b.line("//");
				b.line("return new VectorTrie(level + 1,this, Vector.of(value));");
			}
			b.endBlock();

			//
			// push() method
			//
			b.line("public Vector<T> push(final T value)");
			b.block();
			{
				b.line("// add element after last current element");
				b.line("return this.set(this.size(), value);");
			}
			b.endBlock();

			//
			// push(e1..e16) method
			//
			b.indent("public Vector<T> push");
			b.args();
			for(int i = 0; i < nodeSize; i += 1)
			{
				b.arg(i, m.with("i", i).apply("final T e{{i}}"));
			}
			b.endArgs();
			b.block();
			{
				b.line("final int childIndex = size / childSize; // index of vector containing last element");
				b.line("final int childCount = size % childSize;  // size of vector containing last element");
				b.line("final int childCapacity = childSize - childCount;   // remaining capacity of vector containing last element");
				b.eol();
				
				b.line("//");
				b.line("// determine if we can just add this to the child, or if we need to split it between children");
				b.line("//");
				b.line(m.apply("if(childCapacity >= {{nodesize}})"));
				b.block();
				{
					b.line("if(childIndex < Vector.VECTOR_NODE_SIZE)");
					b.block();
					{
						b.line("//");
						b.line("// there is room for these elements in the child,");
						b.line("// push to the child, then rebuild the trie with the updated child");
						b.line("//");
						b.indent("return setChild(childIndex, getChild(childIndex).push");
						b.args();
						for(int i = 0; i < nodeSize; i += 1)
						{
							b.arg(i, m.with("i", i).apply("e{{i}}"));
						}
						b.endArgs();
						b.eol(");");
					}
					b.endBlock();
					
					b.line("//");
					b.line("// no room in this level of the hierarchy, so create another level");
					b.line("//");
					b.indent("return new VectorTrie<T>(this.level + 1, this, Vector.of").args();
					for(int i = 0; i < nodeSize; i += 1)
					{
						b.arg(i, m.with("i", i).apply("e{{i}}"));
					}
					b.endArgs().eol(");");
				}
				b.endBlock();
				b.line("else");
				b.block();
				{
					b.line("//");
					b.line("// there is not enough room in the child for 16 elements, which means these");
					b.line("// new elements will need to be split between children.");
					b.line("// Use a loop to push each element.  It is inefficient, but handles situation");
					b.line("// where a new child or new level in the hierarchy is required");
					b.line("//");
					b.indent("return this");
					for(int i = 0; i < nodeSize; i += 1)
					{
						b.emit(m.with("i", i).apply(".push(e{{i}})"));
					}
					b.eol(";");
				}
				b.endBlock();
			}
			b.endBlock();


			//
			// pushAll() method
			//
			b.line("public Vector<T> pushAll(final Iterable<T> iterable)");
			b.block();
			{
				b.line("return Vectors.pushAll(this, iterable);");
			}
			b.endBlock();


			//
			// map() method
			//
			b.line("public <R> Vector<R> map(final Function<? super T, ? extends R> mapper)");
			b.block();
			{
				b.indent("return new VectorTrie<R>").args();
				b.arg(0, "level");
				for(int i = 0; i < nodeSize; i += 1)
				{
					b.arg(i + 1, m.with("i", i).apply("vector{{i}}.map(mapper)"));
				}
				b.endArgs().eol(";");
			}
			b.endBlock();

			//
			// flatmap() method
			//
			b.line("public <R> Vector<R> flatmap(final Function<T, Vector<R>> mapper)");
			b.block();
			{
				b.line("Vector<R> result = Vector.empty;");
				for(int i = 0; i < nodeSize; i += 1)
				{
					b.line(m.with("i", i).apply("result = result.pushAll(vector{{i}}.flatmap(mapper));"));
				}
				b.line("return result;");
			}
			b.endBlock();

			//
			// toString() method
			//
			b.line("public String toString()");
			b.block();
			{
				b.line("return Vectors.toString(this);");
			}
			b.endBlock();

			//
			// iterator() method
			//
			b.line("public Iterator<T> iterator()");
			b.block();
			{
				b.line("return new VectorIterator<T>(this);");
			}
			b.endBlock();

			b.line("//");
			b.line("// ---------------------- private helpers --------------------------");
			b.line("//");
			
			b.line("/**");
			b.line(" * get child vector at given child index");
			b.line(" * ");
			b.line(" * @param childIndex index of child vector 0..Vector.VECTOR_NODE_SIZE-1");
			b.line(" * @return child vector given child index   ");
			b.line(" */");
			b.line("private Vector<T> getChild(final int childIndex)");
			b.block();
			{
				b.line("if((childIndex < 0) || (childIndex >= Vector.VECTOR_NODE_SIZE)) throw new IndexOutOfBoundsException();");
				b.line("switch(childIndex)");
				b.block();
				{
					for(int i = 0; i < nodeSize - 1; i += 1)
					{
						b.line(m.with("i", i).apply("case {{i}}: return vector{{i}};"));
					}
					b.line(m.apply("default: return vector{{nodesize-1}};"));
				}
				b.endBlock();
			}
			b.endBlock();

			//
			// setChild() method
			//
			b.line("/**");
			b.line(" * set child element at given index to the given vector");
			b.line(" * ");
			b.line(" * @param childIndex index of child vector 0..Vector.VECTOR_NODE_SIZE-1");
			b.line(" * @param childValue child vector");
			b.line(" * @return new vector with given child at given index   ");
			b.line(" */");
			b.line("private Vector<T> setChild(final int childIndex, Vector<T> childValue)");
			b.block();
			{
				b.line("if((childIndex < 0) || (childIndex >= Vector.VECTOR_NODE_SIZE)) throw new IndexOutOfBoundsException();");
				b.line("switch(childIndex)");
				b.block();
				{
					for(int i = 0; i < nodeSize; i += 1)
					{
						m.with("i", i);
						b.indent((i == nodeSize - 1) ? "default: " : m.apply("case {{i}}: ")).emit("return new VectorTrie(level");
						for(int j = 0; j < nodeSize; j += 1)
						{
							b.emit(", ").emit((i == j) ? "childValue" : m.with("j", j).apply("vector{{j}}"));
						}
						b.eol(");");
					}
				}
				b.endBlock();
			}
			b.endBlock();
		}
		b.endBlock();
	}
	
	/**
	 * Generate Vectors.java, with factory methods and shared implementations of map, flatmap and toString()
	 *
	 * @param writer
	 * @param nodeSize
	 */
	public void generateVectors(final Writer writer, final int nodeSize)
	{
		if(nodeSize < 2) throw new IllegalArgumentException();
		
		final boolean useVectorOfSize = false;
		
		final SourceBuilder b = new SourceBuilder(writer);
		final Macros m = new Macros();
		
		//
		// set up common symbols
		//
		m.with("nodesize", nodeSize);
		m.with("nodesize-1", nodeSize-1);
		
		//
		// package and imports
		//
		b.line("package com.lumpofcode.collection.vector;").eol();
		
		b.line("import com.lumpofcode.collection.vector.impl.*;").eol();
		b.line("import com.lumpofcode.annotation.NotNull;").eol();
		
		b.line("import java.util.Iterator;");
		b.line("import java.util.function.Function;").eol();
		
		b.eol().line("/*--- Generated by com.lumpofcode.collection.vector.VectorTemplate ---*/").eol();
		
		b.line("/**");
		b.line("* Methods that create or act on Vectors.");
		b.line("*");
		b.line("* Use the Vectors.asVector() functions to construct Vectors.");
		b.line("*");
		b.line("* Created by emurphy on 6/16/17.");
		b.line("*/");
		b.line("public final class Vectors");
		b.block();
		{
//			b.line("/**");
//			b.line(" * An empty vector as a singleton.");
//			b.line(" */");
//			b.line("public static final EmptyVector empty = new EmptyVector();").eol();
//
//			//
//			// loop to create all the Vectors.asVector() factory methods from 1..nodeSize
//			//
//			for(int i = 1; i <= nodeSize; i += 1)
//			{
//				m.with("i", i);
//				b.line("/**");
//				b.line(m.apply(" * Factory to construct a Vector with {{i}} elements"));
//				b.line(" *");
//				for(int j = 0; j < i; j += 1)
//				{
//					b.line(m.with("j", j).apply(" * @param e{{j}} the element an index {{j}}"));
//				}
//				b.line(" * @param <T> the type of the element");
//				b.line(m.apply(" * @return a Vector of type T with {{i}} elements"));
//				b.line(" */");
//				b.indent("public static final <T> Vector<T> asVector").args();
//				for (int j = 0; j < i; j += 1)
//				{
//					b.arg(j, m.with("j", j).apply("final T e{{j}}"));
//				}
//				b.endArgs().eol();
//
//				b.block();
//				{
//					if(!useVectorOfSize)
//					{
//						//
//						// using VectorOf## implementation
//						//
//						m.with("i", i);
//						b.indent(m.apply("return new VectorOf{{i}}<>")).args();
//						for (int j = 0; j < i; j += 1)
//						{
//							b.arg(j, m.with("j", j).apply("e{{j}}"));
//						}
//						b.endArgs().eol(";");
//					}
//					else
//					{
//						//
//						// using VectorOfSize() implementation
//						//
//						b.indent(m.apply("return new VectorOfSize<>")).args();
//						b.arg(0, m.with("i", i).apply("{{i}}"));
//						for (int j = 0; j < i; j += 1)
//						{
//							b.arg(j + 1, m.with("j", j).apply("e{{j}}"));
//						}
//						for (int j = i; j < nodeSize; j += 1)
//						{
//							b.arg(j + 1, "null");
//						}
//						b.endArgs().eol(";");
//					}
//				}
//				b.endBlock();
//			}
//
//			b.line("/**");
//			b.line(" * Construct a vector from an Iterable");
//			b.line(" *");
//			b.line(" * @param values an Iterable that provides ordered values");
//			b.line(" * @param <T>");
//			b.line(" * @return A vector of the elements of the Iterable");
//			b.line(" */");
//			b.line("public static final <T> Vector<T> asVector(Iterable<T> values)");
//			b.block();
//			{
//				b.line("return Vector.empty.pushAll(values);");
//			}
//			b.endBlock();
			
			
			b.line("/**");
			b.line(" * Push all elements in the Iterable into the end of the Vector");
			b.line(" *");
			b.line(" * @param vector");
			b.line(" * @param iterable");
			b.line(" * @param <T>");
			b.line(" * @return a new Vector with the Iterable's elements appended.");
			b.line(" */");
			b.line("public static final <T> Vector<T> pushAll(final Vector vector, final Iterable<T> iterable)");
			b.block();
			{
				b.line("//");
				b.line("// do in chunks of node size for efficiency");
				b.line("//");
				
				b.line("Vector<T> result = vector;");
				b.line("final Iterator<T> it = iterable.iterator();").eol();
				
				b.line("//");
				b.line("// get to a node-size-aligned result, so we can start using push-16 for efficiency");
				b.line("//");
				b.line("while(((result.size() % Vector.VECTOR_NODE_SIZE) != 0) && it.hasNext())");
				b.block();
				{
					b.line("result = result.push(it.next());");
				}
				b.endBlock();
				
				b.line("//");
				b.line("// While we have 16 elements available, collect them and use the more efficient 16 push,");
				b.line("// otherwise push each element individually");
				b.line("//");
				b.line("while(it.hasNext())");
				b.block();
				{
					//
					// indented 'if' until we reach node size
					//
					for(int i = 0; i < nodeSize - 1; i += 1)
					{
						b.line(m.with("i", i).apply("final T e{{i}} = it.next();"));
						b.line("if (it.hasNext())");
						b.block();
					}
					
					//
					// at nodesize - 1, emit a node size push
					//
					b.line("//");
					b.line("// we have enough for a node size push");
					b.line("//");
					b.line(m.apply("final T e{{nodesize-1}} = it.next();"));
					b.indent("result = result.push").args();
					for (int j = 0; j < nodeSize; j += 1)
					{
						b.arg(j, m.with("j", j).apply("e{{j}}"));
					}
					b.endArgs().eol(";");
					
					//
					// close all if statement blocks
					//
					for(int i = nodeSize - 1; i > 0; i -= 1)
					{
						b.endBlock(false);
						b.line("else");
						b.block();
						{
							b.line("//");
							b.line("// else we don't have enough for a push of node size, so do a series of push of 1");
							b.line("//");
							b.indent("result = result");
							for(int j = 0; j < i; j += 1)
							{
								b.emit(m.with("j", j).apply(".push(e{{j}})"));
							}
							b.eol(";");
						}
						b.endBlock(false);
					}
				}
				b.endBlock();

				b.line("return result;");
			}
			b.endBlock();


			b.line("/**");
			b.line(" * Map the values in the vector using the mapper function");
			b.line(" * and return a new vector of mapped elements.");
			b.line(" *");
			b.line(" * @param vector the vector to operate on");
			b.line(" * @param <R> the resulting element type");
			b.line(" * @param mapper function that maps a T to an R");
			b.line(" * @return Vector of elements of type R");
			b.line(" */");
			b.line("public static <T, R> Vector<R> map(final @NotNull Vector<T> vector, final @NotNull Function<? super T, ? extends R> mapper)");
			b.block();
			{
				b.line("//");
				b.line("// do in chunks of node size for efficiency");
				b.line("//");
				b.line("Vector<R> result = Vector.empty;");
				b.line("int index = 0;");
				b.line("while(index <= (vector.size() - Vector.VECTOR_NODE_SIZE))");
				b.block();
				{
					b.indent().args("result = result.push");
					for(int i = 0; i < nodeSize; i += 1)
					{
						m.with("tab", (0 == i % 4) ? "\n\t\t\t\t" : "\t");
						b.arg(i, m.with("i", i).apply("{{tab}}mapper.apply(vector.get(index + {{i}}))"));
					}
					b.endArgs().eol(";");
					b.line("index += Vector.VECTOR_NODE_SIZE;");
				}
				b.endBlock();
				
				b.line("//");
				b.line("// handle the rest with simple push");
				b.line("//");
				b.line("while(index < vector.size())");
				b.block();
				{
					b.line("result = result.push(mapper.apply(vector.get(index)));");
					b.line("index += 1;");
				}
				b.endBlock();
				b.line("return result;");
			}
			b.endBlock();
			
			b.line("/**");
			b.line(" * Map each element of type T of the vector to");
			b.line(" * a Vector of type R, to produce a vector of vectors of type R,");
			b.line(" * then flatten (append) that into a vector of type R.");
			b.line(" *");
			b.line(" * @param vector the vector to operate on");
			b.line(" * @param <R> the resulting element type");
			b.line(" * @param mapper function that maps a value of type T");
			b.line(" *               to a Vector with elements of type R");
			b.line(" * @return Vector of elements of type R");
			b.line(" */");
			b.line("public static <T, R> Vector<R> flatmap(final @NotNull Vector<T> vector, final @NotNull Function<T, Vector<R>> mapper)");
			b.block();
			{
				b.line("Vector<R> result = Vector.empty;");
				b.line("for(T element : vector)");
				b.block();
				{
					b.line("result = result.pushAll(mapper.apply(element));");
				}
				b.endBlock();
				b.line("return result;");
			}
			b.endBlock();
			
			
			//
			// toString()
			//
			b.line("/**");
			b.line(" * Format vectors as '[e0, e1, e2...]'");
			b.line(" *");
			b.line(" * @param vector");
			b.line(" * @param <T>");
			b.line(" * @return");
			b.line(" */");
			b.line("public static <T> String toString(final @NotNull Vector<T> vector)");
			b.block();
			{
				b.line("final StringBuilder builder = new StringBuilder();");
				b.line("builder.append('[');");
				b.line("if(!vector.isEmpty())");
				b.block();
				{
					b.line("builder.append(vector.get(0));");
					b.line("for(int i = 1; i < vector.size(); i += 1)");
					b.block();
					{
						b.line("builder.append(\", \").append(vector.get(i));");
					}
					b.endBlock(false);
				}
				b.endBlock(false);
				b.line("builder.append(']');");
				
				b.line("return builder.toString();");
			}
			b.endBlock();


		}
		b.endBlock();
	}
	
}
