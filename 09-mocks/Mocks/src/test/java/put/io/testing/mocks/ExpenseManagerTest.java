package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {
    @Test
    public void testCalculateTotal(){
        ExpenseRepository repositoryMock = mock(ExpenseRepository.class);
        List<Expense> lista = new ArrayList<Expense>();
        for(int i = 0; i < 3; i++){
            Expense ex = new Expense();
            ex.setTitle("Ananas");
            ex.setCategory("Owoc");
            ex.setAmount(3);
            lista.add(ex);
        }
        when(repositoryMock.getExpenses()).thenReturn(lista);
        FancyService serviceMock = mock(FancyService.class);
        ExpenseManager man = new ExpenseManager(repositoryMock, serviceMock);
        assertEquals(9, man.calculateTotal());
    }

    @Test
    public void testCalculateTotalForCategory(){
        ExpenseRepository repositoryMock = mock(ExpenseRepository.class);
        List<Expense> lista = new ArrayList<>();
        List<Expense> lista2 = new ArrayList<>();

        Expense ex = new Expense();
        ex.setTitle("Ananas");
        ex.setCategory("Home");
        ex.setAmount(3);
        lista.add(ex);

        ex = new Expense();
        ex.setTitle("Lodowka");
        ex.setCategory("Home");
        ex.setAmount(1);
        lista.add(ex);

        ex = new Expense();
        ex.setTitle("Kierownica");
        ex.setCategory("Car");
        ex.setAmount(2);
        lista2.add(ex);

        ex = new Expense();
        ex.setTitle("Opony");
        ex.setCategory("Car");
        ex.setAmount(4);
        lista2.add(ex);

        ex = new Expense();
        ex.setTitle("Wycieraczki");
        ex.setCategory("Car");
        ex.setAmount(3);
        lista2.add(ex);
        assertEquals(2, lista.size());

        when(repositoryMock.getExpensesByCategory(anyString())).thenReturn(Collections.emptyList());
        when(repositoryMock.getExpensesByCategory("Home")).thenReturn(lista);
        when(repositoryMock.getExpensesByCategory("Car")).thenReturn(lista2);


        FancyService serviceMock = mock(FancyService.class);
        ExpenseManager man = new ExpenseManager(repositoryMock, serviceMock);

        assertEquals(4, man.calculateTotalForCategory("Home"));
        assertEquals(9, man.calculateTotalForCategory("Car"));
        assertEquals(0, man.calculateTotalForCategory("Food"));
        assertEquals(0,man.calculateTotalForCategory("Sport"));
    }
}
