package com.ebm.domain.service;

import com.ebm.domain.Iteration;
import com.ebm.domain.repository.IterationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class IterationServiceTest {
    IterationService tester;
    IterationRepository iterationRepository;


    @BeforeEach
    void initEach() {
        iterationRepository = Mockito.mock(IterationRepository.class);
        tester = new IterationService(iterationRepository);
    }

    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }

    @Test
    void TestGetAllWithData() {
        List<Iteration> iterations = new ArrayList<>();
        Iteration iteration = new Iteration();
        iterations.add(iteration);
        when(iterationRepository.getAll()).thenReturn(iterations);

        List<Iteration> iterationsResult = tester.getAll();

        assertEquals(1, iterationsResult.size(), "getAll must have an iteration");
        assertEquals(iteration, iterationsResult.toArray()[0], "getAll must have an iteration equal to object defined");
    }


    @Test
    void TestGetLastIteration() {
        assertNull(tester.getLastIteration(1), "getLastIteration must be null");
    }

    @Test
    void TestGetLastIterationWithData() {
        Iteration iteration = new Iteration();
        when(iterationRepository.getLastIteration(1)).thenReturn(iteration);

        Iteration iterationResult = tester.getLastIteration(1);

        assertEquals(iteration, iterationResult, "getLastIteration must have an iteration");
    }


    @Test
    void TestGetIterationByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getIterationById(1), "getByTeam must be Optional.empty()");
    }

    @Test
    void TestGetIterationByIdWithData() {
        Optional<Iteration> iterations = Optional.of(new Iteration());
        when(iterationRepository.getIterationById(1)).thenReturn(iterations);

        Optional<Iteration> iterationsResult = tester.getIterationById(1);

        assertEquals(iterations, iterationsResult, "getAll must have an iteration");
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new Iteration()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Iteration iteration = new Iteration();
        when(iterationRepository.save(iteration)).thenReturn(iteration);

        assertEquals(iteration, tester.save(iteration), "save must be new instance Iteration");
    }

    @Test
    void TestUpdateNull() {
        assertEquals(Optional.empty(), tester.update(1, new Iteration()), "update must be Optional.empty()");
    }

    @Test
    void TestUpdateWithData() {
        Iteration iteration = new Iteration();
        Optional<Iteration> iterationOptional = Optional.of(iteration);
        when(iterationRepository.update(1, iteration)).thenReturn(iterationOptional);

        assertEquals(iterationOptional, tester.update(1, iteration), "update must be new instance Iteration");
    }
}
