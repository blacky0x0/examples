package com.blacky.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings (value = "unchecked")
public class MockitoAnnotationTest {

    // http://www.baeldung.com/mockito-annotations

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() throws Exception {
        List mockList = mock(ArrayList.class);
        mockList.add("one");

        verify(mockList, times(1)).add("one");
        assertEquals(0, mockList.size());

        when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    @Mock
    List mockedList;

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");
        Mockito.verify(spyList, times(1)).add("one");
        Mockito.verify(spyList, after(3000).times(1)).add("two");

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();

        assertEquals(100, spyList.size());
    }

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjected() {
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }

    @Test
    public void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        Mockito.verify(mockList).add(arg.capture());

        assertEquals("one", arg.getValue());
    }

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        mockedList.add("two");
        Mockito.verify(mockedList, times(2)).add(argCaptor.capture());

        assertEquals(Arrays.asList("one", "two"), argCaptor.getAllValues());
    }

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }

    static class MyDictionary {
        Map<String, String> wordMap;

        public MyDictionary() {
            wordMap = new HashMap<String, String>();
        }
        public void add(final String word, final String meaning) {
            wordMap.put(word, meaning);
        }
        public String getMeaning(final String word) {
            return wordMap.get(word);
        }
    }
}
