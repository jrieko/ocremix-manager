/**
 * Copyright (C) 2007 Richard Taylor
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3, or (at your option)
 * any later version.
 *
 * You should have received a copy of the GNU General Public License
 * (for example /usr/src/linux/COPYING); if not, write to the Free
 * Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package com.dicksoft.ocr.data;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * A HashSet that does not allow null elements. Also, attempting to add an
 * element with a hashCode that matches an existing element will <i>NOT</i>
 * replace the existing one. TODO synchronized access
 * 
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class OCRSet<E> extends AbstractSet<E> implements Set<E>, Cloneable,
        Serializable {
    private static final long serialVersionUID = 8572039892434025006L;
    private transient HashMap<Integer, E> map;

    // Dummy value to associate with an Object in the backing Map
    // private static final Object PRESENT = new Object();

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * default initial capacity (16) and load factor (0.75).
     */
    public OCRSet() {
        this.map = new HashMap<Integer, E>();
    }

    /**
     * Constructs a new set containing the elements in the specified collection.
     * The <tt>HashMap</tt> is created with default load factor (0.75) and an
     * initial capacity sufficient to contain the elements in the specified
     * collection.
     * 
     * @param c
     *            the collection whose elements are to be placed into this set.
     * @throws NullPointerException
     *             if the specified collection is null.
     */
    public OCRSet(Collection<? extends E> c) {
        this.map =
                new HashMap<Integer, E>(Math.max((int) (c.size() / .75f) + 1,
                        16));
        this.addAll(c);
    }

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * the specified initial capacity and the specified load factor.
     * 
     * @param initialCapacity
     *            the initial capacity of the hash map.
     * @param loadFactor
     *            the load factor of the hash map.
     * @throws IllegalArgumentException
     *             if the initial capacity is less than zero, or if the load
     *             factor is nonpositive.
     */
    public OCRSet(int initialCapacity, float loadFactor) {
        this.map = new HashMap<Integer, E>(initialCapacity, loadFactor);
    }

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * the specified initial capacity and default load factor, which is
     * <tt>0.75</tt>.
     * 
     * @param initialCapacity
     *            the initial capacity of the hash table.
     * @throws IllegalArgumentException
     *             if the initial capacity is less than zero.
     */
    public OCRSet(int initialCapacity) {
        this.map = new HashMap<Integer, E>(initialCapacity);
    }

    /**
     * Constructs a new, empty linked hash set. (This package private
     * constructor is only used by LinkedHashSet.) The backing HashMap instance
     * is a LinkedHashMap with the specified initial capacity and the specified
     * load factor.
     * 
     * @param initialCapacity
     *            the initial capacity of the hash map.
     * @param loadFactor
     *            the load factor of the hash map.
     * @param dummy
     *            ignored (distinguishes this constructor from other int, float
     *            constructor.)
     * @throws IllegalArgumentException
     *             if the initial capacity is less than zero, or if the load
     *             factor is nonpositive.
     */
    OCRSet(int initialCapacity, float loadFactor, boolean dummy) {
        this.map = new LinkedHashMap<Integer, E>(initialCapacity, loadFactor);
    }

    /**
     * Returns an iterator over the elements in this set. The elements are
     * returned in no particular order.
     * 
     * @return an Iterator over the elements in this set.
     * @see ConcurrentModificationException
     */
    public Iterator<E> iterator() {
        return this.map.values().iterator();
    }

    /**
     * Returns the number of elements in this set (its cardinality).
     * 
     * @return the number of elements in this set (its cardinality).
     */
    public int size() {
        return this.map.size();
    }

    /**
     * Returns <tt>true</tt> if this set contains no elements.
     * 
     * @return <tt>true</tt> if this set contains no elements.
     */
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    /**
     * Returns <tt>true</tt> if this set contains the specified element.
     * 
     * @param o
     *            element whose presence in this set is to be tested.
     * @return <tt>true</tt> if this set contains the specified element.
     */
    public boolean contains(Object o) {
        return this.map.containsKey(o.hashCode());
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * 
     * @param o
     *            element to be added to this set.
     * @return <tt>true</tt> if the set did not already contain the specified
     *         element.
     */
    public boolean add(E o) {
        if (o == null)
            return false;
        if (this.map.containsKey(o.hashCode())) {
            return false;
        }
        return this.map.put(o.hashCode(), o) == null;
    }

    /**
     * Try to add the specified Object. If this Set already contains an element
     * with a hashCode matching that of the specified Object, this Set is
     * unchanged.
     * 
     * @param o
     *            the Object to try to add
     * @return The element in this Set with a hashCode matching that of the
     *         specified Object, if one was found, the specified Object
     *         otherwise.
     */
    public E tryAdd(E o) {
        E found = this.map.get(o.hashCode());
        if (found != null) {
            return found;
        }
        this.map.put(o.hashCode(), o);
        return o;
    }

    /**
     * Removes the specified element from this set if it is present.
     * 
     * @param o
     *            object to be removed from this set, if present.
     * @return <tt>true</tt> if the set contained the specified element.
     */
    public boolean remove(Object o) {
        return this.map.remove(o.hashCode()) != null;
    }

    /**
     * Removes all of the elements from this set.
     */
    public void clear() {
        this.map.clear();
    }

    /**
     * Returns a shallow copy of this <tt>OCRSet</tt> instance: the elements
     * themselves are not cloned.
     * 
     * @return a shallow copy of this set.
     */
    @SuppressWarnings("unchecked")
    public Object clone() {
        try {
            OCRSet<E> newSet = (OCRSet<E>) super.clone();
            newSet.map = (HashMap<Integer, E>) map.clone();
            return newSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /**
     * Get this Set as a List.
     * 
     * @return the List
     */
    public List<E> toList() {
        ArrayList<E> result = new ArrayList<E>(this.size());
        for (E e : this) {
            result.add(e);
        }
        return result;
    }

    /**
     * Save the state of this <tt>OCRSet</tt> instance to a stream (that is,
     * serialize this set).
     * 
     * @serialData The capacity of the backing <tt>HashMap</tt> instance
     *             (int), and its load factor (float) are emitted, followed by
     *             the size of the set (the number of elements it contains)
     *             (int), followed by all of its elements (each an Object) in no
     *             particular order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // Write out HashMap capacity and load factor
        // s.writeInt(map.capacity());
        // s.writeFloat(map.loadFactor());

        // Write out size
        s.writeInt(this.map.size());

        // Write out all elements in the proper order.
        for (Iterator<E> i = this.map.values().iterator(); i.hasNext();)
            s.writeObject(i.next());
    }

    /**
     * Reconstitute the <tt>OCRSet</tt> instance from a stream (that is,
     * deserialize it).
     */
    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // Read in HashMap capacity and load factor and create backing HashMap
        // int capacity = s.readInt();
        // float loadFactor = s.readFloat();
        this.map = new HashMap<Integer, E>();

        // Read in size
        int size = s.readInt();

        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++) {
            E e = (E) s.readObject();
            this.map.put(e.hashCode(), e);
        }
    }
}
