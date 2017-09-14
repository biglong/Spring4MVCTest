package com.hsl.test.repository;

import com.hsl.test.model.Spitter;
import com.hsl.test.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by huangshaolong on 2017/8/30.
 *
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);

}
