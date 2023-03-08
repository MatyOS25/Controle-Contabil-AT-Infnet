package br.edu.infnet.financialcontrol.model.service;

import java.util.Collection;

public interface IService<T> {
    public boolean add(T entity);

    public T remove(Integer key);

    public static Collection<T> returnList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnList'");
    }
}
