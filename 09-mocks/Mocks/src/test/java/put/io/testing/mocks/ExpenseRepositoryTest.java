package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        /*MyDatabase d = new MyDatabase();
        ExpenseRepository e = new ExpenseRepository(d);
        e.loadExpenses();
        assertTrue(e.getExpenses().isEmpty());*/

        IFancyDatabase myMock = mock(IFancyDatabase.class);
        when(myMock.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository e = new ExpenseRepository(myMock);
        e.loadExpenses();
        InOrder inOrder = inOrder(myMock);
        inOrder.verify(myMock, times(1)).connect();
        inOrder.verify(myMock, atLeastOnce()).queryAll();
        inOrder.verify(myMock, times(1)).close();
        assertTrue(e.getExpenses().isEmpty());
    }

    @Test
    void testSaveExpenses(){
        IFancyDatabase myMock = mock(IFancyDatabase.class);
        when(myMock.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository e = new ExpenseRepository(myMock);
        for(int i = 0; i < 5; i++){
            e.addExpense(new Expense());
        }
        e.saveExpenses();
        InOrder inOrder = inOrder(myMock);
        inOrder.verify(myMock, times(1)).connect();
        verify(myMock, times(5)).persist(any(Expense.class));
        inOrder.verify(myMock, times(1)).close();
    }
}
