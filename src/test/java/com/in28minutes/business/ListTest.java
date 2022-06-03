package com.in28minutes.business;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertThat;



public class ListTest {

    @Test
    public void letsMockListSizeMethod(){
        List listMock = mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListSize_ReturnMultipleValues(){
        List listMock = mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2).thenReturn(3);  // when list.size is called first time it returns 2 then returns 3.
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
        Mockito.when(listMock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", listMock.get(0));
//        assertEquals("in28Minutes", listMock.get(1)); // this returns null
    }

    @Test
    public void letsMockListGetAny(){
        List listMock = mock(List.class);

        // Argument Matcher
        Mockito.when(listMock.get(anyInt())).thenReturn("in28Minutes");     // anyInt is argument Matcher
        assertEquals("in28Minutes", listMock.get(0));
        assertEquals("in28Minutes", listMock.get(1)); // every value of list returns same string i.e In28Minutes.
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_throwAnException(){
        List listMock = mock(List.class);

        // Argument Matcher
        Mockito.when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        listMock.get(0);
    }

    @Test
    public void letsMockListGet_UsingBDD(){
        //Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("in28Minutes");

        //When
        String firstElement = listMock.get(0);

        //Then
        assertThat(firstElement, is("in28Minutes"));
    }
}







