package com.mygdx.game;

/**
 * Interface for Position- kontrakten med moetoder som definerer kordinatene til et
 * trekk.
 * 
 * @author Markus Medalen
 * 
 */
public interface Position {

	/**
	 * Gir x-koordinaten til trekket.
	 * 
	 * @return En int verdi.
	 */
	public int getX();

	/**
	 * Gir y-koordinaten til trekket.
	 * 
	 * @return En int verdi.
	 */
	public int getY();
}
