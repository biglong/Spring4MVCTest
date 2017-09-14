package com.hsl.test.repository;

import com.hsl.test.model.Spitter;

/**
 * Created by huangshaolong on 2017/9/7.
 *
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
