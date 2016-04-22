package test.undergrowth.learnspring;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;

/**
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2016年4月22日
 * @Version 1.0.0
 */
public class MockitoTest {

	@Test
	public void verifyTest() {
		// mock creation
		List mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	@Test
	public void stubbingTest() {
		// You can mock concrete classes, not just interfaces
		LinkedList mockedList = mock(LinkedList.class);

		// stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		// following prints "first"
		System.out.println(mockedList.get(0));

		// following throws runtime exception
		System.out.println(mockedList.get(1));

		// following prints "null" because get(999) was not stubbed
		System.out.println(mockedList.get(999));

		// Although it is possible to verify a stubbed invocation, usually it's
		// just redundant
		// If your code cares what get(0) returns, then something else breaks
		// (often even before verify() gets executed).
		// If your code doesn't care what get(0) returns, then it should not be
		// stubbed. Not convinced? See here.
		verify(mockedList).get(0);
	}

	/**
	 * If you are using argument matchers, all arguments have to be provided by
	 * matchers. The following example shows verification but the same applies
	 * to stubbing:
	 */
	@Test
	public void argumentMatcher() {

		// You can mock concrete classes, not just interfaces
		LinkedList mockedList = mock(LinkedList.class);
		// stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		// stubbing using custom matcher (let's say isValid() returns your own
		// matcher implementation):
		// when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		// following prints "element"
		System.out.println(mockedList.get(999));

		// you can also verify using an argument matcher
		verify(mockedList).get(anyInt());
	}

	/**
	 * times(1) is the default. Therefore using times(1) explicitly can be
	 * omitted.
	 */
	@Test
	public void invocationTimes() {

		// You can mock concrete classes, not just interfaces
		LinkedList mockedList = mock(LinkedList.class);
		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		// following two verifications work exactly the same - times(1) is used
		// by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		// verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");
	}

	@Test
	public void verifyOrder() {
		// A. Single mock whose methods must be invoked in a particular order
		List singleMock = mock(List.class);

		// using a single mock
		singleMock.add("was added first");
		singleMock.add("was added second");

		// create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(singleMock);

		// following will make sure that add is first called with "was added
		// first, then with "was added second"
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");

		// B. Multiple mocks that must be used in a particular order
		List firstMock = mock(List.class);
		List secondMock = mock(List.class);

		// using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");

		// create inOrder object passing any mocks that need to be verified in
		// order
		inOrder = inOrder(firstMock, secondMock);

		// following will make sure that firstMock was called before secondMock
		inOrder.verify(firstMock).add("was called first");
		inOrder.verify(secondMock).add("was called second");

		// Oh, and A + B can be mixed together at will
	}

	@Test
	public void interactionTest() {
		List mockOne = mock(List.class);
		List mockTwo = mock(List.class);
		List mockThree = mock(List.class);
		// using mocks - only mockOne is interacted
		mockOne.add("one");

		// ordinary verification
		verify(mockOne).add("one");

		// verify that method was never called on a mock
		verify(mockOne, never()).add("two");

		// verify that other mocks were not interacted
		verifyZeroInteractions(mockTwo, mockThree);
	}

	@Test
	public void consecutiveTest(){
		List mock = mock(List.class);
		when(mock.get(anyInt()))
		   //.thenThrow(new RuntimeException())
		   .thenReturn("qq")
		   .thenReturn("foo");

		 //First call: :
		 mock.get(0);

		 //Second call: prints "foo"
		 System.out.println(mock.get(1));

		 //Any consecutive call: prints "foo" as well (last stubbing wins).
		 System.out.println(mock.get(2));
		 
	}
	
	
	
}
