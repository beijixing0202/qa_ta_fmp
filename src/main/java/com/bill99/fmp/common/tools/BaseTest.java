package com.bill99.fmp.common.tools;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Iterator;

@ContextConfiguration(locations = {"classpath:qacontext/applicationContext.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests{

    //迭代器
    @DataProvider(name="getData")
    public Iterator<Object[]> dataForTestMethod(Method method) throws FileNotFoundException{
        return  (Iterator<Object[]>) new ExcelDataProvider(this.getClass().getSimpleName(),method.getName());
    }

}
