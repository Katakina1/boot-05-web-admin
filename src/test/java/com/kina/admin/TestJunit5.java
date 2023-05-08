package com.kina.admin;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class TestJunit5 {


    @DisplayName("测试前置条件")
    @Test
    void testAssumptions() {
        Assumptions.assumeTrue(false, "结果不是true");
        System.out.println("111111");
    }

    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(2, 3);
        Assertions.assertEquals(5, cal, "业务逻辑计算失败！");
        Object obj1 = new Object();
        Object obj2 = obj1;
        Assertions.assertSame(obj1, obj2, "两个对象不一样");
    }

    @DisplayName("组合断言")
    @Test
    void all() {
        // 断言需要全部成功！
        Assertions.assertAll("test", () -> Assertions.assertTrue(true && true),
                () -> Assertions.assertEquals(1, 1));
    }

    @DisplayName("异常断言")
    @Test
    void testException() {
        // 断定业务逻辑一定出现异常
        Assertions.assertThrows(ArithmeticException.class, () -> {int i = 10 / 0;}, "业务逻辑运行不正确");
    }

    @DisplayName("快速失败")
    @Test
    void testFail() {
        if (1 == 2)
        Assertions.fail("快速失败");
    }

    int cal(int i, int j) {
        return i + j;
    }

    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName() {
        System.out.println("1");
    }

    @Disabled
    @DisplayName("测试方法二")
    @Test
    void test2() {
        System.out.println("2");
    }

    // 重复测试
    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println(5);
    }

    // 规定方法的超时时间，超过规定时间就会出现异常
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(100);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试已经结束了");
    }
}
