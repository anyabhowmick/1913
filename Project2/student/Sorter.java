/* Copyright © 2024. Ralph A Foy
 *
 * All Rights Reserved.
 * Provided for students registered in course ICS340-01
 *  at Metropolitan State University, Summer 2024.
 */
package student;

/**
 * Defines a common interface for in-situ generic sorting class
 * 
 * @author rfoy
 *
 * @param <T>
 */
public interface Sorter<T extends Comparable<T>> {
	void sort(T[] items);
}
