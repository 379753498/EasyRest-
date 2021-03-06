package com.example.demo;


import com.testpro.easyrest.Core.imp.RestAssuredImp;
import com.testpro.easyrest.Data.ExcelInterfaceDataProd;
import com.testpro.easyrest.bean.ExecutionData;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Iterator;


public class DemoApplicationTests  {


    public  static RestAssuredImp restAssuredImp =  new RestAssuredImp();
    @DataProvider(name = "getdata")
    public Iterator<Object[]> getdata() {
        return new ExcelInterfaceDataProd().ImplementDataProvider();
    }

    @Test(testName = "esayrestTests", dataProvider = "getdata")
    @Step("测试用例名称：{executionData.caseDescription}")
    public void EasyRestApplicationContext(ExecutionData executionData) {
        System.out.println(executionData);
        restAssuredImp.execution(executionData);
    }

}

