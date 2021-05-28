package com.openvarsity.auth.commons.collections;

import com.openvarsity.auth.commons.model.Permission;

import java.util.*;

public class Permissions implements Set<Permission> {

    private Set<Permission> treeSet = new TreeSet<>();

    @Override
    public int size() {
        return treeSet.size();
    }

    @Override
    public boolean isEmpty() {
        return treeSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return treeSet.contains(o);
    }

    @Override
    public Iterator<Permission> iterator() {
        return treeSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return treeSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return treeSet.toArray(a);
    }

    @Override
    public boolean add(Permission permission) {
        return treeSet.add(permission);
    }

    @Override
    public boolean remove(Object o) {
        return treeSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return treeSet.contains(c);
    }

    @Override
    public boolean addAll(Collection<? extends Permission> c) {
        return treeSet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return treeSet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return treeSet.removeAll(c);
    }

    @Override
    public void clear() {
        treeSet.clear();
    }

    public static Permissions of(Permission... permissions){
        final Permissions permissionsObject = new Permissions();
        permissionsObject.addAll(Arrays.asList(permissions));
        return permissionsObject;
    }
}
