/*package jarTool.powerMock.gitcodePo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

*//** 
 * @Description: 描述 
 * @date 2017年1月4日  上午11:12:53
 *//*
@RunWith(PowerMockRunner.class)
@PrepareForTest(Static.class)
public class YourTestCase {
    @Test
    public void testMethodThatCallsStaticMethod() {
        // mock all the static methods in a class called "Static"
        PowerMockito.mockStatic(Static.class);
        // use Mockito to set up your expectation
        Mockito.when(Static.firstStaticMethod("param")).thenReturn("value");
        Mockito.when(Static.secondStaticMethod()).thenReturn(123);

        // execute your test
        //classCallStaticMethodObj.execute();

        // Different from Mockito, always use PowerMockito.verifyStatic() first
        // to start verifying behavior
        PowerMockito.verifyStatic(Mockito.times(2));
        // IMPORTANT:  Call the static method you want to verify
        Static.firstStaticMethod("param2");


        // IMPORTANT: You need to call verifyStatic() per method verification, 
        // so call verifyStatic() again
        PowerMockito.verifyStatic(); // default times is once
        // Again call the static method which is being verified 
        Static.secondStaticMethod();

        // Again, remember to call verifyStatic()
        PowerMockito.verifyStatic(Mockito.never());
        // And again call the static method. 
        Static.thirdStaticMethod();
    }
}
*/