package com.gale.answers;

import com.gale.domain.Bar;
import com.gale.domain.Foo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.exceptions.verification.SmartNullPointerException;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class SmartNullsTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    Foo mockFoo;

    @Test(expected = NullPointerException.class)
    public void nullTest_shouldFail() {
        Bar b = new Foo().getBar();

        b.getName(); //throws null pointer
    }

    @Test(expected = SmartNullPointerException.class)
    public void smartNullTest_shouldFail() {
        Bar b = mockFoo.getBar();
        //throws "smart" null pointer
        b.getName();
    }
}
