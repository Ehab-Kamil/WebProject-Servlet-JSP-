/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Bakar M.M.R
 */
public interface DoaInterface<T> {
    int insert(T bean);
    int update(T bean);
    int delete(T bean);
    T selectById(int id);
    T selectByName(String name);
    List<T> selectAll();
}
