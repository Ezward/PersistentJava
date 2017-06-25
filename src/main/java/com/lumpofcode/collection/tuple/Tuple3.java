package com.lumpofcode.collection.tuple;

/**
 * Created by emurphy on 6/25/17.
 */
public final class Tuple3<T1, T2, T3>
{
	public final T1 t1;
	public final T2 t2;
	public final T3 t3;
	
	public Tuple3(T1 t1, T2 t2, T3 t3)
	{
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
	}
}