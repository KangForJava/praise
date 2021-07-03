/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: BaseJunit4Test
 * Author: kjy
 * Date: 2021/5/30 15:06
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.test;

/*
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/30
 * @since 1.0.0
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public abstract class BaseJunit4Test {
    public BaseJunit4Test() {
    }

    /**
     * Test执行之前调用，可以做一些初始化操作。
     */
    @Before
    public void before(){

    }

    /**
     * Test执行完成后调用，可以做一些回收和销毁操作。
     */
    @After
    public void after(){

    }

    /**
     * 具体的测试方法
     */
    @Test
    public abstract void test();
}

