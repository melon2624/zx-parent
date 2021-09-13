package com.zx.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author : zhangxin
 * @date : 2021-09-13 17:02
 **/
@Service
public class ZxServieImpl implements ZxServie {


    @Override
    @Async("zhangxinAsync")
    public void zhangxin() {
            int i=0;
        try {
            Thread.sleep(2000);
            System.out.println("zhangxin"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
