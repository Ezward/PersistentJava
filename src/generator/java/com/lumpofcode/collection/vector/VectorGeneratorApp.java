package com.lumpofcode.collection.vector;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by emurphy on 6/30/17.
 */
public class VectorGeneratorApp
{
	public static void main(String[] args) throws IOException
	{
		final int nodeSize = (args.length > 0) ? Integer.valueOf(args[0]) : 16;
		final String fileFolder = (args.length > 1) ? args[1] : "./src/main/java/com/lumpofcode/collection/vector/";
		
//		vectorTemplateSystemOut(nodeSize);
		vectorTemplateFileWriter(nodeSize, fileFolder);
	}
	
	public static void vectorTemplateSystemOut(final int radix)
	{
		if(radix < 2) throw new IllegalArgumentException();

		final VectorTemplate template = new VectorTemplate();
		
		Writer writer = new StringWriter();
		template.generateVectorInterface(writer, radix);
		final String vectorInterface = writer.toString();
		System.out.println(vectorInterface);

		writer = new StringWriter();
		template.generateEmptyVector(writer, radix);
		final String emptyVector = writer.toString();
		System.out.println(emptyVector);

		for(int i = 1; i <= radix; i += 1)
		{
			writer = new StringWriter();
			template.generateVectorOfNN(writer, i, radix);
			final String vectorOf = writer.toString();
			System.out.println(vectorOf);
		}

		writer = new StringWriter();
		template.generateVectorTrie(writer, radix);
		final String vectorTrie = writer.toString();
		System.out.println(vectorTrie);

		writer = new StringWriter();
		template.generateVectors(writer, radix);
		final String vectors = writer.toString();
		System.out.println(vectors);
	}
	
	/**
	 * Run this in order to generate
	 * the Vector.java and Vectors.java
	 * and the implementation files EmptyVector.java and
	 * the family ofVectorOfNN.java files and VectorTrie.java
	 * in 'com/lumpofcode/collection/vector/impl'
	 *
	 * @throws IOException
	 */
	public static void vectorTemplateFileWriter(final int radix, final String fileFolder) throws IOException
	{
		if(radix < 2) throw new IllegalArgumentException();
		
		//
		// create directory structure './src/generated/java/com/lumpofcode/collection/vector/' starting at './src/generated'
		//
		final File folder = new File(fileFolder);
		if(!folder.exists())
		{
			if (!folder.mkdir())
			{
				throw new RuntimeException("Unable to create folder for generated sources.");
			}
		}
		
		final File implFolder = new File(folder, "impl");
		if(!implFolder.exists())
		{
			if (!implFolder.mkdir())
			{
				throw new RuntimeException("Unable to create imple folder for generated sources.");
			}
		}
		
		final VectorTemplate template = new VectorTemplate();

		//
		// write the Vector.java interface file in the vector folder
		//
		File file = new File(folder, "Vector.java");
		if(file.exists())
		{
			file.delete();
		}
		
		Writer writer = new FileWriter(file.getPath());
		template.generateVectorInterface(writer, radix);
		writer.flush();
		writer.close();
		
		//
		// write EmptyVector.java in the impl folder
		//
		file = new File(implFolder, "EmptyVector.java");
		if(file.exists())
		{
			file.delete();
		}
		
		writer = new FileWriter(file.getPath());
		template.generateEmptyVector(writer, radix);
		writer.flush();
		writer.close();
		
		
		//
		// write the VectorOf## source files in the impl folder
		//
		for(int i = 1; i <= radix; i += 1)
		{
			//
			// delete existing file and recreate
			//
			final String fileName = "VectorOf{{size}}.java".replace("{{size}}", String.valueOf(i));
			file = new File(implFolder, fileName);
			if(file.exists())
			{
				file.delete();
			}
			
			writer = new FileWriter(file.getPath());
			template.generateVectorOfNN(writer, i, radix);
			writer.flush();
			writer.close();
		}
		
		//
		// write the VectorTrie file in the impl folder
		//
		file = new File(implFolder, "VectorTrie.java");
		if(file.exists())
		{
			file.delete();
		}
		
		writer = new FileWriter(file.getPath());
		template.generateVectorTrie(writer, radix);
		writer.flush();
		writer.close();
		
		//
		// write the Vectors file in the vector folder
		//
		file = new File(folder, "Vectors.java");
		if(file.exists())
		{
			file.delete();
		}
		
		writer = new FileWriter(file.getPath());
		template.generateVectors(writer, radix);
		writer.flush();
		writer.close();
		
	}
	
}
